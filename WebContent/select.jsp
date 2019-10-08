<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>小米首页</title>
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/media_index.css">
	<link rel="stylesheet" type="text/css" href="css/mod.css">
	<script src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/select/select.js"></script>
	<script type="text/javascript">
		 $(function(){
			$("#goodsxiangqing").live("click",function(){
				window.location.href="HuangRongKangGoodsServlet?action=getById";
			});
		}); 
	</script>
	<style>
		#nav a:hover{
			color: white;
			background: #424242;
		}
		.m-hd-ul li{
			font-size: 14px;
			float: left;
			color: #333333;
		}
		.m-hd-ul li:hover{
			color: red;
		}
		.m-hd-ul li span{
			color: #ccc;
			padding: 10px 20px;
		}
		.m-hd-ul2 li{
			float: right;
		}
	</style>
</head>
<body style="background: #F5F5F5;">
<section>
	<!--顶部菜单开始-->
	<nav id="nav" class="site-topbar">
		<div class="wraper">
			<ul class="nav-left">
				<li><a href="#">小米商城</a></li>
				<li><a href="#">MIUI</a></li>
				<li><a href="#">米聊</a></li>
				<li><a href="#">游戏</a></li>
				<li><a href="#">多看阅读</a></li>
				<li><a href="#">云服务</a></li>
				<li><a href="#">小米移动版</a></li>
				<li><a href="#">问题反馈</a></li>
				<li><a href="#">Select Region</a></li>
			</ul>
			<ul class="nav-right">
				<c:choose>
						<c:when test="${sessionScope.user==null }">
							<li><a href="login.jsp">登录</a></li>
							<li><a href="register.jsp">注册</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="self_info.jsp">欢迎您，${sessionScope.user.userAccount }</a></li>
							<li><a href="LiuRuizhouUserServlet?action=zhuxiao">注销</a></li>
							<li><a href="dingdanzhongxin.jsp">订单中心</a></li>
						</c:otherwise>
					</c:choose>
				<li class="buyCar">
					<a class="i_car" href="gouwuche.jsp">购物车（0）</a>
				</li>
			</ul>
		</div>
	</nav>
	<!--顶部菜单结束-->
	<!--头部开始-->
	<header id="header" class="site-header">
		<div class="wraper">
			<hgroup class="header-left">
				<h1>小米</h1>
				<h2></h2>
			</hgroup>
			<!--
    			作者：陈胜澡
    			时间：2018-10-21
    			描述：把自己导航部分改为动态的
    		-->
			<script type="text/javascript">
				$(function()
				  {
					var Sid=["xiaomishouji","hongmishouji","pingbangdiannan","Tv","yingting","luyouqi","zhinenyingjiang"];
					var typeid=[1,2,3,4,5,6,7];
					$.each(Sid, function(i,vlues) {
					$.getJSON("ChenShengZaoGoodsServlet?action=getGoodsBytypeId&typeId="+typeid[i],function(date)
					{
						var str="<ul class='goods-list'>";
						$.each(date,function(n,goods)
						{
							str+="<li class='item'>"
			                   +"<div class='prod-img'>"
			                   +"<img src='"+goods.picPath+"' >"
			                   +"</div>"
			                   +"<p class='name'>"+goods.goodsName+"</p>"
			                   +"<span class='price'>"+goods.goodsPrice+"</span>"
			                   +"</li>";
						});
						str+="</ul>";
						$("#"+vlues).append(str);
					});
					});
				  });
			</script>
			<ul class="header-middle header-menu">
				<li>
					<a href="#">小米手机</a>
					<div class="content" id="xiaomishouji">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">红米</a>
					<div class="content" id="hongmishouji">
							<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">平板 笔记本</a>
					<div class="content" id="pingbangdiannan">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">电视</a>
					<div class="content" id="Tv">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#" >新品</a>
					<div class="content" id="yingting">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">路由器</a>
					<div class="content" id="luyouqi">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">智能硬件</a>
					<div class="content" id="zhinenyingjiang">
						<!-- 动态添加 -->
					</div>
				</li>
				<li>
					<a href="#">服务</a>
				</li>
				<li>
					<a href="#">社区</a>
				</li>
	 		</ul>
	 	<!--动态遍历结束-->
	 		<script type="text/javascript">
	 			/*自动补全*/
	 			$(function(){
	 				$.getJSON("LiuRuizhouGoodsServlet?action=getGoodsNameList",function(data){
 						var str="";
 						$.each(data, function(i,temp) {
 							str+="<li>"+temp+"</li>";
 						});
 						$("#select-ul").append(str);
 					});
 					$("#select-ul li").live('mouseenter', function() {
					  	$("#selectinput").val($(this).html());
					});
	 				$("#selectinput").keyup(function(){
	 					$.getJSON("LiuRuizhouGoodsServlet?action=getGoodsNameList&term="+$(this).val(),function(data){
	 						var str="";
	 						$.each(data, function(i,temp) {
	 							str+="<li>"+temp+"</li>";
	 						});
	 						$("#select-ul").children().remove();
	 						$("#select-ul").append(str);
	 					});
	 				});
	 			});
	 		</script>
	 		<div class="header-right">
	 			<input type="text" class="search" list="search-record" id="selectinput" name="search">
	 			<button class="btn" id="selectbtn">搜索</button>
	 			<ul id="select-ul">
	 				
	 			</ul>
	 		</div>
		</div>
	</header>
	<!--头部结束-->

	<!--查询开始-->
	<!--
    	作者：刘锐洲
    	时间：2018-10-23
    -->
	<section id="sku" class="wraper m-box mi-sku">
		<header class="m-hd">
			<div>
				<ul class="m-hd-ul">
					<li style="padding-left: 20px;">推荐<span>|</span></li>
					<li>新品<span>|</span></li>
					<li id="orderbyprice">价格升序<span>|</span></li>
					<li>评论最多<span>|</span></li>
				</ul>
				<ul class="m-hd-ul m-hd-ul2">
					<li><input type="checkbox" />查看评价<span>|</span></li>
					<li><input type="checkbox" />仅显示特惠商品<span>|</span></li>
					<li><input type="checkbox" />仅显示有货商品<span>|</span></li>
				</ul>
			</div>
		</header>
		<div class="m-box">
			<section class="span20 m-slide">
				<div class="m-slide-contain m-s2" style="padding: 0px;" id="m-slide-contain-1">
					<!---->
				</div>
			</section>
		<link rel="stylesheet" href="css/myPagination.css">
	    <script src="js/myPagination.js"></script>
			<div id="pagination" class="pagination" style="margin-top: 30px;text-align: center;"></div>
			<!-- 动态 -->
		</div>
	</section>

	<!--小米明星单品结束-->

