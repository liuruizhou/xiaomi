package com.huangrongkang.dao.po;

public class Edition {
	//商品信息
	
	private Integer editionId;
	private String editionName;
	
	@Override
	public String toString() {
		return "[editionId=" + editionId + ", editionName=" + editionName + "]";
	}
	public Edition() {
	}
	public Edition(Integer editionId, String editionName) {
		this.editionId = editionId;
		this.editionName = editionName;
	}
	public Integer getEditionId() {
		return editionId;
	}
	public void setEditionId(Integer editionId) {
		this.editionId = editionId;
	}
	public String getEditionName() {
		return editionName;
	}
	public void setEditionName(String editionName) {
		this.editionName = editionName;
	}
}
