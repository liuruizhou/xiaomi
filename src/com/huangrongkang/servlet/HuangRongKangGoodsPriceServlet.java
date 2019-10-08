package com.huangrongkang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangrongkang.dao.po.Goods_price;
import com.huangrongkang.service.IGoodsPriceService;
import com.huangrongkang.service.impl.GoodsPriceServiceImpl;


public class HuangRongKangGoodsPriceServlet extends HuangRongKangBaseServlet {
	/*IGoodsPriceService goodsPriceService = new GoodsPriceServiceImpl();
	ObjectMapper mapper = new ObjectMapper();
	public void list(Integer goodsid,Integer edid) throws ServletException, IOException {
		String goodsIdStr = request.getParameter("id");
		if(goodsIdStr==null || goodsIdStr.trim().equals(""))
		{
			goodsIdStr="10408011";
		}
		String EditionIdStr = request.getParameter("editionId");
		if (EditionIdStr==null || EditionIdStr.trim().equals("")) {
			EditionIdStr="1";
		}
		Integer goodsId = Integer.parseInt(goodsIdStr);
		Integer EditionId = Integer.parseInt(EditionIdStr);
		Goods_price price = goodsPriceService.getByEditionId(goodsId, EditionId);
		HttpSession session = request.getSession();
		if (price!=null) {
			session.setAttribute("price", price);
			response.sendRedirect("detail.jsp");
		}else
		{
			response.sendRedirect("detail.jsp");
		}
	}*/
}
