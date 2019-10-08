package com.mi.liaoweicheng.dao.po;

public class Goods {
	private int goodsId;
	private String goodsName;
	private String describe;
	private String goodsPrice;
	private String picPath;
	private String url;
	private int typeId;
	public Goods() {
		super();
	}
	
	public Goods(int goodsId, String goodsName, String describe, String goodsPrice, String picPath, String url,
			int typeId)
	{
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.describe = describe;
		this.goodsPrice = goodsPrice;
		this.picPath = picPath;
		this.url = url;
		this.typeId = typeId;
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString()
	{
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", describe=" + describe + ", goodsPrice="
				+ goodsPrice + ", picPath=" + picPath + ", url=" + url + ", typeId=" + typeId + "]";
	}
	
	

}
