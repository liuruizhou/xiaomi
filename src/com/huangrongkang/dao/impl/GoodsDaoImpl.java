package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huangrongkang.dao.IGoodsDao;
import com.huangrongkang.dao.po.Goods;
import com.huangrongkang.dao.util.JdbcUtil;


public class GoodsDaoImpl implements IGoodsDao {

	@Override
	public Goods getById(int id) {
		Goods goods = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConn();
		String sql = "select * from goods where goods_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				goods = new Goods();
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
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return goods;
	}

}
