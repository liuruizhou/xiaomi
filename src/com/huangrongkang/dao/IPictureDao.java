package com.huangrongkang.dao;

import java.util.List;

import com.huangrongkang.dao.po.Picture;

public interface IPictureDao {
	public List<Picture> getGoodsIdByUrl(int goodsId);
}
