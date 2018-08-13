package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.TodoDao;
import org.study.model.User;

@WebServlet("/mytodo")
public class MytodoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		TodoDao dao = new TodoDao();
		session.setAttribute("Todos", dao.myTodo(user.getUserid()));
		req.getRequestDispatcher("/WEB-INF/views/mytodo.jsp").forward(req, resp);
	}
}
