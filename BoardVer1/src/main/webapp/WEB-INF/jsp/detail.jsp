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
<title>Detail</title>
</head>
<body>
	<h1>디테일 <%= no %></h1> <!-- 옆에 값 찍을 때 -->
	<div><%request.getParameter("no"); %></div>
	<div>
	<!-- post방식으로 삭제하기 -->
		<form action="/del" method="post">
		<input type="hidden" name= "no" value="<%=no %>">
		<input type="submit" value="삭제">
		</form>
		
		<a href="/mod?no=<%=no %>"><button>수정</button></a>
		
		<!--<a href="/del?no=<%=no%>"><button>삭제</button></a>-->
	</div>
	<div>제목:<%= vo.getTitle() %> </div>
	<div> <%= vo.getCtnt() %></div>
</body>
</html>