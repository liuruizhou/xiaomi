package com.wangxinyuan.service.impl;

import java.util.List;

import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.impl.GoodsDaoImpl;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.ZhouBianService;

public class ZhouBianServiceImpl implements ZhouBianService {
	GoodsDao zhoubian=new GoodsDaoImpl();
	@Override
	public List<Goods> listZhouBianByTypeId(int id) {
		
		return zhoubian.listAllByTypeId(id);
	}

}
