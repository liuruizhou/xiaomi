package com.mi.liaoweicheng.service.impl;

import java.util.List;

import com.mi.liaoweicheng.dao.GoodsTypeDao;
import com.mi.liaoweicheng.dao.impl.GoodsTypeDaoImpl;
import com.mi.liaoweicheng.dao.po.GoodType;
import com.mi.liaoweicheng.service.GoodsTypeService;

public class GoodsTypeServiceImpl implements GoodsTypeService
{
	private GoodsTypeDao goodstypeDao=new GoodsTypeDaoImpl();
	@Override
	public GoodType getById(int typeId)
	{
		return goodstypeDao.getById(typeId);
	}

	@Override
	public List<GoodType> listAll()
	{
		return goodstypeDao.listAll();
	}

}
