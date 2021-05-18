<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>${data.title}</title>
<style>
	.hidden { display: none; }
</style>
<script defer src="/res/js/boardDetail.js?ver=5"></script>
</head>
<body>
	<div> 제목 : ${data.title}</div>
	<div> 등록일 : ${data.regdt}</div>
	<div> 글쓴이 : ${data.unm }</div>
	<div>
		${data.ctnt}
	</div>

	<c:if test="${loginUser.iuser == data.iuser}">
	<div>
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	
	<h3>댓글</h3>
	<div>
		<form id="insFrm" action="cmt" method="post">
		<input type="hidden" name= "icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 작성">
			</div>
		</form>
		
		<!--  insFrm이 보일 때는 updFrm이 안 보이는 처리를 할 것 -->
		
		<form id="updFrm" action="cmt" method="post" class="hidden">
		<input type="hidden" name= "icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt" placeholder="댓글 내용"></textarea>
				<input type="submit" value="댓글 수정">
				<input type="button" value="수정 취소" onclick="showInsFrm();">
			</div>
		</form>
		
	</div>
	<div>
		<table>
			<tr>
				<th>내용</th>
				<th>작성자</th>
				<th>비고</th>
			</tr>
			<c:forEach items="${requestScope.cmtList}" var="item">
				<tr>
					<td>${item.cmt}</td>
					<td>${item.unm}</td>
					<td>${item.regdate}</td>
					<td>
					<c:if test="${item.iuser == sessionScope.loginUser.iuser}">
						<input type="button" value="수정" onclick="updCmt(${item.icmt}, '${item.cmt.trim()}');">
						<button onclick="delCmt(${requestScope.data.iboard}, ${item.icmt});">삭제</button>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html> 