package com.huangrongkang.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangrongkang.dao.po.Edition;
import com.huangrongkang.dao.po.Goods_price;
import com.huangrongkang.service.IEditionService;
import com.huangrongkang.service.IGoodsPriceService;
import com.huangrongkang.service.impl.EditionServiceImpl;
import com.huangrongkang.service.impl.GoodsPriceServiceImpl;


public class HuangRongKangEditionServlet extends HuangRongKangBaseServlet {
	IEditionService editionService = new EditionServiceImpl();
	ObjectMapper mapper = new ObjectMapper();
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr==null || idStr.trim().equals(""))
		{
			idStr="10408011";
		}
		List<Edition> edlist=editionService.listAll(Integer.parseInt(idStr));
		List<Goods_price> goods_prices=new ArrayList<Goods_price>();
		for (Edition edition : edlist) {
			Goods_price e=getGoods_price(Integer.parseInt(idStr),edition.getEditionId());
			goods_prices.add(e);
		}
		String editionJson="";
		Map<String, Object[]> map=new HashMap<String,Object[]>();
		try {
			map.put("edlist", edlist.toArray());
			map.put("goods_prices", goods_prices.toArray());
			editionJson=mapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(editionJson);
	}
	
	IGoodsPriceService goodsPriceService = new GoodsPriceServiceImpl();
	public Goods_price getGoods_price(Integer goodsId,Integer EditionId){
		Goods_price price = goodsPriceService.getByEditionId(goodsId, EditionId);
		return price;
	}
}
