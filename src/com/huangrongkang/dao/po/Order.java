package com.huangrongkang.dao.po;

import java.util.Date;

public class Order {

	//¶©µ¥
	private Integer id;
	private Integer goodsId;
	private String orderNumber;
	private String price;
	private Date tradingHour;
	private Integer stateId;
	private Integer userId;
	public Order() {
	}
	public Order(Integer id, Integer goodsId, String orderNumber, String price, Date tradingHour, Integer stateId,
			Integer userId) {
		this.id = id;
		this.goodsId = goodsId;
		this.orderNumber = orderNumber;
		this.price = price;
		this.tradingHour = tradingHour;
		this.stateId = stateId;
		this.userId = userId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Date getTradingHour() {
		return tradingHour;
	}
	public void setTradingHour(Date tradingHour) {
		this.tradingHour = tradingHour;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
