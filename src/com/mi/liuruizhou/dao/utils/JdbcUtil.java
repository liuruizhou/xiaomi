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
			// 1.��������\
			Class.forName("com.mysql.jdbc.Driver");
			// 2.�õ����ݿ�����Connection�ӿ�ָ��Ķ���
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	// �õ�connection��ͨ�÷���
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
	//���ӳصĵ�Comm
	/*public static Connection getConnection(){
		 Connection conn = null;
	    //ʹ������Դ���ӳصķ�ʽ�������ݿ�
	    try {
	    	//����һ�������Ļ���
	    	Context con=new javax.naming.InitialContext();
	    	//ͨ��con�õ�����Դ
	    	DataSource ds=(DataSource) con.lookup("java:comp/env/xiaomi");  //����ġ�xuliugen������������Դ������
	    	conn=ds.getConnection();
	    	//System.out.println ("ʹ�����ӳصķ�ʽ");
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return conn;
	}*/
	
	
	/**
	 * ͨ�õ���ɾ�Ĺ���
	 * ������sql = "INSERT INTO  dept (deptno,dname,loc) VALUES(?,?,?)"
	 * Object[] objects = {dept.getDeptno(),dept.getDname(),dept.getLoc()};
	 * @param dept
	 * @return
	 */
	public static int excuteUpdate(String sql,Object... objects) {
		int rows = - 1;
		Connection conn = null;
		/*
		 * 1.���ܸ�
		 * 2.�ɶ��Ըߣ���ά��
		 * 3.���sqlע��©��
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
		// 5.�ر���Դ
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
