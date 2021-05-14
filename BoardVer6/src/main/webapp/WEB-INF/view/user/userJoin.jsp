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
		<a href="userLogin"><button>로그인으로 돌아가기</button></a>
	</div>
	<div>
		<form action="userJoin" method="post">
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="text" name="upw" placeholder="비밀번호"></div>
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div>
				성별:
				<label>여성<input type="radio" name="gender" value="0"></label>
				<label>남성<input type="radio" name="gender" value="1"></label>
			</div>
			<div>
				<input type="submit" value="회원가입">
			</div>
		</form>
	</div>
</body>
</html>