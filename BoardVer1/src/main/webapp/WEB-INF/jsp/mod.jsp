<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.koreait.board.BoardVO" %>
    
 <% String no = request.getParameter("no"); 
 	BoardVO vo = (BoardVO) request.getAttribute("data");
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정</h1>
	<form action="/mod" method= "post"> <!-- action은 갈 곳, method는 getter -->
										  <!-- get / post 방식 둘 중 선택 -->
		<input type="hidden" name= "no" value="<%=no %>">
		<div>
			제목: <input type="text" name="title" value=<%= vo.getTitle() %>>
		</div>
		<div>
			내용: <textarea name="ctnt" rows="10" cols="10" ><%= vo.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글 수정"> <!-- 눌렀을 때 get방식으로 write에 감 -->
		</div>
	
	</form>
</body>
</html>