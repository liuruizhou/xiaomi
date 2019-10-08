package com.huangrongkang.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huangrongkang.dao.po.User;
import com.huangrongkang.service.IUserService;
import com.huangrongkang.service.impl.UserServiceImpl;


public class HuangRongKangLoginServlet extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password=request.getParameter("password");
		User myUser = new User();
		myUser.setUserAccount(userName);
		myUser.setPassword(password);
		HttpSession session = request.getSession();
		try {
			User user = userService.login(myUser);
			if (user==null) {
				session.setAttribute("msg", "用户名或密码错误");
				response.sendRedirect("login.jsp");
			}else
			{
				session.setAttribute("user", user);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			session.setAttribute("msg", "用户名或密码错误");
			response.sendRedirect("login.jsp");
			e.printStackTrace();
			
		}
	}
}
