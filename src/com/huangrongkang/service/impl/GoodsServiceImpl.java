package com.huangrongkang.service.impl;

import com.huangrongkang.dao.IGoodsDao;
import com.huangrongkang.dao.impl.GoodsDaoImpl;
import com.huangrongkang.dao.po.Goods;
import com.huangrongkang.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
	IGoodsDao goodsDao = new GoodsDaoImpl();
	@Override
	public Goods getById(int id) {
		return goodsDao.getById(id);
	}
}
