<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div><a href="/list4">리스트</a></div>
	<form action="/mod4" method="post">
	
	<input type="hidden" name="iboard" value="${param.iboard}">
	<div>제목 : <input type="text" name="title" name="${data.title}"></div>
	<div>내용 : <textarea rows="10" name="ctnt" cols="10">${data.ctnt}</textarea></div>
	
	<input type="hidden" name="no" value="${param.no}">
	<input type="submit" value="수정완료">
	<input type="reset" value="초기화">
	</form>
</body>
</html>