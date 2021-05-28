<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    									<!-- on~ = 이벤트 발생 -->
    									<!-- onsubmit은 리턴 값이 생겨야함 false는 날아가지 않으므로 부정으로
    										리턴 값을 걸어줘야 함 (긍정이면 무조건 값이 날아가는 구조) 
    										리턴 값은 메소드로 설정할 수 있음 -->
<form id="frm" action="join" method="post" onsubmit="return frmChk();">
	<div>
		<input type="text" name="uid" placeholder="아이디">
		<input type="button" name="btnChkId" value="중복ID체크">
		<!--  id or name 값을 준 다음에 js로 접근하기 / 이벤트는 js에서 처리  -->
	</div>
	<div id="chkUidResult"></div>
	<div><input type="password" name="upw" placeholder="비밀번호"></div>
	<div><input type="password" name="chkUpw" placeholder="비밀번호 확인"></div>
	<div>
		성별:
		<label>여성 <input type="radio" name="gender" value="0" checked></label>
		<label>남성 <input type="radio" name="gender" value="1"></label>
	</div>
	<div><input type="text" name="unm" placeholder="이름"></div>
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</div>
</form>