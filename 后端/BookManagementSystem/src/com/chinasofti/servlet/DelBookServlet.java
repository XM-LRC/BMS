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
import com.google.gson.Gson;

@WebServlet("/books/del")
public class DelBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �������ͱ�������
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		// �õ�Ҫɾ������Ϣ���
		int mid = Integer.parseInt(request.getParameter("mid"));
		
		// ɾ������
		BookDao dao = new BookDao();
				
		// ɾ����������ж�
		int num = dao.deleteBook(mid);
		
		// ���ݷ�װ��������
		Map map = new HashMap();
		map.put("checkOK", num);
		
		//�����ݿ�õ������ݣ���װ��json��ʽ
		 String json = new Gson().toJson(map);
		 PrintWriter out = response.getWriter();
		 out.println(json);
		 out.close();
	}
}
