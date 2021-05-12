<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${data.title}</title>
</head>
<body>
	<h1> 디테일 페이지 </h1>
	<div> 제목 : ${data.title}</div>
	<div> 등록일 : ${data.regdt}</div>
	<div> 글쓴이 : ${data.unm }</div>
	<div>
		${data.ctnt}
	</div>
	<!-- 글 해당 유저가 아니면 삭제/수정이 나타나지 않음 -->
	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="/board/del?iboard=${param.iboard}">삭제</a>
		<a href="/board/mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
</body>
</html> 