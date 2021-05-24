<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/res/css/common.css">
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<nav>		
			<ul><!-- loginUser키 값을 활용해 로그인 유무를 알아내고 원하는 값을 설정 -->
			
				<c:if test="${empty sessionScope.loginUser}">
					<li><a href="/user/login">로그인</a></li>				
				</c:if>
				
				<c:if test="${not empty sessionScope.loginUser}">
					<li><a href="/user/logout">로그아웃</a></li>
					<li><a href="/board/write">글쓰기</a></li>
					<li><a href="/board/favList">좋아요</a></li>
				</c:if>
				
					<li><a href="/board/list">리스트</a></li>
			</ul>
		</nav>
	</header>
							<!--  request에 page라는 이름으로 담을 것 -->
  <section>
	<jsp:include page="/WEB-INF/view/${requestScope.jsp}.jsp"></jsp:include>
  </section>
  <!-- section =/ div (section이 조금 더 의미를 가짐) -->
</body>
<script src="/res/js/userjoin.js"></script>
</html>