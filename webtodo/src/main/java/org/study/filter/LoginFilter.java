package org.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.study.model.User;

public class LoginFilter implements Filter{
	
	FilterConfig config;
	String[] excludedUrls;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		
		String path = req.getRequestURI();
		
		for (int i = 0; i < excludedUrls.length; i++) {
			if (path.equals(excludedUrls[i])) {
				arg2.doFilter(arg0, arg1);
				return;
			}
			
		}
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		if (req.getQueryString() != null) {
			path = path+ "?" + req.getQueryString();
		}
		
		if (user != null) {
			arg2.doFilter(arg0, arg1);
		} else {
			arg0.setAttribute("orgpath", path);
			arg0.setAttribute("error", "로그인해주세요.");
			arg0.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
		String params = config.getInitParameter("excluded");
		excludedUrls = params.split(",");
		String ctxpath = config.getServletContext().getContextPath();
		for (int i = 0; i < excludedUrls.length; i++) {
			excludedUrls[i] = ctxpath + excludedUrls[i].trim();
		}
	}

}
