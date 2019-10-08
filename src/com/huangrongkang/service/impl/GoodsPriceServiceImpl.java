package com.huangrongkang.service.impl;

import com.huangrongkang.dao.IGoodsPriceDao;
import com.huangrongkang.dao.impl.GoodsPriceDaoImpl;
import com.huangrongkang.dao.po.Goods_price;
import com.huangrongkang.service.IGoodsPriceService;

public class GoodsPriceServiceImpl implements IGoodsPriceService {
	IGoodsPriceDao priceDao = new GoodsPriceDaoImpl();
	@Override
	public Goods_price getByEditionId(Integer goodsId, Integer EditionId) {
		return priceDao.getByEditionId(goodsId, EditionId);
	}

}
