<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="/write" method= "post"> <!-- action은 갈 곳, method는 getter -->
										  <!-- get / post 방식 둘 중 선택 -->
		<div>
			제목: <input type="text" name="title">
		</div>
		<div>
			내용: <textarea name="ctnt" rows="10" cols="10"></textarea>
		</div>
		<div>
			<input type="submit" value="글쓰기"> <!-- 눌렀을 때 get방식으로 wrtie에 감 -->
			<input type="reset" value="초기화"> <!-- 글쓰고 눌렀을 때 초기화 -->
		</div>
		
	</form>
</body>
</html>