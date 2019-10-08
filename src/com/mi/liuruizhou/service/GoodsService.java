package com.mi.liuruizhou.service;

import java.util.List;

import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;

public interface GoodsService {
	/**
	 * 根据类型id查商品信息
	 * @return List<Goods>商品信息集合
	 */
	public List<Goods> getGoodsByTypeId(int typeId);
	/**
	 * 获取分页信息
	 * @param currentPage当前页面
	 * @param pageSize一页多少条记录
	 * @return
	 * @throws Exception
	 */
	public Page<Goods> getPage(int currentPage, int pageSize,String likesql,String orderBy) throws Exception;
	/**
	 * 获取所有的商品名（不重复）
	 * @return
	 */
	public List<String> getGoodsNameList(String term);
}
