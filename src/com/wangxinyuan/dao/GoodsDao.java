package com.wangxinyuan.dao;

import java.util.List;

import com.wangxinyuan.dao.po.Goods;

public interface GoodsDao {
	public List<Goods> listAllByTypeId(int id);
	public Goods listAllByUserId(int id);
}
