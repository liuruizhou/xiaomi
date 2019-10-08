package com.huangrongkang.service.impl;

import java.util.List;

import com.huangrongkang.dao.IEditionDao;
import com.huangrongkang.dao.impl.EditionDaoImpl;
import com.huangrongkang.dao.po.Edition;
import com.huangrongkang.service.IEditionService;

public class EditionServiceImpl implements IEditionService {
	IEditionDao edtionDao = new EditionDaoImpl();
	@Override
	public List<Edition> listAll(Integer id) {
		return edtionDao.listAll(id);
	}

}
