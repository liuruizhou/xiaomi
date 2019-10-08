package com.mi.liaoweicheng.dao.test;

import org.junit.Test;

import com.mi.liaoweicheng.dao.UserDao;
import com.mi.liaoweicheng.dao.impl.UserDaoImpl;
import com.mi.liaoweicheng.dao.po.User;

public class TestUser
{
	UserDao userDao=new UserDaoImpl();
	@Test
	public void update(){
		User user=new User(10210233, "130656", "文天", "111", "13048225823", "人生自古谁无死，留取丹心照汗青！", "	XXXXXXXXXX", "零丁洋里叹零丁","12121212122@163.com");
		int row=userDao.update(user);
		System.out.println(row);
	}
}
