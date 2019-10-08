$(function(){
		init();
		$("#selectbtn").click(function(){
			var likesql=$("#selectinput").val();
			var orderBy="type_id";
			 $("#m-slide-contain-1").children().remove();
			init(20,1,likesql,orderBy);
		});
		$("#orderbyprice").click(function(){
			var likesql=$("#selectinput").val();
			var orderBy="goods_price";
			$("#m-slide-contain-1").children().remove();
			init(20,1,likesql,orderBy);
		});
	});
	function init(pageSize1,currentPage1,likesql1,orderBy1){
				if(pageSize1==null||pageSize1==""||currentPage1==null||currentPage1==""){
					pageSize1=20;
					currentPage1=1;
				}
				if(likesql1==null||likesql1==""||orderBy1==null||orderBy1==""){
					likesql1="";
					orderBy1="type_id";
				}
				$.getJSON("LiuRuizhouGoodsServlet?action=getPage&pageSize="+pageSize1+"&currentPage="+currentPage1+"&likesql="+likesql1+"&orderBy="+orderBy1, function(data){
					var pathStr=["single","dp","znyj","wntj","zb","pj"];
					var str = "<div class='m-slide-item' style='margin-left: -50%;'><ul class='m-cols m-col-5'>";
					$.each(data.lists,function(n,goods){
		            	str+="<li class='col sku-item ' id='goodsxiangqing' style='border: 0px;'>"
									+"<dl class='row' style='background-color: #FFFFFF;'>"
										+"<dt><img src='./images/";
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
										str+=goods.picPath+"'></dt>"
										+"<dd class='name'>"+goods.goodsName+"</dd>"
										+"<dd class='desc'>"+goods.describe+"</dd>"
										+"<dd class='price'>"+goods.goodsPrice+"元</dd>"
									+"</dl>"
								+"</li>";
		               	if(n>0&&(n+1)%5==0&&(n+1)!=data.lists.length){
		               		str+="</ul></div><div style='height: 20px;'></div>"
								 +"<div class='m-slide-item' style='margin-left: -50%;'>"
								 +"<ul class='m-cols m-col-5'>";
		               	}
		            });
		            str+="</ul></div><div style='height: 20px;'></div>"
								 +"<div class='m-slide-item' style='margin-left: -50%;'>"
								 +"<ul class='m-cols m-col-5'>";
		            $("#m-slide-contain-1").append(str);
		            pagebtn(data.currentPage,data.totalPage,data.pageSize,data.count);
				});
			}
	
	
	function pagebtn(curPage1,pageTotal1,pageAmount1,dataTotal1) {
	    new myPagination({
	        id: 'pagination',
	        curPage:curPage1, //初始页码
	        pageTotal: pageTotal1, //总页数
			pageAmount: pageAmount1,  //每页多少条
	        dataTotal: dataTotal1, //总共多少条数据
			pageSize: 5, //显示分页按钮的个数不是数据库的分页记录数
	        showPageTotalFlag:true, //是否显示数据统计
	        showSkipInputFlag:true, //是否支持跳转
	        getPage: function (page) {
	            //获取当前页数
	            $("#m-slide-contain-1").children().remove();
	            init(pageAmount1,page,$("#selectinput").val(),"type_id");
	            $('body,html').animate({scrollTop:0},500);
	        }
	    })
	}
