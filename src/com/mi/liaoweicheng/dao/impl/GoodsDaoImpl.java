package com.mi.liaoweicheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.liaoweicheng.dao.GoodsDao;
import com.mi.liaoweicheng.dao.po.Goods;
import com.mi.liaoweicheng.dao.utils.JdbcUtil;

public class GoodsDaoImpl implements GoodsDao
{
		
	@Override
	public List<Goods> getGoodsByTypeId(int typeId)
	{
		List<Goods> goodsList = new ArrayList<Goods>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String goodsByTypeIdSql = "SELECT * FROM goods where type_id=?";
			ps = conn.prepareStatement(goodsByTypeIdSql);
			ps.setObject(1, typeId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setDescribe(rs.getString("describe"));
				goods.setGoodsPrice(rs.getString("goods_price"));
				goods.setPicPath(rs.getString("pic_path"));
				goods.setUrl(rs.getString("url"));
				goods.setTypeId(typeId);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goodsList;
	}

	

}
