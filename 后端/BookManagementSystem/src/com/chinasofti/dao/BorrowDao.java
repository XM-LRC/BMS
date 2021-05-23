package com.chinasofti.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.chinasofti.entity.Book;

public class BorrowDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// ����������ѯ����
	public List<Book> getBorrowList(int readerID){
		String sql = "select * from borrow_tb , book_tb where borrow_tb.book_id = book_tb.book_id and reader_id =  ? ";
		List<Book> list = new ArrayList<Book>();
		
		try {
			//ͨ��������õ����Ӷ���
			conn = BaseDao.getConn();
			stmt = conn.prepareStatement(sql);
			
			//��sql�еģ�ռλ��ָ�����ݣ�ע����������
		
			stmt.setInt(1, readerID);
			rs = stmt.executeQuery();
			rs = stmt.executeQuery();
			while(rs.next()){
				int bookID = rs.getInt("book_id");
				String bookName = rs.getString("book_name");
				String bookPublisher = rs.getString("book_publisher");
				String bookAuthor = rs.getString("book_Author");
				Book book = new Book(bookID, bookName, bookAuthor, bookPublisher);			
				list.add(book);
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
	
	// ����ͼ�飺���ݶ���ID���鼮��ID����
	public int borrowBook(int readerID,int bookID){
	
		String sql = "INSERT INTO borrow_tb (reader_id, book_id) "	
				   + "values('"+readerID+"'"
				   + ",'"+bookID+"' )";
		
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
	
	// �黹ͼ��
	public int returnBook(int readerID,int bookID){	
			try {
				// �޸�����������������1
				String sql = "DELETE FROM  borrow_tb "
						   + "WHERE reader_id = '"+readerID+"' and book_id = '"+bookID+"'";
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
