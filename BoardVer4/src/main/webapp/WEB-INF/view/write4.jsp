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
	<form action="/write4" method="post"> <!-- form은 보통 post방식 -->
	<div>
		제목 : <input type="text" name="title"> <!-- name이 중요하다는 거 기억하기 -->
	</div>
	<div> <!-- textarea는 사용률이 떨어짐(보통은 에디터 사용) -->
		내용 : <textarea rows="40" cols="100" name="ctnt"></textarea>
	</div>
	<div>
		<input type="submit" value="글 등록">
		<input type="reset" value="모두 삭제">
	</div>
	</form>
</body>
</html>