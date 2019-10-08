package com.mi.liuruizhou.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.liuruizhou.dao.po.Orders;
import com.mi.liuruizhou.service.OrdersService;
import com.mi.liuruizhou.service.impl.OrdersServiceImpl;
//LiuRuizhouOrdersServlet
//LiuRuizhouOrdersServlet?action=save&goodsId=10300602&price=2499&userId=1245
public class OrdersServlet extends BaseServlet {
	OrdersService ordersService=new OrdersServiceImpl();
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String goodsIdStr=request.getParameter("goodsId");
		String priceStr=request.getParameter("price");
		String userIdStr=request.getParameter("userId");
		Orders orders = new Orders();
		orders.setGoodsId(Integer.parseInt(goodsIdStr));
		orders.setOrderNumber(UUID.randomUUID().toString());
		orders.setPrice(priceStr);
		orders.setTradingHour(new Date());
		orders.setStateId(1);
		orders.setUserId(Integer.parseInt(userIdStr));
		int rows=ordersService.save(orders);
		if (rows>0) {
			response.getWriter().print(true);
		}else {
			response.getWriter().print(false);
		}
		//Orders orders = new Orders(0, 10300602, "181023001026545", "2499", new Date(), 1, 1245);
		//Orders orders = new Orders(goodsId, orderNumber, price, tradingHour, stateId, userId);
	}
}
