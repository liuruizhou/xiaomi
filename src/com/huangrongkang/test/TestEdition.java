package com.huangrongkang.test;

import java.util.List;

import org.junit.Test;

import com.huangrongkang.dao.IColorDao;
import com.huangrongkang.dao.IEditionDao;
import com.huangrongkang.dao.IGoodsPriceDao;
import com.huangrongkang.dao.impl.ColorDaoImpl;
import com.huangrongkang.dao.impl.EditionDaoImpl;
import com.huangrongkang.dao.impl.GoodsPriceDaoImpl;
import com.huangrongkang.dao.po.Color;
import com.huangrongkang.dao.po.Edition;
import com.huangrongkang.dao.po.Goods_price;

public class TestEdition {
	/*IEditionDao editionDao = new EditionDaoImpl();
	IColorDao colorDao = new ColorDaoImpl();
	IGoodsPriceDao goodsPriceDao = new GoodsPriceDaoImpl();
	@Test
	public void test()
	{
		List<Edition> list = editionDao.listAll(10100005);
		for (Edition edition : list) {
			System.out.println(edition);
		}
	}
	
	@Test
	public void test1()
	{
		List<Color> list = colorDao.listAll(10408011);
		for (Color color : list) {
			System.out.println(color);
		}
	}
	
	@Test
	public void test2()
	{
		Goods_price good =  goodsPriceDao.getByEditionId(10100005,1);
		System.out.println(good.getPrice());
	}*/
}
