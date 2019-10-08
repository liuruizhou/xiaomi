package com.mi.liuruizhou.dao.po;

public class GoodType {
	private int typeId;
	private String typeName;

	public GoodType() {
		super();
	}

	public GoodType(int typeId, String typeName) {
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
		return "GoodType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
