<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/mypage.css">
<div>
	<c:choose>
		<c:when test="${empty sessionSope.loginUser.profileImg}">
			<c:set var="img" value="/res/img/noprofile.jpg"/>
		</c:when>
		<c:otherwise>
			<c:set var="img" value="${sessionSope.loginUser.profileImg}"/>
		</c:otherwise>
	</c:choose>
	<div>
		<form action="mypage" method="post" enctype="">
			이미지변경 : <input type="file" name="profileImg">
			<input type="submit" value="이미지 업로드">
		</form>
	</div>
</div>

<div>
	<div><img src="${img}"></div>
	<div>PK : ${sessionSope.loginUser.iuser}</div>
	<div>ID : ${sessionSope.loginUser.uid}</div>
	<div>Name : ${sessionSope.loginUser.unm}</div>
</div>