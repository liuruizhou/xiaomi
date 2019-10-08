package com.chenshengzao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chenshengzao.dao.IOrdersDao;
import com.chenshengzao.dao.po.Orders;
import com.chenshengzao.dao.utils.JdbcUtil;


public class OrdersDaoImpl  implements IOrdersDao
{
	@Override
	public List<Orders> getOrdersByuserId(int userId) {
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=JdbcUtil.getConnection();
		String sql="select * from orders where user_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Orders order=new Orders();
				order.setId(rs.getInt(1));
				order.setGoodsId(rs.getInt(2));
				order.setOrderNumber(rs.getString(3));
				order.setPrice(rs.getString(4));
				order.setTradingHour(rs.getString(5));
				order.setStateId(rs.getInt(6));
				order.setUserId(rs.getInt(7));
				list.add(order);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			JdbcUtil.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
	
}	
