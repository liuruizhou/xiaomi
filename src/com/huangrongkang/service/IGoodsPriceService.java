package com.huangrongkang.service;


import com.huangrongkang.dao.po.Goods_price;


public interface IGoodsPriceService {
	public Goods_price getByEditionId(Integer goodsId,Integer EditionId);
}
