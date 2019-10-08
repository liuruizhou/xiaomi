package com.chenshengzao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenshengzao.dao.po.Goods;
import com.chenshengzao.dao.po.Orders;
import com.chenshengzao.dao.po.Trading_State;
import com.chenshengzao.service.IGoodsService;
import com.chenshengzao.service.impl.GoodsServiceImpl;
import com.chenshengzao.service.impl.OrdersServiceImpl;
import com.chenshengzao.service.impl.TradingStateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet("/ChenShengZaoOrdersServlet")
public class OrdersServlet extends BaseServlet{
	OrdersServiceImpl ordersService=new OrdersServiceImpl();
	IGoodsService goodsService=new GoodsServiceImpl();
	TradingStateServiceImpl  ts=new TradingStateServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	//查询所有的订单
	public void getOrdersByuserId(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		int userId=Integer.parseInt(request.getParameter("userId"));
		List<Orders> Orderslist=ordersService.getOrdersByuserId(userId);
		List<Trading_State> states=new ArrayList<Trading_State>();
		List<Goods> goodsList=new ArrayList<Goods>();
		for (Orders orders : Orderslist) {
			Trading_State state= ts.getstateIdBydescription(orders.getStateId());
			Goods goods=goodsService.getGoodsIdBypiPath(orders.getGoodsId());
			states.add(state);
			goodsList.add(goods);
		}
		Map<String, Object[]> map=new HashMap<String, Object[]>();
		map.put("Orderslist", Orderslist.toArray());
		map.put("states", states.toArray());
		map.put("goodsList", goodsList.toArray());
		String mapJson= mapper.writeValueAsString(map);
		response.getWriter().print(mapJson);
	}
	
}
