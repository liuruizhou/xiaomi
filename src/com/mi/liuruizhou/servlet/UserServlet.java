package com.mi.liuruizhou.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.liuruizhou.dao.po.User;
import com.mi.liuruizhou.service.UserService;
import com.mi.liuruizhou.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class UserServlet extends BaseServlet {
	UserService userService=new UserServiceImpl();
	
	@SuppressWarnings("unused")
	public void save(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user = new User();
		user.setUserAccount(username);
		user.setPassword(password);
		if (userService.save(user)>0) {
			response.getWriter().println("<script>alert('注册成功');window.location.href='login.jsp'</script>");
		}
	}
	public void zhuxiao(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.getWriter().println("<script>alert('已退出登陆');window.location.href='login.jsp'</script>");

	}
}
