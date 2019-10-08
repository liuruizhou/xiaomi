package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.huangrongkang.dao.IColorDao;
import com.huangrongkang.dao.po.Color;
import com.huangrongkang.dao.util.JdbcUtil;


public class ColorDaoImpl implements IColorDao {

	@Override
	public int save(Color color) {
		String sql="insert into color values(?,?)";
		Object object[]= {color.getColorId(),color.getColorName()};
		return JdbcUtil.executeUpdate(sql, object);
	}

	@Override
	public int delete(int id) {
		String sql="delete from color where color_id=?";
		Object object[]= {id};
		return JdbcUtil.executeUpdate(sql, object);
	}

	@Override
	public int update(Color color) {
		String sql="update color set color_name=? where color_id=?";
		Object object[]= {color.getColorName(),color.getColorId()};
		return JdbcUtil.executeUpdate(sql, object);
	}


	@Override
	public List<Color> listAll(Integer id) {
		List<Color> list=new ArrayList<Color>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConn();
		String sql="select * from color where color_id in (select color_id from goods_color where goods_id=?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Color color = new Color();
				color.setColorId(rs.getInt("color_id"));
				color.setColorName(rs.getString("color_name"));
				list.add(color);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Color getById(int id) {
		Color color=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConn();
		String sql="select * from color where color_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				color = new Color();
				color.setColorId(rs.getInt("color_id"));
				color.setColorName(rs.getString("color_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return color;
	}


}
