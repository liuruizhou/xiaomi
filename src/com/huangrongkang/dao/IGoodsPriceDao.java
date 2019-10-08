package com.huangrongkang.dao;

import com.huangrongkang.dao.po.Goods_price;

public interface IGoodsPriceDao {
	public Goods_price getByEditionId(Integer goodsId,Integer EditionId);
}
