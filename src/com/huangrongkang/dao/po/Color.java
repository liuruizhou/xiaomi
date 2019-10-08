package com.huangrongkang.dao.po;

public class Color {
/*
 * CREATE TABLE `color` (
  `color_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ÑÕÉ«ID',
  `color_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'ÑÕÉ«Ãû³Æ',
  PRIMARY KEY (`color_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


 */
	private Integer colorId;
	private String colorName;
	public Color() {
		super();
	}
	public Color(Integer colorId, String colorName) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
	}
	public Integer getColorId() {
		return colorId;
	}
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	
}
