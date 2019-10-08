package com.huangrongkang.service.impl;

import java.util.List;

import com.huangrongkang.dao.IPictureDao;
import com.huangrongkang.dao.impl.PictureDaoImpl;
import com.huangrongkang.dao.po.Picture;
import com.huangrongkang.service.IPictureService;

public class PictureServiecImpl implements IPictureService {
	IPictureDao  pictureDao=new PictureDaoImpl();
	@Override
	public List<Picture> getGoodsIdByUrl(int goodsId) {
		return pictureDao.getGoodsIdByUrl(goodsId);
	}

}
