package com.huangrongkang.dao.po;

public class Trading_state {
	//��������
	private Integer tradingId;
	private String description;
	public Trading_state() {
	}
	public Trading_state(Integer tradingId, String description) {
		this.tradingId = tradingId;
		this.description = description;
	}
	public Integer getTradingId() {
		return tradingId;
	}
	public void setTradingId(Integer tradingId) {
		this.tradingId = tradingId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
