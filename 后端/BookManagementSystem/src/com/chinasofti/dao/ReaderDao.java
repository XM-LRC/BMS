package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.chinasofti.entity.Reader;

public class ReaderDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// ����������ѯ����
	public List<Reader> getReaderList(String readerName){
		String sql = "select * from reader_tb where reader_name like ? ";
		List<Reader> list = new ArrayList<Reader>();
		
		try {
			//ͨ��������õ����Ӷ���
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			if(readerName==null){
				readerName = "%";
			}
			else{
				readerName = "%"+readerName+"%";
			}
			//��sql�еģ�ռλ��ָ�����ݣ�ע����������
		
			stmt.setString(1, readerName);
			rs = stmt.executeQuery();
			while(rs.next()){
				int readerID = rs.getInt("reader_id");
				readerName = rs.getString("reader_name");
				String readerSex = rs.getString("reader_sex");
				int readerAge = rs.getInt("reader_age");
				Reader reader = new Reader(readerID,readerName, readerSex,readerAge);			
				list.add(reader);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
	
	// ���ͼ��
	public int addReader(Reader reader){
		String readerName = reader.getReaderName();
		String readerSex = reader.getReaderSex();
		int readerAge = reader.getReaderAge();

		String sql = "INSERT INTO reader_tb (reader_name, reader_age,reader_sex) "	
				   + "values('"+readerName+"'"
				   + ",'"+readerAge+"'"
				   + ",'"+readerSex+"' )";
		
		try {
			//ͨ��������õ����Ӷ���
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			
			//��sql�еģ�ռλ��ָ�����ݣ�ע����������
			int res= stmt.executeUpdate();
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
	// ��������ɾ������
	public int deleteReader(String readerName){	
		List<Reader> list = this.getReaderList(readerName);
		if(null == list || list.size() ==0){
			return 0;
		}
		else{
		
			try {
				// �޸�����������������1
				String sql = "DELETE FROM  reader_tb "
						   + "WHERE reader_name = '"+readerName+"'";
				//ͨ��������õ����Ӷ���
				conn = BaseDao.getConn();
				stmt = conn.prepareStatement(sql);
				int res= stmt.executeUpdate();
				return res;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			} finally{
				BaseDao.closeAll(conn, stmt, rs);
			}
		}
	}
	
	// �޸�ͼ��
	public int modifyReader(Reader book,String oldreaderName){
		String readerName = book.getReaderName();
		String readerSex = book.getReaderSex();
		int readerAge = book.getReaderAge();
		
		
		String sql = "UPDATE reader_tb "
				   + "SET reader_name = '" + readerName+"',"
				   + "reader_age ='" + readerAge+"',"
				   + "reader_sex = '" + readerSex+"'"
				   + " WHERE reader_name = '"+oldreaderName+"'";
		
		try {
			//ͨ��������õ����Ӷ���
			conn = BaseDao.getConn();
			stmt =conn.prepareStatement(sql);
			int res= stmt.executeUpdate();
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally{
			BaseDao.closeAll(conn, stmt, rs);
		}	
	}
}
