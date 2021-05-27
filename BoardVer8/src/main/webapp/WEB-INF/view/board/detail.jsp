<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/res/css/boardDetail.css">

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

<!-- 여기서 form태그는 날리는 목적 X 접근성의 목적O -->
<!-- data-''  =  js에서 dataset 뒤의 값으로 사용-->
<c:if test="${not empty sessionScope.loginUser}">
<div>
	<form id="cmtFrm" onsubmit="return false;">
		<input type="text" id="cmt">
		<input type="button" value="댓글달기" onclick="regCmt();">
	</form>
</div>
</c:if>

<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>

<!-- 수정 설정 -->


<div id="modal" class="displayNone">
	<div class="modal_content">
		<form id="cmtModFrm" action="#">
			<input type="hidden" id="icmt">
			<input type="text" id="cmt">
		</form>
		<input type="button" value="댓글 수정" onclick="modAjax();">
		<input type="button" value="취소" onclick="closeModModal();">
	</div>
</div>


<script src="/res/js/boarddetail.js"></script>