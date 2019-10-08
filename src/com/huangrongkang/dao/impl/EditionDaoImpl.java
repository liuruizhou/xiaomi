package com.huangrongkang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.huangrongkang.dao.IEditionDao;
import com.huangrongkang.dao.po.Edition;
import com.huangrongkang.dao.util.JdbcUtil;


public class EditionDaoImpl  implements IEditionDao{

	@Override
	public List<Edition> listAll(Integer id) {
		List<Edition> list=new ArrayList<Edition>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection conn=JdbcUtil.getConn();
		String sql="select * from edition where edition_id in (select edition_id from goods_edition where goods_id=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Edition edition = new Edition();
				edition.setEditionId(rs.getInt("edition_id"));
				edition.setEditionName(rs.getString("edition_name"));
				list.add(edition);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, rs);
		}
		return list;
	}

}
