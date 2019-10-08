package com.chenshengzao.dao.po;

public class GoodsType {
	private int typeId;
	private String typeName;
	public GoodsType() {
		super();
	}
	public GoodsType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "GoodsType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}
