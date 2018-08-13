<%@page import="java.sql.Date"%>
<%@page import="org.study.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 일정</title>
<style type="text/css" >
table, th, td{
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
	<a href="${pageContext.request.contextPath}/addtodo">일정 등록</a>
	<br><br><br>
	<table>
	 <tr>
	 <th>번호</th>
	 <th>시작일</th>
	 <th>마감일</th>
	 <th>내용</th>
	 </tr>
<%Todo[] todo = (Todo[])session.getAttribute("Todos"); 
	if (todo != null){
	for(int i = 0; i<todo.length; i++){
		Todo td = todo[i];
	 String idx = td.getIdx();
	 String id  = td.getUserid();
	 Date sdate = td.getS_date();
	 Date edate = td.getE_date();
	 String memo  =	td.getMemo(); %>
	 <tr>
	 <td><%=idx%></td>
	 <td><%=sdate%></td>
	 <td><%=edate%></td>
	 <td><%=memo%></td>
	 <td><a href="${pageContext.request.contextPath}/update?idx=<%=idx%>">수정</a></td>
	 </tr>
	 <%}%>
	 <%}else{%>
	 일정이 없어요~
	 <%}%>
<div style="color: red">${updatetodo}</div>
	 </table>
</body>
</html>