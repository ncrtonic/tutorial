package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.model.User;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		if (user != null) {
			session.invalidate();
			resp.sendRedirect(req.getContextPath()+"/");
		} else {
			req.setAttribute("error", "로그인 되어있지 않습니다");
			req.getRequestDispatcher(req.getContextPath()+"/login").forward(req, resp);
		}
	}
}
