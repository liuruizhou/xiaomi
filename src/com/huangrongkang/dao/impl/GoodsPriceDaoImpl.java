package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.huangrongkang.dao.IGoodsPriceDao;
import com.huangrongkang.dao.po.Goods_price;
import com.huangrongkang.dao.util.JdbcUtil;

public class GoodsPriceDaoImpl implements IGoodsPriceDao {

	@Override
	public Goods_price getByEditionId(Integer goodsId,Integer EditionId) {
		Goods_price goods_price = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConn();
		String sql="select * from goods_price where id in (select price_id from goods_edition where goods_id=? and edition_id=?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, goodsId);
			pstmt.setObject(2, EditionId);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				goods_price = new Goods_price();
				goods_price.setId(rs.getInt("id"));
				goods_price.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return goods_price;
	}

}
