package com.mi.liaoweicheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.liaoweicheng.dao.UserDao;
import com.mi.liaoweicheng.dao.po.User;
import com.mi.liaoweicheng.dao.utils.JdbcUtil;

public class UserDaoImpl implements UserDao
{
	@Override
	public User getUserByNameAndPassword(User inUser)
	{
		User resultUser = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1.加载驱动			
			// 2.得到数据库连接Connection接口指向的对象
			conn = JdbcUtil.getConnection();
			// 3.得到Statement接口指向的对象sate，用sate发送sql语句到数据库中执行，返回结果集
			String getUserByNameAndPasswordSql = "SELECT * FROM user WHERE user_nickname= ? and `password`=? ";
			ps = conn.prepareStatement(getUserByNameAndPasswordSql);
			ps.setObject(1, inUser.getUser_nickname());
			ps.setObject(2, inUser.getPassword());
			rs = ps.executeQuery();
			// 4.处理结果
			if (rs.next()) {
				/*
				 * 一条记录对应一个对象 把数据库中的一条记录封装到一个对象中
				 */
				resultUser = new User();
				resultUser.setUser_id(rs.getInt("user_id"));
				resultUser.setUser_account(rs.getString("user_account"));
				resultUser.setUser_nickname(rs.getString("user_nickname"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setPhone(rs.getString("phone"));
				resultUser.setPersonalized_signature(rs.getString("personalized_signature"));
				resultUser.setHobby(rs.getString("hobby"));
				resultUser.setAddress(rs.getString("address"));
				resultUser.setAddress(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return resultUser;
	}
	@Override
	public List<User> listAll(Object... objects)
	{
		List<User> usersList  =  new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		String allUserSql = "select * from user ";
		if (objects.length>0)
		{
			allUserSql+="where user_id="+objects[0].toString();
		}
		try {
			ps  = conn.prepareStatement(allUserSql);
			rs = ps.executeQuery();
			if (rs.next()) {
				User users = new User();
				users.setUser_id(rs.getInt("user_id"));
				users.setUser_account(rs.getString("user_account"));
				users.setUser_nickname(rs.getString("user_nickname"));
				users.setPassword(rs.getString("password"));
				users.setPhone(rs.getString("phone"));
				users.setPersonalized_signature(rs.getString("personalized_signature"));
				users.setHobby(rs.getString("hobby"));
				users.setAddress(rs.getString("address"));
				users.setEmail(rs.getString("email"));
				usersList.add(users);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return usersList;
	}
	@Override
	public int update(User user){
		String updateSql="update user set user_nickname=?,password=?,phone=?,personalized_signature=?,hobby=?,address=?,email=? where user_id=? and user_account=?";
		Object[] objects={user.getUser_nickname(),user.getPassword(),user.getPhone(),user.getPersonalized_signature(),user.getHobby(),user.getAddress(),user.getEmail(),user.getUser_id(),user.getUser_account()};
		return JdbcUtil.excuteUpdate(updateSql, objects);
	}
	

}
