<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<style>
body {
    background-color: rgb(241, 220, 255);
    text-align: center;
    }
	table {
	width: 70%;
	margin-right:auto;
	margin-left:auto;
		}
table, td, th {
    border: 2px solid rgb(252, 47, 173);
    border-collapse: collapse;
}
</style>
<body>
	<div> 로그인 성공 </div>
	<div>${loginUser.unm}님 (${loginUser.uid})환영합니다. 
	<a href="/user/logout">logout</a>
	</div>
	
	<div>
		<a href="write">>글쓰기</a>
	</div>
	<div>
		리스트
	</div>
	<div>
		<table>
			<tr>
				<td> 글 번호 </td>
				<td> 글 제목 </td>
				<td> 등록시간 </td>
				<td> 작성자 </td>
			</tr>
			<c:forEach items = "${list}" var = "i">
			 <tr>
				<td> ${i.iboard} </td>
				<td> ${i.title} </td>
				<td> ${i.regdt} </td>
				<td> ${i.unm} </td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>