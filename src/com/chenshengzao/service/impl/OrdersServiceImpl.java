package com.chenshengzao.service.impl;

import java.util.List;

import com.chenshengzao.dao.impl.OrdersDaoImpl;
import com.chenshengzao.dao.po.Orders;
import com.chenshengzao.service.IOrdersService;

public class OrdersServiceImpl  implements IOrdersService{
	OrdersDaoImpl orders=new OrdersDaoImpl();
	@Override
	public List<Orders> getOrdersByuserId(int userId) {
		
		return orders.getOrdersByuserId(userId);
	}
}
