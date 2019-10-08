package com.chenshengzao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chenshengzao.dao.po.Trading_State;
import com.chenshengzao.dao.utils.JdbcUtil;

public class TradingStateDaoImpl {
	public Trading_State getstateIdBydescription(int tradingId) {
		Trading_State ts=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConnection();
		String sql="select description from trading_state where trading_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,tradingId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				ts=new Trading_State();
				ts.setDescription(rs.getString(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally 
		{
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return ts;
	}
}
