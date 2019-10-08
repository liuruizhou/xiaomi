package com.chenshengzao.service.impl;

import java.util.List;

import com.chenshengzao.dao.IGoodsDao;
import com.chenshengzao.dao.impl.GoodsDaoImpl;
import com.chenshengzao.dao.po.Goods;
import com.chenshengzao.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
	IGoodsDao goods=new GoodsDaoImpl();
		
	@Override
	public List<Goods> getGoodsBytypeId(int typeId) {
		return goods.getGoodsBytypeId(typeId);
	}

	@Override
	public Goods getGoodsIdBypiPath(int goodsId) {
		return goods.getGoodsIdBypiPath(goodsId);
	}

	
}
