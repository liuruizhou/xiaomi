package com.chenshengzao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenshengzao.dao.po.Goods;
import com.chenshengzao.service.IGoodsService;
import com.chenshengzao.service.impl.GoodsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
@WebServlet("/ChenShengZaoGoodsServlet")
public class GoodsServlet extends BaseServlet {
	IGoodsService goodsService=new GoodsServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	public void getGoodsBytypeId(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		List<Goods> list=goodsService.getGoodsBytypeId(typeId);
		String goodsListJson="";
		goodsListJson=mapper.writeValueAsString(list);
		response.getWriter().print(goodsListJson);	
		//System.out.println(goodsListJson);
	}
	//根据goods_id查询所对应的商品图片
	public void getGoodsIdBypiPath(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		Goods goods=goodsService.getGoodsIdBypiPath(goodsId);
		String goodslistJson=mapper.writeValueAsString(goods);
		response.getWriter().print(goodslistJson);
			
	}
	
}
