package com.huangrongkang.service;

import java.util.List;

import com.huangrongkang.dao.po.Color;


public interface IColorService {
	public int save(Color color);
	public int delete(int id);
	public int update(Color color);
	public Color getById(int id);
	public List<Color> listAll(Integer id);
}
