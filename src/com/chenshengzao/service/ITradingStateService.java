package com.chenshengzao.service;

import com.chenshengzao.dao.po.Trading_State;

public interface ITradingStateService {
	//����state_id��ʾ����״̬
	public Trading_State getstateIdBydescription(int tradingId);
}
