<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/mod" method="post">
		<div><input type="text" name="title" value="${data.title}"></div>
		<div><textarea rows="10" name="ctnt" cols="10">${data.ctnt }</textarea></div>
		<input type="hidden" name="no" value="${param.no}">
		<input type="submit" value="수정완료">
		<input type="reset" value="초기화">
	</form>
</body>
</html>