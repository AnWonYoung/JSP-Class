<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<div><a href="/list">돌아가기</a></div>
	<form action="/write" method="post">
		<div>제목:<input type="text" name="title"></div>
		<div>내용<textarea name="ctnt" rows="10" cols="10"></textarea></div>
		<input type="submit" value="등록">
	</form>
</body>
</html>