package com.chenshengzao.service;

import java.util.List;

import com.chenshengzao.dao.po.Orders;

public interface IOrdersService {
	//��ѯ���ж���
	public List<Orders> getOrdersByuserId(int userId);
}
