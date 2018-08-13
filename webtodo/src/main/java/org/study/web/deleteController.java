package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.study.dao.UserDao;
import org.study.model.User;


@WebServlet("/deluser")
public class deleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			req.setAttribute("error", "로그인 해주세요");
			req.getRequestDispatcher(req.getContextPath()+"/").forward(req, resp);
		}else {
		req.getRequestDispatcher("/WEB-INF/views/deluser.jsp").forward(req, resp);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		HttpSession session = req.getSession();
//		User user = (User)session.getAttribute("user");
//		String id = user.getUserid();
//		String pw = req.getParameter("pw");
//		UserDao dao = new UserDao();
//		
//		if(dao.delUser(id, pw)) {
//			req.setAttribute("error", "ȸ��Ż�� ����");
//			req.getRequestDispatcher(req.getContextPath()+"/").forward(req, resp);
//		} else {
//			req.setAttribute("error", "ȸ��Ż�� ����");
//			req.getRequestDispatcher("WEB-INF/views/deluser.jsp").forward(req, resp);
//		}
//		
//	}
}
