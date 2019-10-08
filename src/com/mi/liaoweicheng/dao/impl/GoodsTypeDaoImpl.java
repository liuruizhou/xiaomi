package com.mi.liaoweicheng.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mi.liaoweicheng.dao.GoodsTypeDao;
import com.mi.liaoweicheng.dao.po.GoodType;
import com.mi.liaoweicheng.dao.utils.JdbcUtil;

public class GoodsTypeDaoImpl implements GoodsTypeDao
{
	@Override
	public GoodType getById(int typeId)
	{
		GoodType goodstype = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn=null;
		try {
			conn = JdbcUtil.getConnection();
			String typeIdSql = "select * from goods_type where type_id = ? ";
			ps  = conn.prepareStatement(typeIdSql);
			ps.setInt(1, typeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				goodstype = new GoodType();
				goodstype.setTypeId(rs.getInt("type_id"));
				goodstype.setTypeName(rs.getString("type_name"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goodstype;
	}

	@Override
	public List<GoodType> listAll()
	{
		List<GoodType> goodstypeList  =  new ArrayList<GoodType>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = JdbcUtil.getConnection();
		String allTypeSql = "select * from goods_type";
		try {
			ps  = conn.prepareStatement(allTypeSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				GoodType goodstype = new GoodType();
				goodstype.setTypeId(rs.getInt("type_id"));
				goodstype.setTypeName(rs.getString("type_name"));			
				goodstypeList.add(goodstype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goodstypeList;
	}

}
