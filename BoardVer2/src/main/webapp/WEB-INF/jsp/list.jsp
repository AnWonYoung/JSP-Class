<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="com.an.wonyoung.*" %>

<% List<BoardField> list = (List<BoardField>)request.getAttribute("data"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>

<style>
	table, th, td {
		boarder: 3px solid pink;
		boarder-collapse : collapse;
	}
	a {
		text-decoration: none;
		text-color: pink;
	}
</style>

</head>
<body>
	<h1> 글 목록 </h1>
	<div>
		<a href="/write"><button>글 등록하기</button></a>
	</div>
	<div>
	<table>
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
		</tr>
		<% for(int i=0; i<list.size(); i++) { %>
		<%		BoardField b = list.get(i); %> 
		<tr>
			<td><%=i %></td>
			<td><a href="/detail?no=<%=i%>"><%=b.getTitle() %></td>
		</tr>
		<% } %>
	</table>
	</div>
</body>
</html>