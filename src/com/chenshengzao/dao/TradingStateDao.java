package com.chenshengzao.dao;

import com.chenshengzao.dao.po.Trading_State;

public interface TradingStateDao {
	//����tradingId��ʾ����״̬
	public Trading_State getstateIdBydescription(int tradingId);
}
