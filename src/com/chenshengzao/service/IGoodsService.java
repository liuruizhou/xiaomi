package com.chenshengzao.service;

import java.util.List;

import com.chenshengzao.dao.po.Goods;

public interface IGoodsService {
	//������Ʒ���Ͳ�ѯ��Ʒ��Ϣ 
	public List<Goods> getGoodsBytypeId(int typeId);
	
	//����goods_id��ѯ��ƷͼƬ
	public Goods getGoodsIdBypiPath(int goodsId);
}
