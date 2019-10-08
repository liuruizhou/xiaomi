function dudu(cart,i){
	countProducts();
	var products = $("#shopping").find("div[class='content2 center']");
		var tr = $(products[i]);
		var danjia = tr.find("#guc_price").text();
		var shuliang = tr.find(".shuliang").val();	
		var xiaoji = shuliang * danjia;
		$.getJSON("WangXinYuanCartServlet?action=setxiaoji&Cartid="+cart+"&subtotal="+xiaoji+"&shuliang="+shuliang);
}

function countProducts() {
		var products = $("#shopping").find("div[class='content2 center']");
		var zongji = 0;
		products.each(function(i, dom) {
			var tr = $(dom);
				var danjia = tr.find("#guc_price").text();
				var shuliang = tr.find(".shuliang").val();
				var xiaoji = shuliang * danjia;
				tr.find("#xiaoji").text(xiaoji.toFixed(2));
			if($(dom).find("#xiaoquanxuan").is(':checked')){
				zongji += xiaoji;
			}
		});
		$("#zongji").text(zongji.toFixed(2));
		return zongji;
	}
	
	function zongshu() {
		var zongtiaoshu = $("#shopping").find("div[class='content2 center']").size();
		$("#zongshu").text(zongtiaoshu);
	}
	
	function shanchu(id){
		$.getJSON("WangXinYuanCartServlet?action=shanchu&Cartid="+id);
	}
	
	

window.onload=function(){
	//计算商品金额总价
	countProducts();
	zongshu();
}
