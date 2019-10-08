package com.wangxinyuan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.GouWuCheService;
import com.wangxinyuan.service.impl.GouWuCheServiceImpl;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		/*GoodsDao yingjian=new GoodsDaoImpl();
		int id=19;
		List<Goods> lists=yingjian.listAllByTypeId(id);
		System.out.println(lists);*/
		
		/*CartDao cartDao=new CartDaoImpl();
		int id=1245;
		List<Cart> lists=cartDao.listAllByUserId(id);
		System.out.print(lists);*/
		ObjectMapper mapper=new ObjectMapper();
		GouWuCheService gouWuCheService=new GouWuCheServiceImpl();
		int id=1245;
		
		List<Cart> userCarts=gouWuCheService.listGouWuCheByUserId(id);
		List<Goods> gList=new ArrayList<Goods>();
		Map<String, Object[]> map=new HashMap<String, Object[]>();
		for (Cart cart : userCarts) {
			int id1=cart.getGoodsId();
			Goods userGoods=gouWuCheService.GouWuCheByGoodsId(id1);
			gList.add(userGoods);
		}
		map.put("Cart", userCarts.toArray());
		map.put("gList", gList.toArray());
	String string=mapper.writeValueAsString(map);
	System.out.println(string);
	
	
	
	}
}
