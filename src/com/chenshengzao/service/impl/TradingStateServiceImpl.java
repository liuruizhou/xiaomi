package com.chenshengzao.service.impl;

import com.chenshengzao.dao.TradingStateDao;
import com.chenshengzao.dao.impl.TradingStateDaoImpl;
import com.chenshengzao.dao.po.Trading_State;

public class TradingStateServiceImpl implements TradingStateDao{
	TradingStateDaoImpl ts=new TradingStateDaoImpl();
		
	public Trading_State getstateIdBydescription(int tradingId) {
		
		return ts.getstateIdBydescription(tradingId);
	}
}
