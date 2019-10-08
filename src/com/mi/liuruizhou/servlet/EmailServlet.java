package com.mi.liuruizhou.servlet;

import java.io.IOException;
import java.util.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mi.liuruizhou.dao.utils.YanZhengMa;

import javax.mail.*;

@SuppressWarnings("serial")
public class EmailServlet extends BaseServlet {
	
	public void getYanzhengMaEmail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		List<YanZhengMa> yanZhengMas=new ArrayList<YanZhengMa>();
		YanZhengMa yanZhengMa=new YanZhengMa(new Date(), getYanzhengMal());
		yanZhengMas.add(yanZhengMa);
		ObjectMapper mapper=new ObjectMapper();
		String yanzhengmaJson=mapper.writeValueAsString(yanZhengMas);
		response.getWriter().print(yanzhengmaJson);
		//System.out.println(yanzhengmaJson);
		
		//souwifuabnkgddcj
		String qm = "ugwgemjjhrledhej"; //发送账号的QQ的授权密码
		String tu = "qq.com"; //你邮箱的后缀域名
		String tto = request.getParameter("email"); //接收邮件的邮箱
		String yanzhengma=yanZhengMa.getMa();
		//发送的标题
		String ttitle = "注册小米商城迷你版邮箱验证";
		//发送的内容
		String tcontent = "<div style='margin: 10% auto;border: 1px solid gainsboro;width: 580px;height: 250px;'>"
			+"<span style='font-size: 18px;color: darkslategray;display: block;margin: 15px 10px;'>注册验证</span>"
			+"<hr color='gainsboro'/>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin-left: 20px;margin-top: 50px;'>您好&ensp;&ensp;<label style='color: orange;'>"+tto+"</label></span>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin: 20px;margin-left: 20px;'>欢迎注册小米商城迷你版，请将验证码填写到注册页面</span>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin-left: 20px;'>验证码：<label style='color: blue;'>"+yanzhengma+"</label></span>"
			+"</div>";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp." + tu);//发信的主机，这里我填写的是我们公司的主机！可以不用修改！（不懂别乱来）
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.port", "465");
		Session s = Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message = new MimeMessage(s);
		//给消息对象设置发件人/收件人/主题/发信时间
		InternetAddress from = new InternetAddress("3070549647@" + tu); //这里的3070549647改为您发信的QQ号
		message.setFrom(from);
		InternetAddress to = new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		//给消息对象设置内容
		BodyPart mdp = new MimeBodyPart();//新建一个存放信件内容的BodyPart对象
		mdp.setContent(tcontent, "text/html;charset=gb2312");//给BodyPart对象设置内容和格式/编码方式
		Multipart mm = new MimeMultipart();//新建一个MimeMultipart对象用来存放BodyPart对
		//象(事实上可以存放多个)
		mm.addBodyPart(mdp);//将BodyPart加入到MimeMultipart对象中(可以加入多个BodyPart)
		message.setContent(mm);//把mm作为消息对象的内容
		message.saveChanges();
		Transport transport = s.getTransport("smtp");
		transport.connect("smtp." + tu, "3070549647", qm); //这里的3070549647也要修改为发件人QQ号码
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
	
	public String getYanzhengMal() {
		char[] zifu={'a','b','c','d','e','f','g','h','i','j','k','l',
			    	 'm','n','o','p','q','r','s','t','u','v','w','x',
			    	 'y','z','1','2','3','4','5','6','7','8','9','0'};
		String ynzhengMalStr="";
		for (int i = 0; i < 6; i++) {
			int x=1+(int)(Math.random()*(zifu.length-1));
			ynzhengMalStr+=zifu[x];
		}
		return ynzhengMalStr;
	}
	
	public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<YanZhengMa> yanZhengMas=new ArrayList<YanZhengMa>();
		yanZhengMas.add(new YanZhengMa(new Date(), getYanzhengMal()));
		ObjectMapper mapper=new ObjectMapper();
		String yanzhengmaJson=mapper.writeValueAsString(yanZhengMas);
		response.getWriter().print(yanzhengmaJson);
		//System.out.println(yanzhengmaJson);
	}
}
