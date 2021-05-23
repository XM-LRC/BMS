package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.entity.User;
/**
 * 
 * @author ���F�
 * @version 1.0
 * ����¼�����ݿ������װ�ڴ�����
 */
public class UserDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// �����û�ID��ȡ�û���Ϣ
	public User getUserById(String uid){
		String sql = "select * from user_tb where uid = ?";
		User user = null;
		try {
			//ͨ��������õ����Ӷ���
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			String pwd = null;
			String role= null;
			String userName = null;
			//��sql�еģ�ռλ��ָ�����ݣ�ע����������
			stmt.setString(1, uid);
			rs = stmt.executeQuery();
			while(rs.next()){					
				pwd = rs.getString("pwd");
				role = rs.getString("role");
				user = new User(uid,userName, pwd,role);  // ���ض���
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}	
}
