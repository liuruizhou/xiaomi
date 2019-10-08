package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huangrongkang.dao.IUserDao;
import com.huangrongkang.dao.po.User;
import com.huangrongkang.dao.util.JdbcUtil;


public class UserDaoImpl implements IUserDao {

	@Override
	public User login(User user) {
		User myUser=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConn();
		String sql="select * from user where user_account=? and password=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, user.getUserAccount());
			pstmt.setObject(2, user.getPassword());
			rs=pstmt.executeQuery();
			if (rs.next()) {
				myUser = new User();
				myUser.setUserId(rs.getInt("user_id"));
				myUser.setUserAccount(rs.getString("user_account"));
				myUser.setUserNickname(rs.getString("user_nickname"));
				myUser.setPassword(rs.getString("password"));
				myUser.setPhone(rs.getString("phone"));
				myUser.setPersonalizedSignature(rs.getString("personalized_signature"));
				myUser.setHobby(rs.getString("hobby"));
				myUser.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return myUser;
	}

	@Override
	public User getById(int id) {
		User user = null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConn();
		String sql="select * from user where user_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserAccount(rs.getString("user_account"));
				user.setUserNickname(rs.getString("user_nickname"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setPersonalizedSignature(rs.getString("personalized_signature"));
				user.setHobby(rs.getString("hobby"));
				user.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return user;
	}

	@Override
	public int update(User user) {
		String sql="update user set user_account=?,user_nickname=?,password=?,phone=?,personalized_signature=?,hobby=?,address=? where user_id=?";
		Object object[]= {
				user.getUserAccount()
				,user.getUserNickname()
				,user.getPassword()
				,user.getPhone()
				,user.getPersonalizedSignature()
				,user.getHobby()
				,user.getAddress()
				,user.getUserId()
		};
		return JdbcUtil.executeUpdate(sql, object);
	}

}
