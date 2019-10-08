package com.huangrongkang.dao.po;

public class Goods_type {

	//商品类型
	private Integer typeId;
	private String typeName;
	public Goods_type() {
	}
	public Goods_type(Integer typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
