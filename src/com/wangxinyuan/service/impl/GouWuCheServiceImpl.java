package com.wangxinyuan.service.impl;

import java.util.List;

import com.wangxinyuan.dao.CartDao;
import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.impl.CartDaoImpl;
import com.wangxinyuan.dao.impl.GoodsDaoImpl;
import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.GouWuCheService;

public class GouWuCheServiceImpl implements GouWuCheService {
	CartDao cartDao=new CartDaoImpl();
	GoodsDao goodsDao=new GoodsDaoImpl();
	@Override
	public List<Cart> listGouWuCheByUserId(int id) {
		
		return cartDao.listAllByUserId(id);
	}
	@Override
	public Goods GouWuCheByGoodsId(int id) {
		
		return goodsDao.listAllByUserId(id);
	}
	@Override
	public boolean updateXiaoJiByGoodsId(int cartId, int xiaoji, int number) {
		
		return cartDao.setXiaoJiByCartId(cartId, xiaoji, number);
	}
	
	@Override
	public boolean shanChuByCartId(int cartId) {
		
		return cartDao.shanChuByCartId(cartId);
	}
}
