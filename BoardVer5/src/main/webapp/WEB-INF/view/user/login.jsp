<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<style>
	body {
	  margin: auto;
	  width: 35%;
	  padding: 10px;
	  background-color: rgb(241, 220, 255);
	  
	}
</style>
<body>
	<div>
		<div class="errMsg">${errMsg}</div>
		<div>
			<form action="login" method="post">
			<!-- placeholder = 아이디, 비밀번호가 입력되어 있게 하고 클릭 시 사라짐 -->
				<div><input type="text" name="uid" placeholder="아이디"></div>
				<div><input type="password" name="upw" placeholder="비밀번호"></div>
				<div>
					<input type="submit" value="login">
				</div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a>
		</div>
	</div>
</body>
</html>