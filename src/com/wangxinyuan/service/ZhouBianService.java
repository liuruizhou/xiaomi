package com.wangxinyuan.service;

import java.util.List;

import com.wangxinyuan.dao.po.Goods;

public interface ZhouBianService {
	public List<Goods> listZhouBianByTypeId(int id);
}
