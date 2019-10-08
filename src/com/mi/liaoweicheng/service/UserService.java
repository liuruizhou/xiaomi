package com.mi.liaoweicheng.service;

import java.util.List;

import com.mi.liaoweicheng.dao.po.User;

public interface UserService
{
	public User loginService(User inUser) throws Exception;
	
	public User loginInfo(User inUser);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> listAll(Object... objects);
	//修改用户信息
	public int update(User user);
}
