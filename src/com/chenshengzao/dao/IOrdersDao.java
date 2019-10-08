package com.chenshengzao.dao;

import java.util.List;

import com.chenshengzao.dao.po.Orders;

public interface IOrdersDao {
	//查询用户的所有订单
	public List<Orders> getOrdersByuserId(int usedId);
}
