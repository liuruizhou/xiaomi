package com.mi.liuruizhou.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.Page;
import com.mi.liuruizhou.service.GoodsService;
import com.mi.liuruizhou.service.impl.GoodsServiceImpl;

/**
 *
 */
@SuppressWarnings("serial")
public class GoodsServlet extends BaseServlet {
	GoodsService goodsService = new GoodsServiceImpl();
	ObjectMapper mapper = new ObjectMapper();

	public void sidenav(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		List<Goods> goodsList = goodsService.getGoodsByTypeId(typeId);
		String goodsListJson = "";
		try {
			goodsListJson = mapper.writeValueAsString(goodsList);
		} catch (JsonProcessingException e) {
			System.err.println("typeId=" + typeId + "时，转换为Json出现错误");
			e.printStackTrace();
		}
		response.getWriter().print(goodsListJson);
	}

	public void getPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String currentPageStr = request.getParameter("currentPage");
		String pageSizStr = request.getParameter("pageSize");
		String likesql = request.getParameter("likesql");
		String orderBy = request.getParameter("orderBy");
		int currentPage = 1;
		int pageSize = 20;
		if (currentPageStr != null && pageSizStr != null && !currentPageStr.equals("") && !currentPageStr.equals("")) {
			currentPage=Integer.parseInt(currentPageStr);
			pageSize=Integer.parseInt(pageSizStr);
		}
		if (likesql == null || likesql.equals("")) {
			likesql="";
		}
		if (orderBy == null || orderBy.equals("")) {
			orderBy="type_id";
		}
		Page<Goods> goodsPage = goodsService.getPage(currentPage, pageSize, likesql, orderBy);
		String goodsPageJson = mapper.writeValueAsString(goodsPage);
		response.getWriter().print(goodsPageJson);
	}
	public void getGoodsNameList(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String term=request.getParameter("term");
		if (request.getParameter("term")==null) {
			term="";
		}
		List<String> nameList=goodsService.getGoodsNameList(term);
		String nameListJson=mapper.writeValueAsString(nameList);
		response.getWriter().print(nameListJson);
	}
}














