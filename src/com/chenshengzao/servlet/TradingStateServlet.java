package com.chenshengzao.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenshengzao.dao.po.Trading_State;
import com.chenshengzao.service.impl.TradingStateServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet("/ChenShengZaoTradingStateServlet")
public class TradingStateServlet extends BaseServlet{
    TradingStateServiceImpl  ts=new TradingStateServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	
	
	public void gettradingBydescription(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		int tradingId=Integer.parseInt(request.getParameter("tradingId"));
		Trading_State state=ts.getstateIdBydescription(tradingId);
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("state", state.getDescription());
		String orderslistJson=mapper.writeValueAsString(map);
		response.getWriter().print(orderslistJson);
	}
}
