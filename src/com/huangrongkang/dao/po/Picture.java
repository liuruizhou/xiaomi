package com.huangrongkang.dao.po;

import java.util.Date;

public class Picture {
	//ͼƬ
	private Integer pictureId;
	private String url;
	private Date uploadtime;
	private Integer goodsId;
	private Integer no;
	public Picture() {
		super();
	}
	public Picture(Integer pictureId, String url, Date uploadtime, Integer goodsId, Integer no) {
		super();
		this.pictureId = pictureId;
		this.url = url;
		this.uploadtime = uploadtime;
		this.goodsId = goodsId;
		this.no = no;
	}
	public Integer getPictureId() {
		return pictureId;
	}
	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
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
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
}
