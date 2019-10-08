package com.huangrongkang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangrongkang.dao.po.Color;
import com.huangrongkang.service.IColorService;
import com.huangrongkang.service.impl.ColorServiceImpl;


public class HuangRongKangColorServlet extends HuangRongKangBaseServlet {
	IColorService colorService = new ColorServiceImpl();
	ObjectMapper mapper = new ObjectMapper();
	public void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("colorId");
		Color color=colorService.getById(Integer.parseInt(idStr));
		String colorJson="";
		try {
			colorJson=mapper.writeValueAsString(color);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(colorJson);
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if(idStr==null || idStr.trim().equals(""))
		{
			idStr="10408011";
		}
		List<Color> list=colorService.listAll(Integer.parseInt(idStr));
		String colorJson="";
		try {
			colorJson=mapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().print(colorJson);
	}
}
