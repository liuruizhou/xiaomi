package com.wangxinyuan.dao.po;

import java.util.Date;

public class Picture {
	private int picture_id;
	private String url;
	private Date uploadtime;
	private int goods_id;
	private int no;
	public int getPicture_id() {
		return picture_id;
	}
	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Picture() {
		super();
	}
	public Picture(int picture_id, String url, Date uploadtime, int goods_id, int no) {
		super();
		this.picture_id = picture_id;
		this.url = url;
		this.uploadtime = uploadtime;
		this.goods_id = goods_id;
		this.no = no;
	}
	@Override
	public String toString() {
		return "Picture [picture_id=" + picture_id + ", url=" + url + ", uploadtime=" + uploadtime + ", goods_id="
				+ goods_id + ", no=" + no + "]";
	}
	
}
