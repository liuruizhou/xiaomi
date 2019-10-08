package com.mi.liaoweicheng.test;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liaoweicheng.dao.po.Goods;
import com.mi.liaoweicheng.service.GoodsService;
import com.mi.liaoweicheng.service.impl.GoodsServiceImpl;

public class TestGoodsServiceImpl
{
	GoodsService goodsService=new GoodsServiceImpl();
	@Test
	public void tsetGetGoodsByTypeId() {
		List<Goods> goodsList=goodsService.getGoodsByTypeId(32);
		for (Goods goods : goodsList) {
			System.out.println(goods);
		}
		ObjectMapper mapper=new ObjectMapper();
		String goodsListJson = "";
		try {
			goodsListJson = mapper.writeValueAsString(goodsList);
		} catch (JsonProcessingException e) {
			System.err.println("goodsList转为Json失败");
			e.printStackTrace();
		}
		System.out.println(goodsListJson);
	}
}
