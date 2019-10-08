package com.huangrongkang.service;

import java.util.List;

import com.huangrongkang.dao.po.Edition;


public interface IEditionService {
	public List<Edition> listAll(Integer id);
}
