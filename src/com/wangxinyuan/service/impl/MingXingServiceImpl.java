package com.wangxinyuan.service.impl;

import java.util.List;

import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.impl.GoodsDaoImpl;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.MingXingService;

public class MingXingServiceImpl implements MingXingService {
	GoodsDao mingxing=new GoodsDaoImpl();
	@Override
	public List<Goods> listMingXingByTypeId(int id) {
		
		return mingxing.listAllByTypeId(id);
	}

}