<!--为你推荐开始-->
		<script type="text/javascript">
			$(function(){
				$.getJSON("WangXinYuanGoodsServlet?action=tuiJianType", function(data){
					var str="<ul class='m-cols m-col-5' id='weinintuijian'>";
						  $.each(data, function(i,goods){
							 str+="<li class='col'>"
										+"<div class='row'>"
										+"<dl>"
										+"<dt><img src='./images/wntj/"+goods.picPath+"'></dt>"
										+"<dd class='name'>"+goods.goodsName+"</dd>"
										+"<dd class='price'>"+goods.describe+"元</dd>"
										+"<dd class='cmt'>"+goods.describe+"</dd>"
										+"</dl>"
										+"</div>"
									+"</li>"
								if(i==4){
									str+="</ul>";
									$("#xiaomituijian1").append(str);
									
									str="<ul class='m-cols m-col-5'  id='weinintuijian'>";
								}
						  });
						  str+="</ul>";
					$("#xiaomituijian2").append(str);
					
				});
			});
		</script>
		<section id="recommend" class="wraper mi-recommend">
			<input type="radio" id="recommend-s1" class="recommend-switch s1" name="recommend-switch" hidden checked>
			<input type="radio" id="recommend-s2" class="recommend-switch s2" name="recommend-switch" hidden>
			<header class="m-hd">
				<h2 class="m-hdL">为你推荐</h2>
				<div class="m-hdR btns2">
					<div class="btns2">
						<div href="#" class="btn btn1"><label for="recommend-s1">&lt;</label></div>
						<div href="#" class="btn btn2"><label for="recommend-s2">&gt;</label></div>
					</div>
				</div>
			</header>
			<section class="m-box">
				<div class="m-slide">
					<div class="m-slide-contain m-s2">
						<div class="m-slide-item" id="xiaomituijian1">
							<!-- 推荐前五个 -->
						</div>
						<div class="m-slide-item" id="xiaomituijian2">
							<!-- 推荐后五个 -->
						</div>
					</div>
				</div>
			</section>
		</section>
		<!--为你推荐结束-->
		
	
		<!--视频开始-->
		<section class="wraper mi-video clear_bottom" id="video">
			<input type="checkbox" id="video-switch" name="video-switch" class="video-switch" hidden>
			<div class="video-mask">
				<label for="video-switch" class="close-btn"></label> 
				<video controls src="./video/1.mp4"></video>
			</div>
			<header class="m-hd">
				<h2 class="m-hdL">视频</h2>
				<ul class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</ul>
			</header>
			<section class="m-box">
				<ul class="m-cols m-col-4">
					<li class="col">
						<div class="row">
							<div class="video">
								<label class="play-btn" for="video-switch"></label>
								<img src="./images/video/video1.jpg">
							</div>
							<div class="content">
								<p class="name"><a href="#">红米年度品牌视频</a></p>
								<p class="desc">一亿人喜爱你，是一种责任</p>
							</div>
						</div>
					</li>
					<li class="col">
						<div class="row">
							<div class="video">
								<label class="play-btn" for="video-switch"></label>
								<img src="./images/video/video2.jpg">
							</div>
							<div class="content">
								<p class="name"><a href="#">红米年度品牌视频</a></p>
								<p class="desc">一亿人喜爱你，是一种责任</p>
							</div>
						</div>
					</li>
					<li class="col">
						<div class="row">
							<div class="video">
								<label class="play-btn" for="video-switch"></label>
								<img src="./images/video/video3.jpg">
							</div>
							<div class="content">
								<p class="name"><a href="#">红米年度品牌视频</a></p>
								<p class="desc">一亿人喜爱你，是一种责任</p>
							</div>
						</div>
					</li>
					<li class="col">
						<div class="row">
							<div class="video">
								<label class="play-btn" for="video-switch"></label>
								<img src="./images/video/video4.jpg">
							</div>
							<div class="content">
								<p class="name"><a href="#">红米年度品牌视频</a></p>
								<p class="desc">一亿人喜爱你，是一种责任</p>
							</div>
						</div>
					</li>
				</ul>
			</section>
		</section>
		<!--视频结束-->
	</div>

	<footer id="footer" class="">
		<header class="wraper footer-top">
			<ul>
				<li><a href="#"><span>icon</span>1小时快修服务</a></li>
				<li><a href="#"><span>icon</span>1小时快修服务</a></li>
				<li><a href="#"><span>icon</span>1小时快修服务</a></li>
				<li><a href="#"><span>icon</span>1小时快修服务</a></li>
				<li><a href="#"><span>icon</span>1小时快修服务</a></li>
			</ul>
		</header>
		<section class="wraper footer-middle">
			<aside class="footer-right connect">
				<p class="tel">400-100-5678</p>
				<p class="detail">
				周一至周日 8:00-18:00
				（仅收市话费）
				</p>
				<a href="#" class="btn"><span></span>24小时在线客服</a>
			</aside>
			<section class="footer-left menu-columns">
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
					<li><a href="#"><img src="./images/i_trust.png"></a></li>
					<li><a href="#"><img src="./images/i_company.png"></a></li>
					<li><a href="#"><img src="./images/i_cmt.png"></a></li>
					<li><a href="#"><img src="./images/i_protect.png"></a></li>
				</ul>
				<h3>探索黑科技，小米为发烧而生</h3>
			</div>
		</footer>
	</footer>
</section>	
</body>
</html>