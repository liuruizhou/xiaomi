package com.chenshengzao.dao.po;

import java.util.Date;

public class Picture {
	private int pictureId;
	private String url;
	private Date uploadtime;
	private int goodsId;
	private int no;
	
	public Picture() {
		super();
	}
	public Picture(int pictureId, String url, Date uploadtime, int goodsId, int no) {
		super();
		this.pictureId = pictureId;
		this.url = url;
		this.uploadtime = uploadtime;
		this.goodsId = goodsId;
		this.no = no;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
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
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Picture [pictureId=" + pictureId + ", url=" + url + ", uploadtime=" + uploadtime + ", goodsId="
				+ goodsId + ", no=" + no + "]";
	}
	
	
}
