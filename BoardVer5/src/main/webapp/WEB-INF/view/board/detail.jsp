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
		<a href="del?iboard=${param.iboard}">삭제</a>
		<a href="mod?iboard=${param.iboard}">수정</a>
	</div>
	</c:if>
	
	<!--                            아래부터는 댓글 기능                                   -->
	
	<div>
		<form id="insFrm" action="cmt" method="post">
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
			<div>
				<textarea name="cmt"></textarea>
				<input type="submit" value="댓글 작성">
			</div>
		</form>
		<!--  위는 등록하는 form태그, 아래는 수정하는 form태그 -->
		<form id="updFrm" action="cmt" method="post">
		<input type="hidden" name="icmt" value="0">
		<input type="hidden" name="iboard" value="${data.iboard}">
		
			<div>
				<textarea name="cmt"></textarea>
				<input type="submit" value="댓글 수정">
				<input type="button" value="수정 취소" onclick="showInsFrm()">
			</div>
		
		</form>
		
	</div>
	
	
	<div>
		<table>
				<tr>
					<th>댓글 내용</th>
					<th>댓글 작성자</th>
					<th> 비고 </th>
				</tr>
			<c:forEach items="${requestScope.Cmtlist}" var="i">
				<tr>
					<td>${i.cmt}</td>
					<td>${i.unm}</td>
					<td>${i.regdate}</td>
					<td>
						<c:if test="${i.user == sessionScope.loginUser.iuser}">
						<input type="button" value="수정하기" onclick="updCmt(${item.icmt}, '${item.cmt.trim()}')">
						<input type="button" value="삭제하기" onclick="delCmt(${data.iboard}, ${item.icmt})">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html> 