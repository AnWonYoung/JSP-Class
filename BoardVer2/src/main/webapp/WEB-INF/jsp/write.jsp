<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 글 쓰기 </h2>
	<form action="/write" method="post">
	<div>
		제목 : <input type="text" name="title">
	</div>
	<div>
		내용 : <textarea rows="40" cols="100" name="ctnt"></textarea>
	</div>
	<div>
		<input type="submit" value="글 등록">
		<input type="reset" value="모두 삭제">
	</div>
	</form>
</body>
</html>