package com.chenshengzao.dao.po;


public class Orders {
	private int id;
	private int goodsId;
	private String orderNumber;
	private String price;
	private String tradingHour;
	private int stateId;
	private int userId;

	public Orders() {
		super();
	}

	public Orders(int id, int goodsId, String orderNumber, String price, String tradingHour, int stateId, int userId) {
		super();
		this.id = id;
		this.goodsId = goodsId;
		this.orderNumber = orderNumber;
		this.price = price;
		this.tradingHour = tradingHour;
		this.stateId = stateId;
		this.userId = userId;
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

	public String getTradingHour() {
		return tradingHour;
	}

	public void setTradingHour(String tradingHour) {
		this.tradingHour = tradingHour;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", goodsId=" + goodsId + ", orderNumber=" + orderNumber + ", price=" + price
				+ ", tradingHour=" + tradingHour + ", stateId=" + stateId + ", userId=" + userId + "]";
	}

}
