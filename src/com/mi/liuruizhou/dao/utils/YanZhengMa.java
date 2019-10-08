package com.mi.liuruizhou.dao.utils;

import java.util.Date;

public class YanZhengMa {
	private Date date;
	private String ma;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public YanZhengMa() {
		super();
	}
	public YanZhengMa(Date date, String ma) {
		super();
		this.date = date;
		this.ma = ma;
	}
}
