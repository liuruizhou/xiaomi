package com.mi.liuruizhou.service.impl;

import com.mi.liuruizhou.dao.UserDao;
import com.mi.liuruizhou.dao.impl.UserDaoImpl;
import com.mi.liuruizhou.dao.po.User;
import com.mi.liuruizhou.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao=new UserDaoImpl();
	@Override
	public int save(User user) {
		return userDao.save(user);
	}

}
