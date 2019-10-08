package com.wangxinyuan.service.impl;

import java.util.List;

import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.impl.GoodsDaoImpl;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.YingJianService;

public class YingJianServiceImpl implements YingJianService {
	GoodsDao yingjian=new GoodsDaoImpl();
	@Override
	public List<Goods> listYingJianByTypeId(int id) {
		
		return yingjian.listAllByTypeId(id);
	}

}
