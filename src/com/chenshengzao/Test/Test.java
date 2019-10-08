package com.chenshengzao.Test;

import java.util.List;

import com.chenshengzao.dao.impl.GoodsDaoImpl;
import com.chenshengzao.dao.impl.OrdersDaoImpl;
import com.chenshengzao.dao.po.Goods;
import com.chenshengzao.dao.po.Orders;
import com.chenshengzao.dao.po.Trading_State;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		Goods goods=goodsDao.getGoodsIdBypiPath(10100000);
		System.out.println(goods);
		
		
		
		//OrdersDaoImpl orderDao=new OrdersDaoImpl();
		/*List<Orders> orders=orderDao.getOrdersByuserId(1);
		for(Orders order:orders)
		{
			System.out.println(order);
		}*/
		
		/*Goods goods=orderDao.getGoodsIdBypiPath(10100001);
		System.out.println(goods);*/
		
		
//		Trading_State ts=orderDao.getstateIdBydescription(2);
//		System.out.println(ts);
	/*	String demo="123456.jpg";
		ObjectMapper mapper=new ObjectMapper();
		System.out.println(mapper.writeValueAsString(demo));*/
		
	}
	

}
