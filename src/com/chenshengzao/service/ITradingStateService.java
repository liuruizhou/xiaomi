package com.chenshengzao.service;

import com.chenshengzao.dao.po.Trading_State;

public interface ITradingStateService {
	//根据state_id显示订单状态
	public Trading_State getstateIdBydescription(int tradingId);
}
