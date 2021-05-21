<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- body 안쪽만 필요함 -->
<body>
	<div class="errMsg">${errMsg}</div>
	
	<div>
		<form id="frm">
			<div><input type="text" name="uid" placeholder="id"></div>
			<div><input type="password" name="upw" placeholder="password"></div>
		</form>
	</div>
	
	<div>
		<a href="join"><button>회원가입</button></a>
	</div>
</body>
</html>