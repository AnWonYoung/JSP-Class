<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="/res/css/mypage.css">
<!-- img라는 키 값으로 pageContext에 /res/img/noprofile.jpg를 setAttribute한 것 -->
	<c:choose>
		<c:when test="${empty sessionScope.loginUser.profileImg}">
			<c:set var="img" value="/res/img/noprofile.jpg"/>
		</c:when>
		<c:otherwise>
			<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}"/>
		</c:otherwise>
	</c:choose>
	<!-- accept로 이미지 파일 확장자만 업로드할 수 있도록 설정 / name 값도 중요하니 생각하고 넣기 -->
	<!-- cos.jar 라이브러리 다운 후 업로드를 여러 개 할 수 있도록 구현하기 -->
	<!--  아래에서 post방식으로 날리면 패킷 단위라서 서블렛에서 cos.jar 라이브러리를 사용한 것 -->
	<div>
		<form id ="frm" action="mypage" method="post" enctype="multipart/form-data" onsubmit="return imgChk();">
			이미지변경 : <input type="file" name="profileImg" accept="image/*">
			<input type="submit" value="이미지 업로드">
		</form>
	</div>

<div>
<!--  위에서 setAttribute해줘서 el식으로(img값) 사용이 가능해짐 -->
	<div><img src="${img}"></div>
	<div>PK : ${sessionScope.loginUser.iuser}</div>
	<div>ID : ${sessionScope.loginUser.uid}</div>
	<div>Name : ${sessionScope.loginUser.unm}</div>
</div>

<!-- 
이클립스에서는 사진 파일이 실제로 보이지 않음
아레 폴더 안에서 업로드를 확인할 수 있음
D:\JavaBackendClass\JavaBackendClass\JavaBackendClass\WebWorkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BoardVer8\res\img
-->

<script>
	var frmElem = document.querySelector('#frm');
	function imgChk() {
	if(frmElem.profileImg.files.length === 0)) {
		alert('이미지를 선택해 주세요.')		
		return false;
	};
	}

</script>





















