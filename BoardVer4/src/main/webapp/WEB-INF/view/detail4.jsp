<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<style>
body {
       background-color: rgb(255, 224, 85);
       color: rgb(248, 131, 203);
       text-align: center;
       width: 70%;
	   margin-right:auto;
	   margin-left:auto;
    }
a {
	text-decoration: none;
	color: red;
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

</style>
</head>
<body>
	<a href="/del4?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="/mod4?iboard=${param.iboard}"><button>수정</button></a>
	<div><a href="/list4">리스트</a></div>
	<div>제목 : ${data.title}</div>
	<div>작성일 : ${data.regdt}</div>
	<div>
		${data.ctnt}
	</div>
</body>
</html>