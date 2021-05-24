<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>리스트</h1>
<table>
	<tr>
		<th>글 번호</th>
		<th>글 제목</th>
		<th>글쓴이</th>
		<th>작성일</th>
	</tr>
<c:forEach items="${requestScope.list}" var="item">
	<tr>
		<td>${item.iboard}</td>
		<td>${item.title}</td>
		<td>${item.writerNm}</td>
		<td>${item.regdt}</td>
	</tr>
</c:forEach>
</table>
