package com.huangrongkang.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangrongkang.dao.po.Picture;
import com.huangrongkang.service.IPictureService;
import com.huangrongkang.service.impl.PictureServiecImpl;

@WebServlet("/HuangRongKangPitureServlet")
public class HuangRongKangPitureServlet extends HuangRongKangBaseServlet {
	IPictureService pictureService=new PictureServiecImpl();
	ObjectMapper mapper=new ObjectMapper();
	public void getGoodsIdByUrl(HttpServletRequest request, HttpServletResponse response)throws IOException
	{
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		List<Picture> list=pictureService.getGoodsIdByUrl(goodsId);
		String PictureListJson="";
		PictureListJson=mapper.writeValueAsString(list);
		response.getWriter().print(PictureListJson);
	}
}
