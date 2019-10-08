package com.chenshengzao.service;

import java.util.List;

import com.chenshengzao.dao.po.Orders;

public interface IOrdersService {
	//查询所有订单
	public List<Orders> getOrdersByuserId(int userId);
}
