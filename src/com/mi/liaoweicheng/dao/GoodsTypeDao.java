package com.mi.liaoweicheng.dao;

import java.util.List;

import com.mi.liaoweicheng.dao.po.GoodType;

public interface GoodsTypeDao
{	
	/**
	 * 根据typeid查询类型
	 * @param typeId
	 * @return
	 */
	public GoodType getById(int typeId);
	/**
	 * 查询所有类型
	 * @return
	 */
	public List<GoodType> listAll();
}
