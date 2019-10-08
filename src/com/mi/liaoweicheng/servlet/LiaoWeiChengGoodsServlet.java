package com.mi.liaoweicheng.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liaoweicheng.dao.po.Goods;
import com.mi.liaoweicheng.dao.po.User;
import com.mi.liaoweicheng.service.GoodsService;
import com.mi.liaoweicheng.service.UserService;
import com.mi.liaoweicheng.service.impl.GoodsServiceImpl;
import com.mi.liaoweicheng.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class LiaoWeiChengGoodsServlet extends BaseServlet
{
	GoodsService goodsService=new GoodsServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	//��Ʒ
	public void match(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		int typeId=Integer.parseInt(request.getParameter("typeId"));
		List<Goods> goodsList= goodsService.getGoodsByTypeId(typeId);
		String goodsListJson="";
		try {
			goodsListJson=mapper.writeValueAsString(goodsList);
		} catch (JsonProcessingException e) {
			System.err.println("typeId="+typeId+"ʱ��ת��ΪJson���ִ���");
			e.printStackTrace();
		}
		response.getWriter().print(goodsListJson);
	}
	
	UserService userService=new UserServiceImpl();
	//��¼
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws Exception
	{		
		//1.�ռ�����
		String userid=request.getParameter("userid").trim();
		List<User> users = userService.listAll(Integer.parseInt(userid));
		String userJson=mapper.writeValueAsString(users.get(0));
		response.getWriter().print(userJson);
		/*System.out.println(userJson);*/
	}
	
	
	//�û��޸�
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//1.�ռ�����
		String idStr=request.getParameter("user_id");
		String userNickname=request.getParameter("userNickname");
		String phone=request.getParameter("phone");
		String personalizedSignature=request.getParameter("personalizedSignature");
		String hobby=request.getParameter("hobby");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		//2.��֯���ݣ���װ����
		User user=userService.listAll(Integer.parseInt(idStr)).get(0);
		user.setUser_nickname(userNickname);
		user.setPhone(phone);
		user.setPersonalized_signature(personalizedSignature);
		user.setHobby(hobby);
		user.setAddress(address);
		user.setEmail(email);
		//3.�����߼���API
		int rows=userService.update(user);
		if(rows>0){
			response.getWriter().print(true);
		}else {
			response.getWriter().print(false);
		}
	}
}
