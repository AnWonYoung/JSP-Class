<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
	pageContext.setAttribute("n", "A");
	request.setAttribute("n", "B");
	session.setAttribute("n", "C");
	application.setAttribute("n", "D");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>제목 : ${vo.title }</div>
	<div>${vo.ctnt}</div>
	<form action="/del" method="post">
		<input type="hidden" name="no" value="${param.no}">
		<input type="submit" value="삭제">
	</form>
	<a href="/mod?no=${param.no }"><input type="button" value="수정"></a>
</body>
</html>