<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>

<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>

<div>
	<h1>일정</h1>
	<form action='${pageContext.request.contextPath }/login' method='post'>
		<input type="hidden" name="orgPath" value="${orgPath }" />
		<div style="color: red">${error}</div>
		ID: <input type='text' name='userid'><br /> 
		Password: <input type='password' name='pw'><br /> 
		<input type='submit' value='login' />
	</form>
</div>


