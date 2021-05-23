package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author ���F�
 * @version 1.0
 * ���ݿ����ӵĻ�������
 */
public class BaseDao {
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbs?characterEncoding=utf8";
	private static final String NAME = "root";
	private static final String PWD = "12345678";
	// ��������	
	public static Connection getConn(){
		// 1.ע������			
		try {
			Class.forName(DRIVE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.�������ݿ�����		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, NAME, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// �ر�����
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
} 


