package com.mi.liaoweicheng.dao;

import java.util.List;

import com.mi.liaoweicheng.dao.po.User;

public interface UserDao
{
	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param inUser 封装用户名和密码实体类
	 * @return 成功返回用户的全部信息，失败返回null
	 */
	public User getUserByNameAndPassword(User inUser);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> listAll(Object... objects);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(User user);
}
