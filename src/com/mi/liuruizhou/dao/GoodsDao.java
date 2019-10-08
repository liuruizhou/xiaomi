package com.mi.liuruizhou.dao;

import java.util.List;

import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;

public interface GoodsDao {
	/**
	 * 根据类型id查商品信息
	 * @return List<Goods>商品信息集合
	 */
	public List<Goods> getGoodsByTypeId(int typeId);
	/**
	 * 获取总记录数
	 */
	public int getTotalCount(String like);
	/**
	 * 获取页面的全部信息
	 */
	public List<Goods> getOnePageInfo(int currentPage,int pageSize,String likesql,String orderBy);
	/**
	 * 封装当前页面的全部信息到pageBean
	 * @param currentPage当前页面
	 * @param pageSize一夜多少条
	 */
	public Page<Goods> getPage(int currentPage,int pageSize,String likesql,String orderBy);
	/**
	 * 获取所有的商品名（不重复）
	 * @return
	 */
	public List<String> getGoodsNameList(String term);
}
