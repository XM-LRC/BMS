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

@WebServlet("/book/mod")
public class ModifyBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// �������ͱ�������
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		// �õ�Ҫɾ������Ϣ���
		int mid = Integer.parseInt(request.getParameter("mod_id"));
		String modBookName = request.getParameter("mod_name"); 
		String modBookAuthor = request.getParameter("mod_author"); 
		String modBookPublisher = request.getParameter("mod_publisher"); 
		
		// �����޸�
		Book book = new Book(mid, modBookName,modBookAuthor, modBookPublisher);
		BookDao dao = new BookDao();
	
		// �����޸Ľ��
		int res = dao.modifyBook(book,mid);	
		
		// ���ݷ�װ�����ؽ��
		Map map = new HashMap();
		map.put("checkOK", res);
		
		//�����ݿ�õ������ݣ���װ��json��ʽ
		String json = new Gson().toJson(map);
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
		
	}
}
