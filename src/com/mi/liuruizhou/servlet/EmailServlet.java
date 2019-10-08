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
		String qm = "ugwgemjjhrledhej"; //�����˺ŵ�QQ����Ȩ����
		String tu = "qq.com"; //������ĺ�׺����
		String tto = request.getParameter("email"); //�����ʼ�������
		String yanzhengma=yanZhengMa.getMa();
		//���͵ı���
		String ttitle = "ע��С���̳������������֤";
		//���͵�����
		String tcontent = "<div style='margin: 10% auto;border: 1px solid gainsboro;width: 580px;height: 250px;'>"
			+"<span style='font-size: 18px;color: darkslategray;display: block;margin: 15px 10px;'>ע����֤</span>"
			+"<hr color='gainsboro'/>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin-left: 20px;margin-top: 50px;'>����&ensp;&ensp;<label style='color: orange;'>"+tto+"</label></span>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin: 20px;margin-left: 20px;'>��ӭע��С���̳�����棬�뽫��֤����д��ע��ҳ��</span>"
			+"<span style='font-size: 15px;color: darkslategray;display: block;margin-left: 20px;'>��֤�룺<label style='color: blue;'>"+yanzhengma+"</label></span>"
			+"</div>";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp." + tu);//���ŵ���������������д�������ǹ�˾�����������Բ����޸ģ���������������
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.port", "465");
		Session s = Session.getInstance(props);
		s.setDebug(true);
		MimeMessage message = new MimeMessage(s);
		//����Ϣ�������÷�����/�ռ���/����/����ʱ��
		InternetAddress from = new InternetAddress("3070549647@" + tu); //�����3070549647��Ϊ�����ŵ�QQ��
		message.setFrom(from);
		InternetAddress to = new InternetAddress(tto);
		message.setRecipient(Message.RecipientType.TO, to);
		message.setSubject(ttitle);
		message.setSentDate(new Date());
		//����Ϣ������������
		BodyPart mdp = new MimeBodyPart();//�½�һ������ż����ݵ�BodyPart����
		mdp.setContent(tcontent, "text/html;charset=gb2312");//��BodyPart�����������ݺ͸�ʽ/���뷽ʽ
		Multipart mm = new MimeMultipart();//�½�һ��MimeMultipart�����������BodyPart��
		//��(��ʵ�Ͽ��Դ�Ŷ��)
		mm.addBodyPart(mdp);//��BodyPart���뵽MimeMultipart������(���Լ�����BodyPart)
		message.setContent(mm);//��mm��Ϊ��Ϣ���������
		message.saveChanges();
		Transport transport = s.getTransport("smtp");
		transport.connect("smtp." + tu, "3070549647", qm); //�����3070549647ҲҪ�޸�Ϊ������QQ����
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
