<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="./css/login/style.css">
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="index.jsp" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="gouwuche.jsp">购物车（0）</a></div>
					<div class="fr">
						<ul>
							<c:choose>
								<c:when test="${sessionScope.user==null }">
									<li><a href="login.jsp">登录</a></li>
									<li><a href="register.jsp">注册</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="self_info.jsp">欢迎您，${sessionScope.user.userAccount }</a></li>
									<li><a href="LiuRuizhouUserServlet?action=zhuxiao">注销</a></li>
								</c:otherwise>
							</c:choose>
							<li>|</li>
							<li><a href="#top">个人中心</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.jsp" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索" onclick="window.location.href='select.jsp'"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./dingdanzhongxin.jsp" >我的订单</a></li>
					<li><a href="">意外保</a></li>
					<li><a href="">团购订单</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">优惠券</a></li>
					<li><a href="">收货地址</a></li>
				</ul>
			</div>
		</div>
		
		<!-- 
			作者：廖伟成
    		时间：2018-10-25
    		描述：把个人中心部分改为动态的
		 -->	
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script type="text/javascript">
		$(function() {			
			//初始化数据
			$.getJSON("LiaoWeiChengGoodsServlet?action=getUser&userid="+$("#sessionScope-user-userId").val(), function(data){
			   //alert(data.user_id);
			   if (data.user_id!=null) {
				   $("#id").html(data.user_id);
			   }else{
				   $("#id").html("没有");
			   }
			   if (data.user_nickname!=null) {
				   $("#userId").html(data.user_nickname);
			   }else{
				   $("#userId").html("您还没有昵称");
			   }
			   if (data.phone!=null) {
				   $("#phone").html(data.phone);
			   }else{
				   $("#phone").html("还没绑定电话号码");
			   }
			   if (data.email!=null) {
				   $("#email").html(data.email);
			   }else{
				   $("#email").html("您还没绑定电子邮箱");
			   }
			   if (data.personalized_signature!=null) {
				   $("#gexing").html(data.personalized_signature);
			   }else{
				   $("#gexing").html("您还没设置个性签名");
			   }
			   if (data.hobby!=null) {
				   $("#aihao").html(data.hobby);
			   }else{
				   $("#aihao").html("您还没设置爱好");
			   }
			   if (data.address!=null) {
				   $("#address").html(data.address);
			   }else{
				   $("#address").html("您还没设置收货地址");
			   }
			});
			
			
			
			//事件绑定
			var userAcount=document.getElementById("acount");			
			$(".btn1").toggle(function(){				
				var input=$("<input value='"+$(this).parent().prev().html()+"' style='width:600px;height:30px;'/>");
				$(this).parent().prev().html(input);
				$(this).html("保存");
			},function(){
				var val=$(this).parent().prev().children().val();
				$(this).parent().prev().html(val);
				$(this).html("修改");
				////处理事件
				
				var user_id=$("#id").html();
				var userNickname=$("#userId").html();
				var phone=$("#phone").html();
				var personalizedSignature=$("#gexing").html();
				var address=$("#address").html();
				var hobby=$("#aihao").html();
				var email=$("#email").html();
				
				$.getJSON("LiaoWeiChengGoodsServlet?action=update",
					{user_id:user_id,userNickname:userNickname,phone:phone,
					personalizedSignature:personalizedSignature,address:address,
					hobby:hobby,email:email},function(data){
						if(data){
							alert("保存成功");
						}else{
							alert("保存失败，格式不支持");
						}
					});			
			});	 
		});
		</script>
		<c:choose>
			<c:when test="${sessionScope.user!=null }">
				<input hidden id="sessionScope-user-userId" value="${sessionScope.user.userId }">
			</c:when>
			<c:otherwise>
				<c:redirect url="login.jsp"></c:redirect>
			</c:otherwise>
		</c:choose>
		
		<div class="rtcont fr" >
		<div style="height: 40px"></div>
			<div class="subgrzl ml40">
				<span>小米ID</span>
				<span id="id">动态</span>
				<span><a>&nbsp;</a></span>
			</div>
			<div class="subgrzl ml40">
				<span>昵称</span>
				<span class="text1" id="userId">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>	
			<div class="subgrzl ml40">
				<span>手机号</span>
				<span class="text1" id="phone">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>			
			<div class="subgrzl ml40">
				<span>邮箱</span>
				<span class="text1" id="email">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>
			<div class="subgrzl ml40">
				<span>个性签名</span>
				<span class="text1" id="gexing">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>
			<div class="subgrzl ml40">
				<span>我的爱好</span>
				<span class="text1" id="aihao">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>
			<div class="subgrzl ml40">
				<span>收货地址</span>
				<span class="text1" id="address">动态</span>
				<span><a class="btn1" style="cursor: pointer;"/>编辑</a></span>
			</div>
			<!-- 
			作者：廖伟成
    		时间：2018-10-25
    		描述：把个人中心部分改为动态的
		 	-->
		</div>
		<div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
		
		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>