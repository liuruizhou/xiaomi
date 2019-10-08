package com.huangrongkang.dao.po;

public class Goods_edition {
/*
 * CREATE TABLE `goods_edition` (
  `goods_id` int(11) NOT NULL COMMENT '…Ã∆∑id',
  `edition_id` int(11) NOT NULL COMMENT '∞Ê±æid',
  PRIMARY KEY (`goods_id`,`edition_id`),
  KEY `hoods_edition_edition_id-edition_id` (`edition_id`),
  CONSTRAINT `goods_edition_goods_id-goods_id` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `hoods_edition_edition_id-edition_id` FOREIGN KEY (`edition_id`) REFERENCES `edition` (`edition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


 */
	private Integer goodsId;
	private Integer editionId;
	public Goods_edition() {
	}
	public Goods_edition(Integer goodsId, Integer editionId) {
		this.goodsId = goodsId;
		this.editionId = editionId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getEditionId() {
		return editionId;
	}
	public void setEditionId(Integer editionId) {
		this.editionId = editionId;
	}
}
