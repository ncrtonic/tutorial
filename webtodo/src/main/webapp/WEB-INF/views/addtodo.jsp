<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
<form action="${pageContext.request.contextPath}/addtodo" method="post">
시작일: <input type="date" name="s_date"><br>
마감일: <input type="date" name="e_date"><br>
설   명: <input type="text" name="memo"><br>
<input type="submit" value="입력">
<div style="color: red">${addtodo}</div>

</form>

</body>
</html>