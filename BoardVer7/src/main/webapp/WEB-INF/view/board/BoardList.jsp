<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <h1>리스트</h1>
  <div>
  	<div>
  		<form action="list" method="get">
  			<div>
  			<input type="search" name="search" value="${param.search}"> <!-- 검색한 값이 남아있음 -->
  			<input type="submit" value="검색">	
  			</div>
  		</form>
  	</div>
		<table>
			<tr>
				<td> 글 번호 </td>
				<td> 글 제목 </td>
				<td> 등록시간 </td>
				<td> 작성자 </td>
			</tr>
			<c:forEach items = "${requestScope.list}" var = "i">
			 <tr class="record" onclick="moveToDetail(${i.iboard})">
				<td> ${i.iboard} </td>
				<td> ${i.title} </td>
				<td> ${i.regdt} </td>
				<td> ${i.unm} </td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div> <!-- 페이징 처리 -->
		<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
			<a href="list?page=${cnt}&search=${param.search}"><span>${cnt}</span></a> 
		</c:forEach>
	</div>
	
</body>
</html>