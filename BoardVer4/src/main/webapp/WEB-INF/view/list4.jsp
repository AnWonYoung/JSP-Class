<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<style>
body {
       background-color: rgb(255, 224, 85);
       color: rgb(248, 131, 203);
       text-align: center;
    }
a {
	text-decoration: none;
	color: red;
}

table {
	width: 70%;
	margin-right:auto;
	margin-left:auto;
}

table, td, th {
	    border: 2px solid rgb(252, 47, 173);
		border-collapse: collapse;
}

button {
	width:100px;
    background-color: #f8585b;
    border-radius:10px;
    color:#fff;
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px;
    cursor: pointer;
}
.record {
	cursor: pointer;
}
.record:hover {
	background-color: #ecf0f1;
}
</style>
</head>
<body>
	<div>
		<a href="/write4"><button class=button>글쓰기</button></a>
	</div>
	
	<div>
		<table>
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>글 작성일</td>
			</tr>
			
			<c:forEach items="${list}" var="item">
			<tr class="record" onclick="moveToDetail(${item.iboard});"> <!-- oneclick 이벤트 추가 호출과 동시에 ()값을 보냄 -->
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.regdt}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		function moveToDetail(iboard) { // onclick의 값이 들어옴(클릭과 동시에 메소드를 부른 효과를 볼 수 있음)
	//		console.log('iboard : %d', iboard);
			location.href = '/detail4?iboard=' + iboard; // 따라서 iboard 값이 들어오도록 한 뒤 주소 값 이동
		}
	</script>
</body>
</html>