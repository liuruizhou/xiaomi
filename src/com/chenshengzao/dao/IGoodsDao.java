package com.chenshengzao.dao;

import java.util.List;

import com.chenshengzao.dao.po.Goods;

public interface IGoodsDao {
	//������Ʒ���Ͳ�ѯ��Ʒ��Ϣ 
	public List<Goods> getGoodsBytypeId(int typeId);
	
	//����goods_id��ѯ��ƷͼƬ
	public Goods getGoodsIdBypiPath(int goodsId);
}
