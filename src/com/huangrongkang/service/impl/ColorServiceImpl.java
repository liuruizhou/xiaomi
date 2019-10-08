package com.huangrongkang.service.impl;

import java.util.List;

import com.huangrongkang.dao.IColorDao;
import com.huangrongkang.dao.impl.ColorDaoImpl;
import com.huangrongkang.dao.po.Color;
import com.huangrongkang.service.IColorService;


public class ColorServiceImpl implements IColorService {
	IColorDao colorDao=new ColorDaoImpl();
	@Override
	public int save(Color color) {
		return colorDao.save(color);
	}

	@Override
	public int delete(int id) {
		return colorDao.delete(id);
	}

	@Override
	public int update(Color color) {
		return colorDao.update(color);
	}

	@Override
	public Color getById(int id) {
		return colorDao.getById(id);
	}

	@Override
	public List<Color> listAll(Integer id) {
		return colorDao.listAll(id);
	}

}
