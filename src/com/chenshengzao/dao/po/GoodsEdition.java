package com.chenshengzao.dao.po;

public class GoodsEdition {
	private int goodsId;
	private int editionId;
	public GoodsEdition() {
		super();
	}
	public GoodsEdition(int goodsId, int editionId) {
		super();
		this.goodsId = goodsId;
		this.editionId = editionId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getEditionId() {
		return editionId;
	}
	public void setEditionId(int editionId) {
		this.editionId = editionId;
	}
	@Override
	public String toString() {
		return "GoodsEdition [goodsId=" + goodsId + ", editionId=" + editionId + "]";
	}
	
}
