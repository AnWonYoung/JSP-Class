<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>

<body>
	<div>
	<form action="/board/mod" method="post">
		<div>
			<input type="hidden" name="iboard" value="${data.iboard}">
		</div>
		<div>
			제목 : <input type="text" name= "title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea rows="20" cols="40" name="ctnt">${data.ctnt}</textarea>
		</div>
		
		<div>
			<input type="submit" value="등록하기">
			<input type="reset" value="초기화">
		</div>
	</form>
	</div>
</body>
</html>