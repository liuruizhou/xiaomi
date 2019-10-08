package com.mi.liuruizhou.dao.impl;

import java.util.Date;

import com.mi.liuruizhou.dao.OrdersDao;
import com.mi.liuruizhou.dao.po.Orders;
import com.mi.liuruizhou.dao.utils.JdbcUtil;

public class OrdersDaoImpl implements OrdersDao {

	@Override
	public int save(Orders orders) {
		//INSERT INTO orders (`id`, `goods_id`, `order_number`, `price`, `trading_hour`, `state_id`, `user_id`) VALUES ('10300502', '10300602', '181023001026545', '2499', '2018-10-22', '1', '1245');
		//INSERT INTO orders VALUES ('10300503', '10300602', '181023001026545', '2499', '2018-10-22', '1', '1245');
		String saveSql = "INSERT INTO orders (goods_id, order_number, price, trading_hour, state_id, user_id) VALUES (?, ?, ?, ?, ?, ?)";
		Object[] objects = {orders.getGoodsId(),orders.getOrderNumber(),orders.getPrice(),orders.getTradingHour(),orders.getStateId(),orders.getUserId()};
		return JdbcUtil.excuteUpdate(saveSql, objects);
	}

}
