package com.mi.liaoweicheng.service.impl;

import java.util.List;

import com.mi.liaoweicheng.dao.UserDao;
import com.mi.liaoweicheng.dao.impl.UserDaoImpl;
import com.mi.liaoweicheng.dao.po.User;
import com.mi.liaoweicheng.service.UserService;

public class UserServiceImpl implements UserService
{
	private UserDao userDao=new UserDaoImpl();
	@Override
	public User loginService(User inUser) throws Exception
	{	
		return userDao.getUserByNameAndPassword(inUser);
	}
	@Override
	public User loginInfo(User inUser)
	{	
		return userDao.getUserByNameAndPassword(inUser);
	}
	@Override
	public List<User> listAll(Object... objects)
	{		
		return userDao.listAll(objects);
	}
	@Override
	public int update(User user)
	{
		return userDao.update(user);
	}	
	
}
