package com.wangxinyuan.service;

import java.util.List;

import com.wangxinyuan.dao.po.Goods;

public interface YingJianService {
	public List<Goods> listYingJianByTypeId(int id);
	
}
