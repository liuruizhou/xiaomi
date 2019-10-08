package com.mi.liuruizhou.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//OpenSessionInView
	
	static{
		try {
			// 1.加载驱动\
			Class.forName("com.mysql.jdbc.Driver");
			// 2.得到数据库连接Connection接口指向的对象
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	// 得到connection的通用方法
	public static Connection getConnection() {
		 Connection conn = null;
		 try {
			conn = DriverManager.getConnection(
						"jdbc:mysql://127.0.0.1:3306/xiaomi", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//连接池的到Comm
	/*public static Connection getConnection(){
		 Connection conn = null;
	    //使用数据源连接池的方式连接数据库
	    try {
	    	//创建一个上下文环境
	    	Context con=new javax.naming.InitialContext();
	    	//通过con得到数据源
	    	DataSource ds=(DataSource) con.lookup("java:comp/env/xiaomi");  //这里的“xuliugen”即是你数据源的名字
	    	conn=ds.getConnection();
	    	//System.out.println ("使用连接池的方式");
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return conn;
	}*/
	
	
	/**
	 * 通用的增删改功能
	 * 举例：sql = "INSERT INTO  dept (deptno,dname,loc) VALUES(?,?,?)"
	 * Object[] objects = {dept.getDeptno(),dept.getDname(),dept.getLoc()};
	 * @param dept
	 * @return
	 */
	public static int excuteUpdate(String sql,Object... objects) {
		int rows = - 1;
		Connection conn = null;
		/*
		 * 1.性能高
		 * 2.可读性高，好维护
		 * 3.解决sql注入漏洞
		 */
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			
			ps = conn.prepareStatement(sql);
			if (objects != null) {
				for (int i = 0; i < objects.length; i++) {
					ps.setObject((i+1), objects[i]);
				}
			}
			rows = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(null, ps, conn);
		}
		return rows;
	}
	public static void closeAll(ResultSet rs, Statement state, Connection conn) {
		// 5.关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
