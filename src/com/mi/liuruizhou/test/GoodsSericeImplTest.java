package com.mi.liuruizhou.test;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;
import com.mi.liuruizhou.service.GoodsService;
import com.mi.liuruizhou.service.impl.GoodsServiceImpl;

public class GoodsSericeImplTest {
	GoodsService goodsService=new GoodsServiceImpl();
	@Test
	public void tsetGetGoodsByTypeId() {
		List<Goods> goodsList=goodsService.getGoodsByTypeId(8);
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
	@Test
	public void tsetGetPage() throws Exception {
		Page<Goods> goodsPage =goodsService.getPage(1, 5,"电视","type_id");
		System.out.println("总记录数="+goodsPage.getCount());
		System.out.println("当前页码="+goodsPage.getCurrentPage());
		System.out.println("一页多少条="+goodsPage.getPageSize());
		System.out.println("总页码="+goodsPage.getTotalPage());
		for (Goods goods : goodsPage.getLists()) {
			System.out.println(goods);
		}
//		ObjectMapper mapper=new ObjectMapper();
//		System.out.println(mapper.writeValueAsString(goodsPage));
	}
	@Test
	public void testGetGoodsNameList() {
		for (String string : goodsService.getGoodsNameList("电视")) {
			System.out.println(string);
		}
	}
}











