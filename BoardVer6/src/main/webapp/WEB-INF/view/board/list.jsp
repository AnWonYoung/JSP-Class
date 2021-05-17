<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>

<script defer src="/res/js/boardList.js"></script>
<link href="/res/css/boardList.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1>${loginUser.unm} 반갑습니당</h1>
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
			<c:forEach items = "${requestScope.list}" var = "i">
			 <tr class="record" onclick="moveToDetail(${i.iboard})">
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