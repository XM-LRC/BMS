package com.chinasofti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chinasofti.dao.BookDao;
import com.chinasofti.entity.Book;

import com.google.gson.Gson;
@WebServlet("/book/query")
public class QueryBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����������⣬��Ҫ�����Ӧͷ��������Ӧ���ĵ��ַ���
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		
		BookDao dao = new BookDao();
		
		//��ȡ��ҳ����Ϣ����ȡͼ������
		int pn = Integer.parseInt(request.getParameter("pn"));
		int rn = Integer.parseInt(request.getParameter("rn"));
		String checkName = request.getParameter("inputName");  // ��������صĲ���
	
		// ���з�ҳ��ȡ����
		List<Book> listByName = dao.getBookList(checkName,pn,rn);	
		int total = dao.count(checkName);    // ��������
		
		// ���ݷ�װ
		Map map = new HashMap();
		map.put("total",total);
		map.put("listByName", listByName);
			
		//�����ݿ�õ������ݣ���װ��json��ʽ
		String json = new Gson().toJson(map);	
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
