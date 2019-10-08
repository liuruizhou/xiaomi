package com.wangxinyuan.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.service.MingXingService;
import com.wangxinyuan.service.TuiJianService;
import com.wangxinyuan.service.YingJianService;
import com.wangxinyuan.service.ZhouBianService;
import com.wangxinyuan.service.impl.MingXingServiceImpl;
import com.wangxinyuan.service.impl.TuiJianServiceImpl;
import com.wangxinyuan.service.impl.YingJianServiceImpl;
import com.wangxinyuan.service.impl.ZhouBianServiceImpl;


@SuppressWarnings("serial")
public class GoodsServlet extends BaseServlet {
	YingJianService yingJianService=new YingJianServiceImpl();
	MingXingService mingXingService=new MingXingServiceImpl();
	TuiJianService tuiJianService=new TuiJianServiceImpl();
	ZhouBianService zhouBianService=new ZhouBianServiceImpl();
	ObjectMapper mapper=new ObjectMapper();
	public void yingJianType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=19;
		List<Goods> yingJianGoods=yingJianService.listYingJianByTypeId(id);
		String yingJianGoodsJson= mapper.writeValueAsString(yingJianGoods);
		response.getWriter().print(yingJianGoodsJson);
		//System.out.println(yingJianGoodsJson);
	}
	
	public void mingXingType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=17;
		List<Goods> mingXingGoods=mingXingService.listMingXingByTypeId(id);
		String mingXingGoodsJson= mapper.writeValueAsString(mingXingGoods);
		response.getWriter().print(mingXingGoodsJson);
	//	System.out.println(mingXingGoodsJson);	
	}
	
	public void tuiJianType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=22;
		List<Goods> tuiJianGoods=tuiJianService.listTuiJianByTypeId(id);
		String tuiJianGoodsJson= mapper.writeValueAsString(tuiJianGoods);
		response.getWriter().print(tuiJianGoodsJson);
		//System.out.println(tuiJianGoodsJson);	
	}
	
	public void zhouBianShangPinType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("typeId");
		int id=Integer.parseInt(str);
		List<Goods> zhouBianGoods=zhouBianService.listZhouBianByTypeId(id);
		String zhouBianGoodsJson= mapper.writeValueAsString(zhouBianGoods);
		response.getWriter().print(zhouBianGoodsJson);
		//System.out.println(zhouBianGoodsJson);	
	}
}
