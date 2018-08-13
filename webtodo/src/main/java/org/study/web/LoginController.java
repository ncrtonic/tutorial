package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.UserDao;
import org.study.model.User;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String pw = req.getParameter("pw");
		String path = req.getParameter("orgpath");
		
		
		System.out.println(" id: "+userid+" pw: "+pw);
		System.out.println("orgPath: " + path);

		UserDao dao = new UserDao();
		User user = dao.confirmUser(userid, pw);

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			if (path == null) {
				resp.sendRedirect(req.getContextPath() + "/");
			} else {
				resp.sendRedirect(path);
			}	

		} else {
			req.setAttribute("error", "정보가 맞지않습니다.");
			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
	}
}
