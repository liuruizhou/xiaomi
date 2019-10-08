package com.huangrongkang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huangrongkang.dao.po.Goods;
import com.huangrongkang.service.IGoodsService;
import com.huangrongkang.service.impl.GoodsServiceImpl;


public class HuangRongKangGoodsServlet extends HuangRongKangBaseServlet {
	IGoodsService goodsService = new GoodsServiceImpl();
	public void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr==null)
		{
			idStr="10408011";
		}
		Goods goods = goodsService.getById(Integer.parseInt(idStr));
		
		HttpSession session = request.getSession();
		if (goods!=null) {
			session.setAttribute("goods", goods);
			response.sendRedirect("detail.jsp");
		}else
		{
			response.sendRedirect("index.jsp");
		}
	}
}
