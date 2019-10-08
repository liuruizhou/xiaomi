package com.mi.liaoweicheng.dao.test;

import java.util.List;

import org.junit.Test;

import com.mi.liaoweicheng.dao.GoodsTypeDao;
import com.mi.liaoweicheng.dao.impl.GoodsTypeDaoImpl;
import com.mi.liaoweicheng.dao.po.GoodType;

public class TestGoodsType
{
	@Test
	public void getByTypeId(){
		 GoodsTypeDao goodstypeDao = new GoodsTypeDaoImpl();
		 GoodType  allgoods = goodstypeDao.getById(23);	
		System.out.println(allgoods);
	}
	@Test
	public void listAll(){
		 GoodsTypeDao goodstypeDao = new GoodsTypeDaoImpl();
		 List<GoodType>  allgoods = goodstypeDao.listAll();
		 for (GoodType goodstype : allgoods) {
			 System.out.println(goodstype.getTypeId()+goodstype.getTypeName());
		}
	}
}
