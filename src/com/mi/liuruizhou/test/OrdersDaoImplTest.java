package com.mi.liuruizhou.test;


import java.util.Date;

import org.junit.Test;

import com.mi.liuruizhou.dao.po.Orders;
import com.mi.liuruizhou.service.OrdersService;
import com.mi.liuruizhou.service.impl.OrdersServiceImpl;

public class OrdersDaoImplTest {
	OrdersService ordersService=new OrdersServiceImpl();
	@Test
	public void testSave() {
		Orders orders = new Orders(0, 10300602, "181023001026545", "2499", new Date(), 1, 1245);
		int i=ordersService.save(orders);
		if (i>0) {
			System.out.println("±£´æ³É¹¦");
		}
	}

}
