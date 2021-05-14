<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<div class="errMsg">${errMsg}</div>
	
	<div>
		<form action="userLogin" method="post">
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="password" name="upw" placeholder="비밀번호"></div>
			<div><input type="submit" value="login"></div>
		</form>
	</div>
	
		<div>
			<a href="join"><button>회원가입</button></a>
		</div>
</body>
</html>