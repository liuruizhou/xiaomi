package com.chenshengzao.dao;

import java.util.List;

import com.chenshengzao.dao.po.Orders;

public interface IOrdersDao {
	//��ѯ�û������ж���
	public List<Orders> getOrdersByuserId(int usedId);
}
