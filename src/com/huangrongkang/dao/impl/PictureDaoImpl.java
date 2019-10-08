package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.huangrongkang.dao.IPictureDao;
import com.huangrongkang.dao.po.Picture;
import com.huangrongkang.dao.util.JdbcUtil;

public class PictureDaoImpl implements IPictureDao {

	@Override
	public List<Picture> getGoodsIdByUrl(int goodsId) {
		List<Picture> picture=new ArrayList<Picture>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConn();
		String sql="select * from picture where goods_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goodsId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Picture pic=new Picture();
				pic.setPictureId(rs.getInt(1));
				pic.setUrl(rs.getString(2));
				pic.setUploadtime(rs.getDate(3));
				pic.setGoodsId(rs.getInt(4));
				pic.setNo(rs.getInt(5));
				picture.add(pic);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		return picture;
	}

}
