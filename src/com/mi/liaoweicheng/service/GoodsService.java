package com.mi.liaoweicheng.service;

import java.util.List;

import com.mi.liaoweicheng.dao.po.Goods;

public interface GoodsService
{
	
	/**
	 * 根据类型id查商品信息
	 * @return List<Goods>商品信息集合
	 */
	public List<Goods> getGoodsByTypeId(int typeId);
}
