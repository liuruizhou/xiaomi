package com.mi.liuruizhou.dao.impl;


import com.mi.liuruizhou.dao.UserDao;
import com.mi.liuruizhou.dao.po.User;
import com.mi.liuruizhou.dao.utils.JdbcUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(User user) {
		String saveSql = "INSERT INTO user (user_id, user_account, user_nickname, password, phone, personalized_signature, hobby, address) VALUES (?,?,?, ?, ?, ?,?,?)";
		Object[] objects = {user.getUserId(),user.getUserAccount(),user.getUserNickname(),user.getPassword(),
				user.getPhone(),user.getPersonalizedSignature(),user.getHobby(),user.getAddress()};
		return JdbcUtil.excuteUpdate(saveSql, objects);
	}

}
