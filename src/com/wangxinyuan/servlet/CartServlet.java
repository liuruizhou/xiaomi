package com.wangxinyuan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxinyuan.dao.po.Cart;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.GouWuCheService;
import com.wangxinyuan.service.JoinCartService;
import com.wangxinyuan.service.impl.GouWuCheServiceImpl;
import com.wangxinyuan.service.impl.JoinCartServiceImpl;

@SuppressWarnings("serial")
public class CartServlet extends BaseServlet {
	GouWuCheService gouWuCheService=new GouWuCheServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	public void userCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("userId");
		int id=Integer.parseInt(str);
		ObjectMapper mapper=new ObjectMapper();
		GouWuCheService gouWuCheService=new GouWuCheServiceImpl();
		List<Cart> userCarts=gouWuCheService.listGouWuCheByUserId(id);
		List<Goods> gList=new ArrayList<Goods>();
		Map<String, Object[]> map=new HashMap<String, Object[]>();
		for (Cart cart : userCarts) {
			int id1=cart.getGoodsId();
			Goods userGoods=gouWuCheService.GouWuCheByGoodsId(id1);
			gList.add(userGoods);
		}
		map.put("cart", userCarts.toArray());
		map.put("gList", gList.toArray());
		String string=mapper.writeValueAsString(map);
		response.getWriter().print(string);
		//System.out.println(string);
	}
	
	public void setxiaoji(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("Cartid");
		String str1=request.getParameter("subtotal");
		String str2=request.getParameter("shuliang");
		int xiaoji=Integer.parseInt(str1);
		int shuliang=Integer.parseInt(str2);
		int id=Integer.parseInt(str);
		GouWuCheService gouWuCheService=new GouWuCheServiceImpl();
		boolean flag=gouWuCheService.updateXiaoJiByGoodsId(id, xiaoji, shuliang);
		//System.out.println(flag);
	}
	
	public void shanchu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("Cartid");
		int id=Integer.parseInt(str);
		GouWuCheService gouWuCheService=new GouWuCheServiceImpl();
		boolean flag=gouWuCheService.shanChuByCartId(id);
		//System.out.println(flag);
	}
	
	
	public void goCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsid=request.getParameter("Goodsid");
		String userId=request.getParameter("UserId");
		String price=request.getParameter("price");
		int goodsId=Integer.parseInt(goodsid);
		int useRId=Integer.parseInt(userId);
		Cart cart=new Cart();
		cart.setGoodsId(goodsId);
		cart.setUserId(useRId);
		cart.setSubtotal(price);
		JoinCartService joinCartService=new JoinCartServiceImpl();
		joinCartService.saveCart(cart);
		
	}
	
}
