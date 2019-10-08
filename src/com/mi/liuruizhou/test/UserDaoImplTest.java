package com.mi.liuruizhou.test;

import org.junit.Test;

import com.mi.liuruizhou.dao.UserDao;
import com.mi.liuruizhou.dao.impl.UserDaoImpl;
import com.mi.liuruizhou.dao.po.User;

public class UserDaoImplTest {
	UserDao userDao=new UserDaoImpl();
	@Test
	public void save() {
		int i=userDao.save(new User(10402, "1", "2", "3", "4", "5", "6", "7"));
		System.out.println(i);
	}
}
