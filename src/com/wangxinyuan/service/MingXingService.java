package com.wangxinyuan.service;

import java.util.List;

import com.wangxinyuan.dao.po.Goods;

public interface MingXingService {
	public List<Goods> listMingXingByTypeId(int id);
	
}
