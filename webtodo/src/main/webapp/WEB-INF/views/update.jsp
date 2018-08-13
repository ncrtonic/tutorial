<%@page import="org.study.model.Todo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
<%Todo todo = (Todo)request.getAttribute("todo"); %>

<form action="${pageContext.request.contextPath}/update" method="post">
시작일: <input type="date" name="s_date" value="<%=todo.getS_date()%>"><br>
마감일: <input type="date" name="e_date"value="<%=todo.getE_date()%>"><br>
설   명: <input type="text" name="memo" value="<%=todo.getMemo()%>"><br>
<input type="hidden" name="idx" value="<%=todo.getIdx()%>"><br>
<input type="submit" value="입력">
</form>
</body>
</html>