package com.chenshengzao.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtil {
	static {
		//1.加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//2.得到connection的通用方法
	public static Connection getConnection()
	{
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/xiaomi?characterEncoding=utf-8","root","123456"
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int excuteUpdate(String sql,Object... objects)
	{
		int rows=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
		conn=JdbcUtil.getConnection();
			ps=conn.prepareStatement(sql);
			if(objects !=null)
			{
				for(int i=0;i>objects.length;i++)
				{
					ps.setObject((i+1), objects[i]);
				}
			}
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			JdbcUtil.closeAll(null, ps, conn);
		}
		return rows;
	}
	public static void closeAll(ResultSet rs, Statement state, Connection conn)
	{
		//关闭资源
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(state!=null)
		{
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
