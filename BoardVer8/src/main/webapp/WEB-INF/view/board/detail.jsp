<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>디테일</h1>
<!-- goBack()은 template.jsp에서 import함 -->
<div><a href="#" onclick="goBack();">돌아가기</a></div>
<div> 제목 : ${requestScope.data.title}</div>
	<div> 등록일 : ${requestScope.data.regdt}</div>
	<div> 글쓴이 : ${requestScope.data.writerNm}</div>
	<div>
		<c:out value="${requestScope.data.ctnt}"/>
	</div>

<!-- 댓글 기능 -->

<div>
	<form id="cmtFrm" data-iboard="${param.iboard}">
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</div>

<script src="/res/js/boarddetail.js"></script>