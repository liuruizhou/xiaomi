package com.wangxinyuan.service.impl;

import java.util.List;

import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.impl.GoodsDaoImpl;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.TuiJianService;

public class TuiJianServiceImpl implements TuiJianService {
	GoodsDao tuijian=new GoodsDaoImpl();
	@Override
	public List<Goods> listTuiJianByTypeId(int id) {
		
		return tuijian.listAllByTypeId(id);
	}

}
