package com.huangrongkang.dao.po;

public class Cart {

	//¹ºÎï³µ

	private Integer id;
	private Integer goodsId;
	private Integer userId;
	private String number;
	private String subtoatl;
	public Cart() {
	}
	public Cart(int id, int goodsId, int userId, String number, String subtoatl) {
		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.number = number;
		this.subtoatl = subtoatl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSubtoatl() {
		return subtoatl;
	}
	public void setSubtoatl(String subtoatl) {
		this.subtoatl = subtoatl;
	}
}
