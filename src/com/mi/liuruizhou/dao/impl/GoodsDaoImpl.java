package com.mi.liuruizhou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mi.liuruizhou.dao.GoodsDao;
import com.mi.liuruizhou.dao.po.Goods;
import com.mi.liuruizhou.dao.utils.JdbcUtil;
import com.mi.liuruizhou.dao.utils.Page;

public class GoodsDaoImpl implements GoodsDao {
	/**
	 * 根据类型id查商品信息
	 * @return List<Goods>商品信息集合
	 */
	@Override
	public List<Goods> getGoodsByTypeId(int typeId) {
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
	@Test
	public void demo() {
		for (Goods goods : getGoodsByTypeId(8)) {
			System.out.println(goods);
		}
	}
	@Override
	public int getTotalCount(String like) {
		int totalCount = 0;
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String countSql = "SELECT COUNT(1) as shuliang FROM goods WHERE  goods_name LIKE ?";
			ps=conn.prepareStatement(countSql);
			ps.setObject(1, "%"+like+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				totalCount = rs.getInt("shuliang");
				//totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return totalCount;
	}
	@Override
	public List<Goods> getOnePageInfo(int currentPage, int pageSize,String likesql,String orderBy) {
		List<Goods> goodsList = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String pageSql = "SELECT * FROM goods WHERE  goods_name LIKE ? ORDER BY ? LIMIT ?,? ";
			ps = conn.prepareStatement(pageSql);
			ps.setObject(1, "%"+likesql+"%");
			ps.setObject(2, orderBy);
			ps.setObject(3, (currentPage-1)*pageSize);
			ps.setObject(4, pageSize);
			rs = ps.executeQuery();
			goodsList = new ArrayList<Goods>();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoodsId(rs.getInt("goods_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setDescribe(rs.getString("describe"));
				goods.setGoodsPrice(rs.getString("goods_price"));
				goods.setPicPath(rs.getString("pic_path"));
				goods.setTypeId(rs.getInt("type_id"));
				goods.setUrl(rs.getString("url"));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goodsList;
	}
	@Override
	public Page<Goods> getPage(int currentPage, int pageSize,String likesql,String orderBy) {
		int count = this.getTotalCount(likesql);
		List<Goods> lists = this.getOnePageInfo(currentPage, pageSize,likesql,orderBy);
		Page<Goods> goodsPage=new Page<Goods>(currentPage, count, pageSize, lists);
		goodsPage.setLikesql(likesql);
		goodsPage.setOrderBy(orderBy);
		return goodsPage ;
	}
	@Override
	public List<String> getGoodsNameList(String term) {
		List<String> goodsNames = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String pageSql = "SELECT DISTINCT  goods_name FROM goods WHERE goods_name LIKE ? limit 10 ";
			ps = conn.prepareStatement(pageSql);
			ps.setObject(1, "%"+term+"%");
			rs = ps.executeQuery();
			goodsNames = new ArrayList<String>();
			while (rs.next()) {
				goodsNames.add(rs.getString("goods_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return goodsNames;
	}
}
