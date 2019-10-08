package com.huangrongkang.dao;

import java.util.List;

import com.huangrongkang.dao.po.Color;


public interface IColorDao {
	public int save(Color color);
	public int delete(int id);
	public int update(Color color);
	public Color getById(int id);
	public List<Color> listAll(Integer id);
}
