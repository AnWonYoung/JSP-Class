<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/write">글쓰기</a>
	<div>글 리스트가 보일 부분</div>
	
	<c:forEach var="i" begin="1" end="5" step="1">
		<div>${i}</div>
	</c:forEach>
	<table>
		<tr><th>no</th><th>제목</th></tr>
		<c:forEach var="item" items="${list}" varStatus="status">
			<tr>
				<td>${status.count }</td> <!-- count는 1부터 -->
				<td><a href="/detail?no=${status.count}">${item.title }</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>