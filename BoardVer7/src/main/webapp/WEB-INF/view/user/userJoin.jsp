<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	<div>
		<a href="login"><button>로그인으로 돌아가기</button></a>
	</div>
	<div>
		<form id="frm">
			<div><input type="text" name="uid" placeholder="아이디"></div>
			<div><input type="text" name="upw" placeholder="비밀번호"></div>
			<div><input type="text" name="unm" placeholder="이름"></div>
			<div>
				성별:
				<label>여성<input type="radio" name="gender" value="0"></label>
				<label>남성<input type="radio" name="gender" value="1"></label>
			</div>
		</form>
	<input type="button" value="회원가입" onclick="join();">
		
	</div>
	<!-- 아래를 외부 파일이라 생각하기 -->	
	<script>
	function join() {
		var frmElem = document.querySelector('#frm');
		var uid = frmElem.uid.value;
		var upw = frmElem.upw.value;
		var unm = frmElem.unm.value;
		var gender = frmElem.gender.value; 
		
//		console.log('uid : ' + uid);
//		console.log('upw : ' + upw);
//		console.log('unm : ' + unm);
//		console.log('gender : ' + gender);
		
		// 서버를 JSON 형태로 날릴 것
		// 자스는 아래처럼 짧게 객체를 생성할 수 있음
		// console에 찍어보면 객체로 찍힘을 알 수 있음(문자열로)
		var param = {
				uid: uid,
				upw: upw,
				unm: unm,
				gende: gender
		}
//		var param2 = {uid, upw, unm, gender}; 
//		변수가 멤버 필드와 같으면 위처럼 적을 수 있음
//		var param2 = {uid, 'ddd' : upw, unm, gender};
//		만약 변수명과 멤버필드가 같지 않을 때
		
		console.log(param);
		
		ajax(param);
	}
	
	function ajax(param) {
		// 세팅하기
		const init = {
				method: 'POST',
				body: new URLSearchParams(param)
		}
		// 주소값으로 통신 날리기
		fetch('/user/join', init)
		.then(function(res) {return res.json();})
		.then(function(myJson) {
			switch(myJson.result) {
			case 0:
				alert('회원가입 실패');
				break;
			case 1:
				location.href='/user/login';
				break;
			}
		})
	}
	</script>
</body>
</html>