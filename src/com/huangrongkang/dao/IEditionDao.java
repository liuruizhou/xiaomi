package com.huangrongkang.dao;

import java.util.List;

import com.huangrongkang.dao.po.Edition;

public interface IEditionDao {
	public List<Edition> listAll(Integer id);
}
