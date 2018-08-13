package org.study.web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.TodoDao;
import org.study.model.Todo;
import org.study.model.User;

@WebServlet("/addtodo")
public class AddtodoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/addtodo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		Date s_date = java.sql.Date.valueOf(req.getParameter("s_date"));
		Date e_date = java.sql.Date.valueOf(req.getParameter("e_date"));
		String memo = req.getParameter("memo");
		
		Todo todo = new Todo();
		
		todo.setUserid(user.getUserid());
		todo.setS_date(s_date);
		todo.setE_date(e_date);
		todo.setMemo(memo);
		
		TodoDao dao = new TodoDao();
		if (dao.addTodo(todo)) {
			req.setAttribute("addtodo", "등록완료~");
			req.getRequestDispatcher("/WEB-INF/views/addtodo.jsp").forward(req, resp);
		} else {
			req.setAttribute("addtodo", "등록실패");
			req.getRequestDispatcher("/WEB-INF/views/addtodo.jsp").forward(req, resp);
		}
		
	}
	
	
}
