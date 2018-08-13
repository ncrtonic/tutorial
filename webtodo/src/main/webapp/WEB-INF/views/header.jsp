<%@page import="org.study.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    

<nav>
<ul>
<li><a href="${pageContext.request.contextPath}/">home</a></li>
<% User user = (User)session.getAttribute("user");
	if (user != null){%>
	<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
	<li><a href="${pageContext.request.contextPath}/mytodo">내 일정</a></li>
	<li><a href="${pageContext.request.contextPath}/deluser">회원탈퇴</a></li>
	<%} else if ( user == null){%>
	<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
	<li><a href="${pageContext.request.contextPath}/join">회원등록</a></li>
	<%} %>
</ul>

</nav>
