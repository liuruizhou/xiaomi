package com.chenshengzao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chenshengzao.dao.IGoodsDao;
import com.chenshengzao.dao.po.Goods;
import com.chenshengzao.dao.utils.JdbcUtil;


public class GoodsDaoImpl implements IGoodsDao{

	@Override
	public List<Goods> getGoodsBytypeId(int typeId) {
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConnection();
		String sql="select * from goods where type_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,typeId);
			rs=ps.executeQuery();
			while (rs.next()) 
			{
				Goods goods =new Goods();
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setDescribe(rs.getString(3));
				goods.setGoodsPrice(rs.getString(4));
				goods.setPicPath(rs.getString(5));
				goods.setUrl(rs.getString(6));
				goods.setTypeId(rs.getInt(7));
				list.add(goods);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return list;
	}

	
	public Goods getGoodsIdBypiPath(int goodsId) {
		Goods goods=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConnection();
		String sql="SELECT pic_Path FROM goods WHERE goods_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,goodsId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				goods=new Goods();
				goods.setPicPath(rs.getString("pic_Path"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		
		return goods;
	}

}
