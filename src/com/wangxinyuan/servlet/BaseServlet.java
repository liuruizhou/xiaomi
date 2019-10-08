package com.wangxinyuan.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		
		if (action==null||"".equals(action.trim())) {
			response.getWriter().print("您输入的是非法参数");
			return;
		}
		 //用反射得到动作相应的方法对象。反射可以做未来不确定的事情。
		//用反射得到动作相应的方法对象。
		try {
			Method method = this.getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//调用本对象的方法。
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("您输入的是非法参数");
		} 
	}
}
