package com.huangrongkang.service.impl;

import com.huangrongkang.dao.IUserDao;
import com.huangrongkang.dao.impl.UserDaoImpl;
import com.huangrongkang.dao.po.User;
import com.huangrongkang.service.IUserService;

public class UserServiceImpl implements IUserService{
	IUserDao userDao=new UserDaoImpl();
	@Override
	public User login(User user) throws Exception {
		User myUser =userDao.login(user);
		if (myUser==null) {
			throw new Exception("用户名或密码错误");
		}
		return myUser;
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

}
