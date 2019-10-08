<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>我的购物车-小米商城</title>
		<link rel="stylesheet" type="text/css" href="./css/login/style.css">
		<script type="text/javascript" src="js/jquery-1.8.3.js" ></script>
		<script type="text/javascript" src="js/gouwuche.js" ></script>
	</head>
	<body>


	<script type="text/javascript">
		$(function(){
			$.getJSON("WangXinYuanCartServlet?action=userCart&userId="+$("#sessionScope-user-userId").val(), function(data){
				
				var gList=data.gList;
				var cart=data.cart;
				var str="<div class='top2 center'>"
						+"<div class='sub_top fl'>"
						+"<input type='checkbox' value='quanxuan' class='quanxuan' id='allCheckBox' />全选"
						+"	</div>"
						+"<div class='sub_top fl'>商品名称</div>"
						+"<div class='sub_top fl'>单价(单位：元)</div>"
						+"<div class='sub_top fl'>数量</div>"
						+"<div class='sub_top fl'>小计(单位：元)</div>"
						+"<div class='sub_top fr'>操作</div>"
						+"<div class='clear'></div>"
						+"</div>";
						var pathStr=["single","dp","znyj","wntj","zb","pj"];
				  $.each(gList, function(i,goods){
				   		 str+=" <div class='content2 center'>"
				   			+"	<div class='sub_content fl '>"
							+"	<input type='checkbox' value='quanxuan' class='quanxuan' name='cartCheckBox' id='xiaoquanxuan' />"
							+"	</div>"
							+"	<div class='sub_content fl'><img style='width: 80px;' src='./images/";
				   		if(goods.typeId==17){
							str+=pathStr[0]+"/";
						}else if(goods.typeId>30&&goods.typeId<35){
							str+=pathStr[1]+"/";
						}else if(goods.typeId==19){
							str+=pathStr[2]+"/";
						}else if(goods.typeId==22){
							str+=pathStr[3]+"/";
						}else if(goods.typeId>25&&goods.typeId<31){
							str+=pathStr[4]+"/";
						}
							str+=goods.picPath+"'></div>"
							+"	<div class='sub_content fl ft20'>"+goods.describe+"</div>"
							+"	<div class='sub_content fl'><span id='guc_price'>"+goods.goodsPrice+"</span></div>"
							+"	<div class='sub_content fl'>"
							+"	<input class='shuliang' type='text' value='"+cart[i].number+"' onkeyup='dudu("+cart[i].id+","+i+")' >"
							+"  </div>"
							+"  <div class='sub_content fl'><span id='xiaoji'>2599</span></div>"
							+"  <div class='sub_content fl'><a href='#' class='getcart-id' alt='"+goods.goodsId+"' id='"+cart[i].id+"'>×</a></div>"
							+"	<div class='clear'></div>"
							+"  </div>";
				  });
				  $("#shopping").append(str);
				  countProducts();
				/* //刘锐洲整合
				  var zongji=countProducts();
				  if(zongji<=0){
					  window.location.href="gouwuche1.jsp";
				  } */
					zongshu();
				});
			$(".sub_content").find("a").live("click",function(){ ///jquery 1.9(不包括1.9)以下可以
				 var isYes = confirm("确定要删除这条购物记录么？");
					if (isYes) {
						var id=$(this).attr("id");
						/* alert(id); */
						shanchu(id);
						$(this).parent().parent().remove();	
					}
					zongshu();
					var checkedCartCheckBoxes = $(".sub_content").children("input[name='cartCheckBox']");
					var count = checkedCartCheckBoxes.size();
					if (0 == count) {
						$("#allCheckBox").attr("checked", false);
					}
					var k = 0;
					for (var i = 0; i < count; i++) {
						var cartCheckBox = $(checkedCartCheckBoxes[i]);
						if (cartCheckBox.is(":checked")) {
							k++;
						}
					}
					$("#xuanze").text(k);
					//刘锐洲整合
					 /*  var zongji=countProducts();
					  if(zongji<=0){
						  window.location.href="gouwuche1.jsp";
					  } */
	           });
			
			 $("#allCheckBox").live("click",function(){
				//获取全选复选框的状态ture or false
					var isChecked = $(this).is(":checked");
					var checkedCartCheckBoxes = $(".sub_content").children("input[name='cartCheckBox']");
					var count = checkedCartCheckBoxes.size();
					$("#xuanze").text(count);
					//设置子复选框的跟全选复选框的状态一致
					//$(".cart_td_1").find("input[name='cartCheckBox']").attr("checked",isChecked);
					$(".sub_content").children("input[name='cartCheckBox']").attr("checked", isChecked);
					countProducts(); 
					
			 });
			
			$("#xiaoquanxuan").live("click",function(){
				var checkedCartCheckBoxes = $(".sub_content").children("input[name='cartCheckBox']");
				var count = checkedCartCheckBoxes.size();
				var k = 0;
				for (var i = 0; i < count; i++) {
					var cartCheckBox = $(checkedCartCheckBoxes[i]);
					if (cartCheckBox.is(":checked")) {
						k++;
					}
				}
				$("#xuanze").text(k);
				if (k == count) {
					$("#allCheckBox").attr("checked", true);
				} else {
					$("#allCheckBox").attr("checked", false);
				}
				 countProducts();
			 }); 
		});
	</script>
		<c:choose>
			<c:when test="${sessionScope.user!=null }">
				<input hidden id="sessionScope-user-userId" value="${sessionScope.user.userId }">
			</c:when>
			<c:otherwise>
				<c:redirect url="gouwuche0.jsp"></c:redirect>
			</c:otherwise>
		</c:choose>

		<div class="banner_x center">
			<a href="./index.jsp" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				<ul>
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
				</ul>
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj" style="height:auto;">
			<div class="gwcxd center" id="shopping">
						
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="./select.jsp">继续购物</a></li>
						<li>|</li>
						<li>共<span id="zongshu">0</span>件商品，已选择<span id="xuanze">0</span>件</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span id="zongji">0.00</span>元</div>
					<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan" id="shengchengdingdang" value="去结算"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>			
		</div>
		<!-- 刘锐洲生成订单 -->
		<script>
			$(function(){
				$("#shengchengdingdang").click(function(){
					var userId=$("#sessionScope-user-userId").val();
					var goodsId=$(".getcart-id").attr("alt");
					var products = $("#shopping").find("div[class='content2 center']");
					products.each(function(i, dom) {
						var tr = $(dom);
							var danjia = tr.find("#guc_price").text();
							var shuliang = tr.find(".shuliang").val();
							var goodsId=tr.find(".getcart-id").attr("alt");
							var cardId=tr.find(".getcart-id").attr("id");
							var xiaoji = shuliang * danjia;
							tr.find("#xiaoji").text(xiaoji.toFixed(2));
						if($(dom).find("#xiaoquanxuan").is(':checked')){
							$.getJSON("LiuRuizhouOrdersServlet?action=save&goodsId="+goodsId+"&price="+xiaoji+"&userId="+userId, function(isfag){ 
								alert("添加成功"); 
								shanchu(cardId);
								tr.remove();
								countProducts();
								zongshu();
							});
						}
					});
				});
				
			});
		</script>
		<!--订单生成结束 -->
		
	<!-- footer -->
		<footer class="center">
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>

	</body>
</html>