<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="./css/login/login.css">
		<style type="text/css">
			.code
			{
				font-family: Arial;
				font-style: italic;
				font-weight: bold;
				border: 0;
				letter-spacing: 3px;
				color: black;
				height: 40px;
				width: 100px;
				background-color: #a4a9bc;
			}
		</style>
		<script type="text/javascript" src="js/checkCode.js"></script>
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="./index.jsp" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="HuangRongKangLoginServlet" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="./register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				
				<div class="login_main center">
					${ sessionScope.msg}
					<div class="username">用户名:&nbsp;<input style="color:black" class="shurukuang" type="text" name="username" placeholder="请输入你的用户名" /></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input style="color:black" class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" style="color:black" id="codeInput" type="text" name="username" placeholder="请输入验证码" /></div>
						<div class="right fl"><input type="button" id="checkCode" class="code" onclick="createCode()" /></div>
						<br />
						<span id="yzmMsg" name="yzmMsg"></span>
						<div class="clear"></div>
					</div>
				</div>
				<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="立即登录" onclick="return validate()"  >
				</div>
				
			</div>
		</div>
		</form>
		<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/comm.css">
	<link rel="stylesheet" type="text/css" href="css/detail.css">
	<link rel="stylesheet" type="text/css" href="css/media_detail.css">
		<!--剩余部分结束-->
	<footer id="footer" class="site-footer"style="background-color: whitesmoke;">
		<div style="width: 105%;background: whitesmoke;">
		<header class="wraper footer-top">
			<ul>
				<li><a href=""><span>icon</span>1小时快修服务</a></li>
				<li><a href=""><span>icon</span>1小时快修服务</a></li>
				<li><a href=""><span>icon</span>1小时快修服务</a></li>
				<li><a href=""><span>icon</span>1小时快修服务</a></li>
				<li><a href=""><span>icon</span>1小时快修服务</a></li>
			</ul>
		</header>
		
		<section class="wraper footer-middle" style="background-color: whitesmoke;">
			<aside class="footer-right connect">
				<p class="tel">400-100-5678</p>
				<p class="detail">
				周一至周日 8:00-18:00
				（仅收市话费）
				</p>
				<a href="" class="btn"><span></span>24小时在线客服</a>
			</aside>
			<section class="footer-left menu-columns" >
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
				<ul class="menu">
					<li>
						<dl>
							<dt>帮助中心</dt>
							<dd>账户管理</dd>
							<dd>购物指南</dd>
							<dd>订单操作</dd>
						</dl>
					</li>
				</ul>
			</section>
		</section>
		<footer class="footer-bottom">
			<div class="wraper">
				<div class="info">
					<div class="links"><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a><a href="#">小米商城</a></div>
					<p class="desc">©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号 
					违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
				</div>
				<ul class="img-list">
					<li><a href=""><img src="./images/i_trust.png"></a></li>
					<li><a href=""><img src="./images/i_company.png"></a></li>
					<li><a href=""><img src="./images/i_cmt.png"></a></li>
					<li><a href=""><img src="./images/i_protect.png"></a></li>
				</ul>
				<h3>探索黑科技，小米为发烧而生</h3>
			</div>
		</footer>
		</div>
	</footer>
	</body>
</html>