package com.chenshengzao.dao.po;

public class GoodsColor {
	private int goodsId;
	private int colorId;
	public GoodsColor() {
		super();
	}
	public GoodsColor(int goodsId, int colorId) {
		super();
		this.goodsId = goodsId;
		this.colorId = colorId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	@Override
	public String toString() {
		return "GoodsColor [goodsId=" + goodsId + ", colorId=" + colorId +  "]";
	}
	
}
