<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>

<div>
	<h1>일정</h1>
	<form action='${pageContext.request.contextPath }/deluser' method='post'>
		<div style="color: red">${error}</div>
		Password: <input type='password' name='pw'><br /> 
		<input type='submit' value='회원탈퇴' />
	</form>
</div>


