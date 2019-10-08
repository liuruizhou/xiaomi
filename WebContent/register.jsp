<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="./css/login/login.css">
		<style type="text/css">
			.djhqyzm{
				background: #E6E8EA;
				border: 0px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script>
			$(function(){
				$("#onclicher").click(function(){
					//验证
					var username=$("#username input").val();
					var passwordstr=$("#password input").val();
					var repassword=$("#repassword input").val();
					var email=$("#yangzhengmayouxian input").val();
					if (username=="") {
						alert("用户名不能空");
						$(":submit").attr("disabled","disabled");
					}else if (passwordstr==""||passwordstr.length<6){
						alert("密码不能空且长度不能小于6");
						$(":submit").attr("disabled","disabled");
					}else if (passwordstr!=repassword){
						alert("两次密码不一致");
						$(":submit").attr("disabled","disabled");
					}else if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
						alert("邮箱格式不正确");
						$(":submit").attr("disabled","disabled");
					}else{
						$("#onclicher").attr("hidden","hidden");
						$("#onclichernext").removeAttr("hidden");
						$.getJSON("LiuRuizhouEmailServlet?action=getYanzhengMaEmail&email="+email, function(data){
							var str="";
							$.each(data,function(n,yzma){
								str+=yzma.ma;
			                });
							$("#yangzhengma input").blur(function(){
								if($("#yangzhengma input").val()==str){
									$("#yangzhengma span").css("style","color: green").html("验证成功");
									$(":submit").removeAttr("disabled");
								}
							});
						});
						//$(":submit").removeAttr("disabled");
					}
				});
			});
			
		</script>
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="./index.html" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="LiuRuizhouUserServlet?action=save" style="background: url(image/login_bg.jpg)no-repeat center center; ">
		<div class="regist" style="background: rgba(255,255,255,0.9);margin-right: 10%;">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="./index.jsp" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username" id="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" placeholder="请输入你的用户名"/><span>建议不要输入汉字</span></div>
					<div class="username" id="password">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/><span>请输入6位以上字符</span></div>
					
					<div class="username" id="repassword">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div>
					<div class="username" id="yangzhengmayouxian">邮箱验证:&nbsp;&nbsp;
					<input class="shurukuang" type="email" name="email" placeholder="请填写QQ邮箱号码"/>
					<input class="djhqyzm" type="button" id="onclicher" value="点击获取验证码" >
					<label class="djhqyzm" type="button" style="font-size: 13px" id="onclichernext" hidden>两分钟后再次点击</label></div>
					<div class="username" id="yangzhengma">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;
						<input class="yanzhengma" type="text" name="username" placeholder="请输入验证码"/></div>
						<div class="right fl" style="margin-right: 0px;"><img></div>
						<span style="font-size: 13px;">请输入邮箱接收到六位的验证码</span>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="submit" name="submit" value="立即注册" disabled="disabled">
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