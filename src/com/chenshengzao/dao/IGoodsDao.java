package com.chenshengzao.dao;

import java.util.List;

import com.chenshengzao.dao.po.Goods;

public interface IGoodsDao {
	//根据商品类型查询商品信息 
	public List<Goods> getGoodsBytypeId(int typeId);
	
	//根据goods_id查询商品图片
	public Goods getGoodsIdBypiPath(int goodsId);
}
