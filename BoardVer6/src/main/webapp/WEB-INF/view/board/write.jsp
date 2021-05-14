<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div>
	
	<form action="/board/write" method="post">
		<div>
			제목 : <input type="text" name= "title" placeholder="제목">
		</div>
		<div>
			내용 : <textarea rows="20" cols="40" name="ctnt" placeholder="글쓰기"></textarea>
		</div>
		
		<div>
			<input type="submit" value="등록하기">
			<input type="reset" value="초기화">
		</div>
	</form>
	</div>
</body>
</html>