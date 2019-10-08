package com.huangrongkang.dao.po;

public class Goods_color {
	private Integer goodsId;
	private Integer colorId;
	public Goods_color() {
		super();
	}
	public Goods_color(Integer goodsId, Integer colorId) {
		super();
		this.goodsId = goodsId;
		this.colorId = colorId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

}
