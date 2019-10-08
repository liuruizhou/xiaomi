package com.huangrongkang.dao.po;

public class Goods_price {
	private Integer id;
	private Double price;
	@Override
	public String toString() {
		return "Goods_price [id=" + id + ", price=" + price + "]";
	}
	public Goods_price() {
	}
	public Goods_price(Integer id, Double price) {
		this.id = id;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
