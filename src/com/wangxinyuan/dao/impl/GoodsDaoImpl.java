package com.wangxinyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wangxinyuan.dao.GoodsDao;
import com.wangxinyuan.dao.po.Goods;
import com.wangxinyuan.dao.utils.JdbcUtil;

public class GoodsDaoImpl implements GoodsDao {
	
	@Override
	public List<Goods> listAllByTypeId(int id) {
		List<Goods> lists=new ArrayList<Goods>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		String sql = " SELECT * FROM Goods where type_id=?";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setDescribe(rs.getString("describe"));
				goods.setGoodsPrice(rs.getString("goods_price"));
				goods.setPicPath(rs.getString("pic_path"));
				goods.setUrl(rs.getString("url"));
				goods.setTypeId(rs.getInt("type_id"));
				lists.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return lists;
	}

	@Override
	public Goods listAllByUserId(int id) {
		Goods goods = new Goods();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		String sql = " SELECT * FROM Goods where goods_id=?";
		try {
			ps  = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setDescribe(rs.getString("describe"));
				goods.setGoodsPrice(rs.getString("goods_price"));
				goods.setPicPath(rs.getString("pic_path"));
				goods.setUrl(rs.getString("url"));
				goods.setTypeId(rs.getInt("type_id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goods;
	}

}
