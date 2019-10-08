package com.mi.liuruizhou.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		try {
			Method method = this.getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request, response);
		} catch (Exception e) {
			e.printStackTrace();
			//错误信息提示框
			response.getWriter().write("<script>alert('当前浏览器奔溃，请跟新到最新版');window.history.go(-1);</script>");
		}
	}
}
