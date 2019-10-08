package com.huangrongkang.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	private static Connection conn=null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//得到connection的通用方法
	public static Connection getConn()
	{
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xiaomi?characterEncoding=utf-8", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs)
	{
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int executeUpdate(String sql,Object... object)
	{
		int rows=-1;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=JdbcUtil.getConn();
			pstmt=conn.prepareStatement(sql);
			if(object!=null)
			{
				for(int i=0;i<object.length;i++)
				{
					pstmt.setObject((i+1), object[i]);
				}
			}
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeAll(conn, pstmt, null);	
		}
		
		return rows;
	}
}
