package com.huangrongkang.service;

import java.util.List;

import com.huangrongkang.dao.po.Picture;

public interface IPictureService {
	public List<Picture> getGoodsIdByUrl(int goodsId);
}
