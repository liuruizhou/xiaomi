package com.mi.liuruizhou.test;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liuruizhou.dao.GoodsDao;
import com.mi.liuruizhou.dao.impl.GoodsDaoImpl;
import com.mi.liuruizhou.dao.po.Goods;

public class GoodsDaoImplTest {
	GoodsDao goodsDao=new GoodsDaoImpl();
	@Test
	public void tsetGetGoodsByTypeId() {
		List<Goods> goodsList=goodsDao.getGoodsByTypeId(8);
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
		ObjectMapper mapper=new ObjectMapper();
		String goodsListJson = "";
		try {
			goodsListJson = mapper.writeValueAsString(goodsList);
		} catch (JsonProcessingException e) {
			System.err.println("goodsList×ªÎªJsonÊ§°Ü");
			e.printStackTrace();
		}
		System.out.println(goodsListJson);
	}
}
