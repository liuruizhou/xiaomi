package com.mi.liuruizhou.dao.po;

public class Trading_State {
	private int tradingId;
	private String description;
	public Trading_State(int tradingId, String description) {
		super();
		this.tradingId = tradingId;
		this.description = description;
	}
	public Trading_State() {
		super();
	}
	public int getTradingId() {
		return tradingId;
	}
	public void setTradingId(int tradingId) {
		this.tradingId = tradingId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Trading_State [tradingId=" + tradingId + ", description=" + description + "]";
	}
	
	
}
