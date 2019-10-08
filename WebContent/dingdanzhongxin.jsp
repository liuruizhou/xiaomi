<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="css/login/style.css">
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
					<div class="gouwuche fr"><a href="gouwuche.jsp">购物车（<span>0</span>）</a></div>
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
							<li><a href="./self_info.jsp">个人中心</a></li>
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
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
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
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="button" class="sousuo" value="搜索" onclick="window.location.href='select.jsp'"/>
					</div>
					<div class="clear"></div>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj" style="padding-bottom: 0px">
		<div class="selfinfo center">
		<div class="lfnav fl" >
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
					<li><a href="">意外保</a></li>
					<li><a href="">团购订单</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">优惠券</a></li>
					<li><a href="">收货地址</a></li>
				</ul>
			</div>
		</div>
		<c:choose>
			<c:when test="${sessionScope.user!=null }">
				<input hidden id="sessionScope-user-userId" value="${sessionScope.user.userId }">
			</c:when>
			<c:otherwise>
				<c:redirect url="login.jsp"></c:redirect>
			</c:otherwise>
		</c:choose>
			<!--
    			作者：陈胜澡
    			时间：2018-10-25
    			描述：订单页面动态显示
    		-->
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript">
			$(function(){
				$.getJSON("ChenShengZaoOrdersServlet?action=getOrdersByuserId&userId="+$("#sessionScope-user-userId").val(), function(data){
					var str='<div class="ddzxbt">交易订单</div>';
					$.each(data.Orderslist, function(i,order) {
						str+='<div class="ddxq"><div class="ddspt fl">'
							+'<img style="width: 100px;display: inline-block;margin-left: -10px;margin-top: 5px;" src="img/'+data.goodsList[i].picPath+'" alt=""></div>'
							+'<div class="ddbh fl">订单号:'+order.id+'</div>'
							+'<div class="ztxx fr">'
							+'<ul>';
						str+='<li>'+data.states[i].description+'</li>'
						   +'<li>'+order.price+'</li>'
						   +'<li>'+order.tradingHour+'</li>'
						   +'<li><a href="">订单详情></a></li>'
						   +'<div class="clear"></div>'
						   +'</ul>'
						   +'</div>'
						   +'<div class="clear"></div></div>';
					});
					
					$("#rtcont-fr-after").append(str);
				});
					
			});
		</script>
		<div class="rtcont fr" id="rtcont-fr-after" style="height: 100%;padding-bottom: 50px;margin-bottom: 0px">
			
		</div>
		 <div class="clear"></div>
		</div>
	</div>
<!-- self_info -->
	<!-- 动态结束 -->
		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>