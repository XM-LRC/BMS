package com.chinasofti.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;
import com.google.gson.Gson;

@WebServlet("/book/add")  // ע�����ڱ�ע��һ���̳���HttpServlet��
public class AddBookServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������ͱ�������
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		//�õ�Ҫ��������Ϣ���
		String addBookName = request.getParameter("addBookName"); 
		String addBookAuthor = request.getParameter("addBookAuthor"); 
		String addBookPublisher = request.getParameter("addBookPublisher"); 
		
		// ��������
		BookDao dao = new BookDao();
		Book book = new Book(1, addBookName, addBookAuthor, addBookPublisher);	
		// �����������
		int num = dao.addBook(book);   // ����0��ʾ����
		
		// ���ݷ�װ
		Map map = new HashMap();
		map.put("checkOK", num);
						
		//�����ݿ�õ������ݣ���װ��json��ʽ
		String json = new Gson().toJson(map);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();		
	}
}
