package com.huangrongkang.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HuangRongKangBaseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		if (action==null || action.trim().equals("")) {
			response.getWriter().write("你输入的是非法参数");
		}
		try {
			Method method = this.getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("你输入的是非法参数");
		}
		
	}
}
