package com.chenshengzao.dao;

import com.chenshengzao.dao.po.Trading_State;

public interface TradingStateDao {
	//根据tradingId显示订单状态
	public Trading_State getstateIdBydescription(int tradingId);
}
