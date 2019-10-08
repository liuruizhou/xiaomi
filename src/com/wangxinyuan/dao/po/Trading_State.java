package com.wangxinyuan.dao.po;

public class Trading_State {
	private int trading_id;
	private String description;
	public int getTrading_id() {
		return trading_id;
	}
	public void setTrading_id(int trading_id) {
		this.trading_id = trading_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Trading_State() {
		super();
	}
	public Trading_State(int trading_id, String description) {
		super();
		this.trading_id = trading_id;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Trading_State [trading_id=" + trading_id + ", description=" + description + "]";
	}
	
}
