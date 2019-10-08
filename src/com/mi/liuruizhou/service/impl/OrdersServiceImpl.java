package com.mi.liuruizhou.service.impl;

import com.mi.liuruizhou.dao.OrdersDao;
import com.mi.liuruizhou.dao.impl.OrdersDaoImpl;
import com.mi.liuruizhou.dao.po.Orders;
import com.mi.liuruizhou.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	OrdersDao ordersDao=new OrdersDaoImpl();
	@Override
	public int save(Orders orders) {
		return ordersDao.save(orders);
	}

}
