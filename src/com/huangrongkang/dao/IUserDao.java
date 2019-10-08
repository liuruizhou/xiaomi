package com.huangrongkang.dao;

import com.huangrongkang.dao.po.User;

public interface IUserDao {
	public User login(User user);
	public User getById(int id);
	public int update(User user);
}
