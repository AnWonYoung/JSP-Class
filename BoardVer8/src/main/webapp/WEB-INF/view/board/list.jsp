<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/res/css/boardList.css">
<h1>리스트</h1>
<table>
	<tr>
		<th>글 번호</th>
		<th>글 제목</th>
		<th>글쓴이</th>
		<th>작성일</th>
	</tr>
<c:forEach items="${requestScope.list}" var="item">
	<tr class="record" onclick="moveToDetail(${item.iboard});">
		<td>${item.iboard}</td>
		
		<td><!--  검색했을 때 해당 글자만 마크 -->
			<c:choose>
				<c:when test="${param.searchType eq 4 }">
					${item.title.replace(param.searchText, '<mark>' += param.searchText += '</mark>')}				
				</c:when>
				<c:otherwise>
				    ${item.writerNm}				    
				</c:otherwise>			
			</c:choose>
			<img src="${img}" class="profileImg">       v
		</td>
		<td>${item.regdt}</td>
	</tr>
	
	<c:choose>
		<c:when test="${empty item.profileImg}">
			<c:set var="img" value="/res/img/noprofile.jpg"/>
		</c:when>
		<c:otherwise>
			<c:set var="img" value="/res/img/user/${items.iuser}/${item.profileImg}"/>
		</c:otherwise>
	</c:choose>
	
</c:forEach>
</table>


								<!-- 페이징 기능 구현 -->

<div>
	<c:forEach begin="1" end="${requestScope.pagingCnt}" var="page">
		<c:choose>
			<c:when test="${page eq param.cPage || empty param.cPage && page eq 1}">
				<span class="colorRed">${page}</span>				
			</c:when>
			<c:otherwise>
				<span><a href="list?cPage=${page}&searchType=${param.searchType}&searchText=${param.searchText}">${page}</a></span>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>



										<!-- 검색 기능 구현 -->
<div>
	<form action="list" method="get">
	<div>
		<select name="searchType">
			<option value="1" ${param.searchType == 1 ? 'selected': ''}>제목+내용</option>
			<option value="2" ${param.searchType == 2 ? 'selected': ''}>제목</option>
			<option value="3" ${param.searchType == 3 ? 'selected': ''}>내용</option>
			<option value="4" ${param.searchType == 4 ? 'selected': ''}>글쓴이</option>
		</select>
		<input type="search" name="searchText" value="${param.searchText}">
		<input type="submit" value="검색">
	</div>
	</form>
</div>
<script src="/res/js/boardList.js"></script>
