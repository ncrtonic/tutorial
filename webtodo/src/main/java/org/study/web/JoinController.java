package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.study.dao.UserDao;
import org.study.model.User;


@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		String id = req.getParameter("userid");
		int pass = Integer.parseInt(req.getParameter("pass"));
		
		
		if (pass == 1) {
			boolean chk = dao.idCheck(id);
			if(chk == true) {
				resp.getWriter().print(1);
			}else if (chk == false){
				resp.getWriter().println(-1);
			}
			
			
		} else {
		String userid = req.getParameter("userid");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setUserid(userid);
		user.setPw(pw);
		user.setName(name);
		user.setEmail(email);
		
		
		if (dao.addUser(user)) { // 레지스터 스크립트와 함께 수정요망
			req.setAttribute("error", "가입완료. 로그인 해주세요");
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}else {
			req.setAttribute("error", "가입실패");
			req.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(req, resp);
		}
		}
	}
}
