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

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		
		if (idx != null) {
			TodoDao dao = new TodoDao();
			Todo todo = dao.findTodo(idx);
			if(todo != null) {
				req.setAttribute("todo", todo);
			} else {
				req.setAttribute("todo", null);
			}
			
		}
		
		req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		Todo todo = new Todo();
		todo.setIdx(req.getParameter("idx"));
		todo.setS_date(Date.valueOf(req.getParameter("s_date")));
		todo.setE_date(Date.valueOf(req.getParameter("e_date")));
		todo.setMemo(req.getParameter("memo"));
		

			if(dao.updateTodo(todo)) {
				req.setAttribute("updatetodo", "수정 완료(내일정다시확인필요(기능미완성)).");
				req.getRequestDispatcher("/WEB-INF/views/mytodo.jsp").forward(req, resp);
			}else {
				req.setAttribute("updatetodo", "수정 실패.");
				req.getRequestDispatcher("/WEB-INF/views/mytodo.jsp").forward(req, resp);
			}
		}
}
