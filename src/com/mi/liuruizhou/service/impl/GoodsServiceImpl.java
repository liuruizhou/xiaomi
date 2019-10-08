package com.mi.liuruizhou.service.impl;

import java.util.List;

import com.mi.liuruizhou.dao.GoodsDao;
import com.mi.liuruizhou.dao.impl.GoodsDaoImpl;
import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;
import com.mi.liuruizhou.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao goodsDao=new GoodsDaoImpl();
	@Override
	public List<Goods> getGoodsByTypeId(int typeId) {
		return goodsDao.getGoodsByTypeId(typeId);
	}
	@Override
	public Page<Goods> getPage(int currentPage, int pageSize,String likesql,String orderBy) throws Exception {
		Page<Goods> adminPage=goodsDao.getPage(currentPage, pageSize,likesql,orderBy);
		if (adminPage==null) {
			throw new Exception("查询不到，无记录！！");
		}
		return adminPage;
	}
	@Override
	public List<String> getGoodsNameList(String term) {
		return goodsDao.getGoodsNameList(term);
	}

}
