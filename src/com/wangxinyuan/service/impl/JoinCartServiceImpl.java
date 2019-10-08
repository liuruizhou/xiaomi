package com.wangxinyuan.service.impl;

import com.wangxinyuan.dao.CartDao;
import com.wangxinyuan.dao.impl.CartDaoImpl;
import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.service.JoinCartService;

public class JoinCartServiceImpl implements JoinCartService {
	CartDao cartDao=new CartDaoImpl();
	@Override
	public void saveCart(Cart cart) {
		cartDao.saveCart(cart);
	}

}
