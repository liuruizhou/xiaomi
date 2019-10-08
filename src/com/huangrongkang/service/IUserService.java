package com.huangrongkang.service;

import com.huangrongkang.dao.po.User;

public interface IUserService {
	public User login(User user) throws Exception;
	public User getById(int id);
	public int update(User user);
}
