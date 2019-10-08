package com.mi.liaoweicheng.service.impl;

import java.util.List;

import com.mi.liaoweicheng.dao.GoodsDao;
import com.mi.liaoweicheng.dao.impl.GoodsDaoImpl;
import com.mi.liaoweicheng.dao.po.Goods;
import com.mi.liaoweicheng.service.GoodsService;

public class GoodsServiceImpl implements GoodsService
{
	private GoodsDao goodsDao=new GoodsDaoImpl();
	
	@Override
	public List<Goods> getGoodsByTypeId(int typeId)
	{
		return goodsDao.getGoodsByTypeId(typeId);
	}

}
