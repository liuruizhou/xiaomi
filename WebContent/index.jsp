<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>小米首页</title>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/media_index.css">
	<link rel="stylesheet" type="text/css" href="css/mod.css">
	<script type="text/javascript" src="js/select/select.js"></script>
	<style>
		#nav a:hover{
			color: white;
		}
	</style>
</head>
<body>
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
				</c:otherwise>
			</c:choose>
				<li class="buyCar">
					<a class="i_car" style="background-color: #616161;" href="gouwuche.jsp">购物车(0)</a>
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
			                   +"<img src='"+goods.picPath+"'>"
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
					<a href="#">新品</a>
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
	 		<div class="header-right">
	 			<input type="text" class="search" list="search-record" name="search">
	 			<button class="btn" onclick="window.location.href='select.jsp'">搜索</button>
	 		</div>
		</div>
	</header>
	<!--头部结束-->
	
	<!--中部区域开始-->
	<!--
    	作者：刘锐洲
    	时间：2018-10-21
    	描述：把自己导航部分改为动态的
    -->
	<script>
		$(function(){
			var ids=["index_sidenav_img","index_sidenav_notebook","index_sidenav_tv","index_sidenav_vr","index_sidenav_power","index_sidenav_earphone","index_sidenav_protect","index_sidenav_pole","index_sidenav_rubit","index_sidenav_bag"];
			var typeIds=[8,9,18,10,11,12,13,14,15,16];
			$.each(ids, function(i,vlues) {
				$.getJSON("LiuRuizhouGoodsServlet?action=sidenav&typeId="+typeIds[i], function(data){
					var str = "<ul class='good-list' >";
					$.each(data,function(n,goods){
	                   	str+="<li><img src='./images/"+goods.picPath+"' style='background: white;'>"+goods.goodsName+"</li>";
	                   	if(n>0&&(n+1)%5==0&&(n+1)!=data.length){
	                   		str+="</ul><ul class='good-list' >";
	                   	}
	                });
	                str+="</ul>"
	                $("#"+vlues).append(str);
				});
			});
		});
	</script>
	<div class="wraper">
		<section id="main" class="site-main clear_bottom">
			<aside class="main-left"> 
				<ul class="category-list">
					<li>
						<a href="#"><span>手机</span><span> 平板</span><span>电话卡</span> </a>
						<div class="content" id="index_sidenav_img">
							<!-- 动态添加 -->
							
						</div>
					</li>
					<li>
						<a href="#"><span>笔记本<span></a>
						<div class="content" id="index_sidenav_notebook">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>电视</span> <span>盒子</span></a>
						<div class="content" id="index_sidenav_tv">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>路由器</span> <span>智能硬件</span></a>
						<div class="content" id="index_sidenav_vr">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>移动电源</span> <span>电池</span></a>
						<div class="content" id="index_sidenav_power">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>耳机</span> <span>音箱</span></a>
						<div class="content" id="index_sidenav_earphone">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>保护套</span> <span>后盖</span></a>
						<div class="content" id="index_sidenav_protect">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>贴膜</span> <span>其他配件</span></a>
						<div class="content" id="index_sidenav_pole">
							<!-- 动态添加 -->
						</div>
					</li>
					<li>
						<a href="#"><span>米兔</span> <span>服装</a>
						<div class="content" id="index_sidenav_rubit">
							<!-- 动态添加 -->
						</div>
					
					</li>
					<li>
						<a href="#"><span>箱包</span> <span>其他周边</span></a>
						<div class="content" id="index_sidenav_bag">
							<!-- 动态添加 -->
						</div>
					</li>
				</ul>
			</aside>
			<!--动态遍历结束-->
			<section class="main-right">
				<div class="slider">
					<ul class="contain">
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic1.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic2.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic3.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic4.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic5.jpg"></a></li>
					</ul>
				</div>
			</section>
		</section>
	</div>
		
	<section id="adv" class="wraper site-adv m-box clear_bottom">
		<div class="span4">
			<ul class="rect6">
				<li class="item"></li>
				<li class="item"></li>
				<li class="item"></li>
				<li class="item"></li>
				<li class="item"></li>
				<li class="item"></li>
			</ul>
		</div>
		<div class="span16">
			<ul class="m-cols m-col-3">
				<li class="col"><img src="images/adv1.jpg"></li>
				<li class="col"><img src="images/adv2.jpg"></li>
				<li class="col"><img src="images/adv3.jpg"></li>
			</ul>
		</div>
		
	</section>
	<!--
    	作者：刘锐洲
    	时间：2018-10-21
    	描述：本人已把中间部分变层动态跟新
    -->
	<!--中部区域结束-->
	

	<script type="text/javascript">
		$(function(){
			$.getJSON("WangXinYuanGoodsServlet?action=mingXingType", function(data){
				var str="<ul class='m-cols m-col-5'>";
				  $.each(data, function(i,goods){
				   	str+="<li class='col sku-item'>"
								+"<dl class='row'>"
								+"<dt><img src='./images/single/"+goods.picPath+"'></dt>"
								+"<dd class='name'>"+goods.goodsName+"</dd>"
								+"<dd class='desc'>"+goods.describe+"</dd>"
								+"<dd class='price'>"+goods.goodsPrice+"元</dd>"
								+"</dl>"
								+"</li>";
					if(i==4){
						 str+="</ul>";
						 $("#item-slide-m1").append(str);
						 str="<ul class='m-cols m-col-5'>";
					}			
				  });
				  str+="</ul>";
				  $("#item-slide-m2").append(str);
				});
		});
	</script>
	<!--小米明星单品开始-->
	<section id="sku" class="wraper m-box mi-sku">
		<input type="radio" id="sku-s1" class="sku-switch s1" name="sku-switch" hidden checked>
		<input type="radio" id="sku-s2" class="sku-switch s2" name="sku-switch" hidden>
		<header class="m-hd">
			<h2 class="m-hdL">小米明星单品</h2>
			<div class="m-hdR">
				<div class=" btns2">
					<a href="#" class="btn btn1 active"><label for="sku-s1">&lt;</label></a>
					<a href="#" class="btn btn2"><label for="sku-s2">&gt;</label></a>
				</div>
			</div>
		</header>
		<div class="m-box">
			<section class="span20 m-slide">
				<div class="m-slide-contain m-s2">
					<div class="m-slide-item" id="item-slide-m1">
						<!-- 这里动态添加前五个 -->
					</div>
					<div class="m-slide-item" id="item-slide-m2">
						<!-- 这里动态添加后五个 -->
					</div>
				</div>
			</section>		
		</div>
	</section>
	<!--小米明星单品结束-->
	<div class="gray-section">
	<script type="text/javascript">
		$(function(){
			$.getJSON("WangXinYuanGoodsServlet?action=yingJianType", function(data){
			 	var str ="<ul class='m-cols m-col-4'>";
			 	 str+="<li class='col'>";
				 $.each(data, function(i,goods){
					 str+="<div class='row'>";
							if((i+1)%2==0){
								str+="<span class='tip blue'>有赠品</span>";

							}else{
								str+="<span class='tip orange'>免邮件</span>";
							}
							str+="<dl>"
								+"<dt><img src='./images/znyj/"+goods.picPath+"'></dt>"
									+"<dd class='name'>"+goods.goodsName+"</dd>"
									+"<dd class='desc'>"+goods.describe+"</dd>"
									+"<dd class='price'>"+goods.goodsPrice+"元</dd>"
									+"</dl>"
							+"</div>";
							if((i+1)%2==0&&(i+1)!=data.length){
									str+="</li><li class='col'>";
								}
				  });
				 str+="</li></ul>";
				$("#19span").append(str);
			});
		});
	</script>
		<!--智能硬件开始-->
		<section class="wraper mi-hard clear_bottom" id="hard">
			<header class="m-hd">
				<h2 class="m-hdL">智能硬件</h2>
				<div class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span4">
					<div class="row main-pic">
						<img src="./images/znyj/row2Img.jpg">
					</div>
				</div>
				<div class="span16" id="19span">
					<!-- 这里遍历四个li -->
				</div>
			</section>
		</section>
		<!--智能硬件结束-->

		<!--搭配开始-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-21
    		描述：把自己搭配部分改为动态的
		 -->		
		<!--搭配开始-->		
		<script>
			$(function(){
				var ids=["index_match_hot","index_match_headset","index_match_power","index_match_cell"];
				var typeIds=[31,32,33,34];
				$.each(ids, function(i,vlues) {
					$.getJSON("LiaoWeiChengGoodsServlet?action=match&typeId="+typeIds[i], function(data){
						var str = "<ul class='m-cols m-col-4'><li class='col'>";
						$.each(data,function(n,goods){				
		                   	str+="<div class='row' content='"+goods.describe+"' from='来自于米米小aa 的评价'>"           
		                   	+"<span class='tip orange'>免邮件</span>"
							+"<dl>"
							+"<dt><img src='./images/dp/"+goods.picPath+"'></dt>"
								+"<dd class='name'>"+goods.goodsName+"</dd>"
								+"<dd class='price'>"+goods.goodsPrice+"元</dd>"
								+"<dd class='cmt'>18.7万人评价</dd>"
								+"</dl>"
							+"</div>"; 
		                   	if(n>0&&(n+1)%2==0&&(n+1)!=data.length){
		                   		str+="</li><li class='col'>";
		                   	}	
		                });
						str+="</li></ul>";
		                $("#"+vlues).append(str);
		                str="<ul class='m-cols m-col-4'><li class='col'>";
					});
				});
			});
		</script>		
		<section class="wraper mi-match clear_bottom" id="match">
			<input type="radio" id="match-s1" class="match-switch s1" name="match-switch" hidden checked>
			<input type="radio" id="match-s2" class="match-switch s2" name="match-switch" hidden>
			<input type="radio" id="match-s3" class="match-switch s3" name="match-switch" hidden>
			<input type="radio" id="match-s4" class="match-switch s4" name="match-switch" hidden>
			<header class="m-hd">
				<h2 class="m-hdL">搭配</h2>
				<div class="m-hdR">
					<ul class="tabs">
						<li class="item active tab tab1"><a href="#"><label for="match-s1">热门</label></a></li>
						<li class="item tab tab2"><a href="#"><label for="match-s2">耳机音像</label></a></li>
						<li class="item tab tab3"><a href="#"><label for="match-s3">电源</label></a></li>
						<li class="item tab tab4"><a href="#"><label for="match-s4">电池存储卡</label></a></li>
					</ul>
				</div>
			</header>	
			<section class="m-box line2  clear_top  clear_bottom">
				<div class="span4">
					<div class="row main-pic">
						<img src="./images/znyj/row2Img.jpg">
					</div>
				</div>
				<div class="span16">
					<!--滑动切换的模块-->
					<div class="m-slide">
						<div class="m-slide-contain m-s4">							
							<div class="m-slide-item"  id="index_match_hot">
								 <!-- 动态添加 -->
							</div>							
							<div class="m-slide-item" id="index_match_headset">
								 <!-- 动态添加 -->		
							</div>
							<div class="m-slide-item" id="index_match_power">
								 <!-- 动态添加 -->
							</div>
							<div class="m-slide-item" id="index_match_cell">
								 <!-- 动态添加 -->
							</div> 
						</div>
					</div>
				</div>
			</section>
		</section>
		<!--搭配结束-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-22
    		描述：把自己搭配部分已完成
		 -->

		<!--配件开始-->
		<section class="wraper mi-parts" id="parts">
			<input type="radio" id="parts-s1" class="parts-switch s1" name="parts-switch" hidden checked>
			<input type="radio" id="parts-s2" class="parts-switch s2" name="parts-switch" hidden>
			<input type="radio" id="parts-s3" class="parts-switch s3" name="parts-switch" hidden>
			<input type="radio" id="parts-s4" class="parts-switch s4" name="parts-switch" hidden>
			<header class="m-hd">
				<h2 class="m-hdL">配件</h2>
				<div class="m-hdR">
					<ul class="tabs">
						<li class="item active tab tab1"><a href="#"><label for="parts-s1">热门</label></a></li>
						<li class="item tab tab2"><a href="#"><label for="parts-s2">保护膜</label></a></li>
						<li class="item tab tab3"><a href="#"><label for="parts-s3">贴膜</label></a></li>
						<li class="item tab tab4"><a href="#"><label for="parts-s4">其他配件</label></a></li>
					</ul>
				</div>
			</header>
			<!--
    			作者：陈胜澡
    			时间：2018-10-25
    			描述：把配件部分改为动态的
    		-->
			<script type="text/javascript">
				$(function()
				{
					$.getJSON("ChenShengZaoGoodsServlet?action=getGoodsBytypeId&typeId=20",function(date)
					{
						var str="<li class='col'>";
						$.each(date,function(n,goods)
						{
							str+="<div class='row'>";
							if((n+1)%2==0)
							{
								str+="<span class='tip blue'>有赠品</span>";
							}
							else
							{
								str+="<span class='tip orange'>免邮件</span>";
							}
							 str+="<dl>"
							   	+"<dt><img src='"+goods.picPath+"'></dt>"
							   	+"<dd class='name'>"+goods.goodsName+"</dd>"
							   	+"<dd class='desc'>"+goods.describe+"</dd>"
							   	+"<dd class='price'>"+goods.goodsPrice+"</dd>"
							   	+"</dl>"
							   	+"</div>";
							if((n+1)%2==0&&(n+1)!=date.length)
							{
								str+="</li><li class='col'>";
							}
						});
							str+="</li>"
							 str+="<li class='col'>"
							    +"<div class='row'>"
								+"<span class='tip orange'>免邮件</span>"
								+"<dl>"
								+"<dt><img src='./images/pj/pj7.jpg'></dt>"
								+"<dd class='name'>红米Pro 标准高透贴膜</dd>"
								+"<dd class='desc'>透光率高达92%，保留真实色彩</dd>"
								+"<dd class='price'>19元</dd>"
								+"</dl>"
								+"</div>"
								+"<div class='row row_half small-intro'>"
							  	+"<div class='small-introL'>"
							  	+"<b>小米小钢炮</b>"
							   	+"<small>79元</small>"
							   	+"</div>"
							   	+"<div class='small-introR'>"
							   	+"<img src='./images/pj/pj1.jpg'>"
							   	+"</div>"
							   	+"</div>"
							   	+"<div class='row row_half scan-more'>"
							   	+"<div class='scan-moreL'>"
							   	+"<b>浏览更多</b>"
							   	+"<small>热门</small>"
							   	+"</div>"
							   	+"<div class='scan-moreR icon'></div>"
							   	+"</div>"
							   	+"</li>";
							$("#shouye").append(str);
					});
				});
			
			</script>
			<section class="m-box line2">
				<div class="span4">
					<div class="main-pic">
						<img src="./images/znyj/row2Img.jpg">
					</div>
				</div>
				<div class="span16">
					<div class="m-slide">
						<div class="m-slide-contain m-s4">
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="shouye">
									
								</ul>
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="shouye1">
									
								</ul>
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="shouye2">
									
								</ul>
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="shouye3">
									
								</ul>
							</div>
						</div>
					</div> 
				</div>
			</section>
		</section>
		<!--配件结束-->
		<!-- 动态遍历结束 -->

		<!--周边开始-->
		<script type="text/javascript">
			$(function(){
				var ids=["zhoubian1","zhoubian2","zhoubian3","zhoubian4","zhoubian5"];
				var typeIds=[26,27,28,29,30];
				$.each(ids, function(i,vlues) {
					$.getJSON("WangXinYuanGoodsServlet?action=zhouBianShangPinType&typeId="+typeIds[i], function(data){
						var str = "<li class='col'>";
						$.each(data,function(n,goods){
								str+="<div class='row'>";
									if((n+1)%2==0){
										str+="<span class='tip blue'>有赠品</span>";

									}else{
										str+="<span class='tip orange'>免邮件</span>";
									}
									str+="<dl>"
										+"<dt><img src='./images/zb/"+goods.picPath+"'></dt>"
										+"<dd class='name'>"+goods.goodsName+"</dd>"
										+"<dd class='desc'>"+goods.describe+"</dd>"
										+"<dd class='price'>"+goods.goodsPrice+"元</dd>"
										+"</dl>"
										+"</div>";
                   	
								if((n+1)%2==0&&(n+1)!=data.length){
									str+="</li><li class='col'>";
								}	                   	
		                	});
		                str+="</li>"
		                str+="<li class='col'>"
						+"<div class='row'>"
						+"<span class='tip orange'>免邮件</span>"
						+"<dl>"
						+"	<dt><img src='./images/zb/zb7.jpg'></dt>"
						+"	<dd class='name'>小米路由器3</dd>"
						+"	<dd class='desc'>四天线设计，更安全更稳定</dd>"
						+"	<dd class='price'>149元</dd>"
						+"</dl>"
						+"</div>"
						+"<div class='row row_half small-intro'>"
						+"	<div class='small-introL'>"
						+"	<b>小米小钢炮</b>"
						+"		<small>79元</small>"
						+"</div>"
						+"<div class='small-introR'>"
						+"	<img src='./images/zb/zb0.jpg'>"
						+"	</div>"
						+"</div>"
						+"<div class='row row_half scan-more'>"
						+"<div class='scan-moreL'>"
						+"		<b>浏览更多</b>"
						+"		<small>热门</small>	"	
						+"	</div>"
						+"	<div class='scan-moreR icon'></div>"
						+"</div>"
						+"	</li>";
		                $("#"+vlues).append(str);
		               
					});
				});
			});
		</script>

		<section class="wraper mi-ambitus" id="ambitus">
			<input type="radio" id="ambitus-s1" class="ambitus-switch s1" name="ambitus-switch" hidden checked>
			<input type="radio" id="ambitus-s2" class="ambitus-switch s2" name="ambitus-switch" hidden>
			<input type="radio" id="ambitus-s3" class="ambitus-switch s3" name="ambitus-switch" hidden>
			<input type="radio" id="ambitus-s4" class="ambitus-switch s4" name="ambitus-switch" hidden>
			<input type="radio" id="ambitus-s5" class="ambitus-switch s5" name="ambitus-switch" hidden>
			<header class="m-hd">
				<h2 class="m-hdL">周边</h2>
				<div class="m-hdR">
					<ul class="tabs">
						<li class="item active tab tab1"><a href="#"><label for="ambitus-s1">热门</label></a></li>
						<li class="item tab tab2"><a href="#"><label for="ambitus-s2">服装</label></a></li>
						<li class="item tab tab3"><a href="#"><label for="ambitus-s3">米兔</label></a></li>
						<li class="item tab tab4"><a href="#"><label for="ambitus-s4">生活周边</label></a></li>
						<li class="item tab tab5"><a href="#"><label for="ambitus-s5">箱包</label></a></li>
					</ul>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span4">
					<div class="main-pic"><img src="./images/znyj/row2Img.jpg"></div>
				</div>
				<div class="span16">
					<div class="m-slide">
						<div class="m-slide-contain m-s5" >
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="zhoubian1">
									
								</ul>	
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="zhoubian2">
									
									
								</ul>	
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="zhoubian3">
									
								
								</ul>	
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="zhoubian4">
									
								</ul>	
							</div>
							<div class="m-slide-item">
								<ul class="m-cols m-col-4" id="zhoubian5">
								
								</ul>	
							</div>
						</div>
					</div>				
				</div>
			</section>
		</section>
		<!--周边结束-->

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


		<!--热评产品开始-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-22
    		描述：把自己热评产品部分改为动态的
		 -->
		 <script>
			$(function(){
				var ids=["buzz-products"];
				var typeIds=[23];
				$.each(ids, function(i,vlues) {
					$.getJSON("LiaoWeiChengGoodsServlet?action=match&typeId="+typeIds[i], function(data){
						var str = "<li class='col'>";
						$.each(data,function(n,goods){
							str+="<div class='row'>"
							+"<img src='./images/rpcp/"+goods.picPath+"'>"
							+"<div class='content'>"
							+"<div class='cmt'>"
							+goods.describe
									+"</div>"
									+"<div class='from'>来自于 yinyin19891117 的评价</div>"
									+"<a href='#' class='name'>"+goods.goodsName+"</a>"
									+"<a href='#' class='price'>"+goods.goodsPrice+"元</a>"	
									+"</div>"
							+"</div>"	                  
		                   str+="</li><li class='col'>"; 	                   	
		                });
						str+="</li>";
		                $("#"+vlues).append(str);		                
					});
				});
			});
		</script>
		<section id="comment" class="wraper mi-hotCmtProd">
			<header class="m-hd">
				<h2 class="m-hdL">热评产品</h2>
				<ul class="m-hdR">
					<li></li>
				</ul>
			</header>
			<section class="m-box">
				<ul class="m-cols m-col-4" id="buzz-products">
					<!--动态添加-->
				</ul>
			</section>
		</section>
		<!--热评产品结束-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-22
    		描述：把自己热评产品部分已完成
		 -->
		
		
		
		<!--内容开始-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-22
    		描述：把自己热评产品部分改为动态的
		 -->
		 <script>
			$(function(){
				var ids=["con"];
				var typeIds=[24];
				$.each(ids, function(i,vlues) {
					$.getJSON("LiaoWeiChengGoodsServlet?action=match&typeId="+typeIds[i], function(data){
						var str = "<li class='col orange'>";
						$.each(data,function(n,goods){
							str+="<div class='row'>"
							+"<dl>"
							+"<dt class='type'>图书</dt>"
							+"<dd class='name'>"+goods.goodsName+"</dd>"
							+"<dd class='desc' style='font-size: 12px;'>"+goods.describe+"</dd>"
							+"<dd class='status' style='font-size: 12px;'>"+goods.goodsPrice+"</dd>"
							+"<dd><img src='./images/content/"+goods.picPath+"'></dd>"
							+"</dl>"
							+"</div>"	                  
		                   str+="</li><li class='col orange'>"; 	                   	
		                });
						str+="</li>";
		                $("#"+vlues).append(str);		                
					});
				});
			});
		</script> 
				
		<section class="wraper mi-content" id="content">
			<header class="m-hd">
				<h2 class="m-hdL">内容</h2>
				<ul class="m-hdR">
					<li></li>
				</ul>
			</header>
			<section class="m-box">
				<ul class="m-cols m-col-4" id="con">
					<!-- 动态添加 -->
					
				</ul>
			</section>
		</section>
		<!--内容结束-->
		<!-- 
			作者：廖伟成
    		时间：2018-10-22
    		描述：把内容部分已完成
		 -->
		
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