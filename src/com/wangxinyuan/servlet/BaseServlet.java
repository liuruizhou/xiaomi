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
		//���봦��
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getParameter("action");
		
		if (action==null||"".equals(action.trim())) {
			response.getWriter().print("��������ǷǷ�����");
			return;
		}
		 //�÷���õ�������Ӧ�ķ������󡣷��������δ����ȷ�������顣
		//�÷���õ�������Ӧ�ķ�������
		try {
			Method method = this.getClass().getMethod(action, HttpServletRequest.class,HttpServletResponse.class);
			//���ñ�����ķ�����
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("��������ǷǷ�����");
		} 
	}
}
