import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.BookDao;
import com.chinasofti.dao.BorrowDao;
import com.chinasofti.dao.ReaderDao;
import com.chinasofti.entity.Book;
import com.chinasofti.entity.Reader;

public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����鼮�Ĳ���
//		Book book = new Book(1, "xx2", "xyy2", "aqq");
//		BookDao dao = new BookDao();
//		int res = dao.addBook(book);
//		System.out.println(res);
		
		// ɾ���鼮�Ĳ���
//		String bookName = "aa";
//		BookDao dao = new BookDao();
//		int res = dao.deleteBook(bookName);
//		System.out.println(res);
		
//		// �޸�ͼ��
//		Book book = new Book(1, "xx999", "newfff", "newssss");
//		BookDao dao = new BookDao();
//		int res = dao.modifyBook(book,"99");
//		System.out.println(res);
		
		
//		ReaderDao dao = new ReaderDao();
		// ��ѯ����


//		List<Reader> list = new ArrayList<Reader>();
//		list = dao.getReaderList("b");
//		for (Reader str : list) {
//	            System.out.println(str.getReaderName());
//	        }
		
		
		
		// ��Ӷ���
//		Reader reader = new Reader(1, "bmm","xyy2",45);
//		dao.addReader(reader);
		
		
		// ɾ������
//		String readerName = "bcd";
//		int res = dao.deleteReader(readerName);
//		System.out.println(res);
		
		
		// �޸Ķ���
//		Reader reader = new Reader(1, "adad","xyshhsfsfay2",45);
//		int res = dao.modifyReader(reader, "bmm");
//		System.out.println(res);
		
		
//		BorrowDao dao = new BorrowDao();		
    	// ���Ĺ黹ͼ�����
		// �ѽ���ͼ���ѯ
//		List<Book> list = new ArrayList<Book>();
//		list = dao.getBorrowList(1);
//		for (Book str : list) {
//	            System.out.println(str.getBookName());
//	        }
		
		// ����ͼ��
//		int res = dao.borrowBook(1, 6);
//		System.out.println(res);
		
		// �黹ͼ��
//		int res = dao.returnBook(1, 6);
//		System.out.println(res);
		
		BookDao dao = new BookDao();
		int num = dao.deleteBook(5);
		System.out.println(num);
		
	  }
}
