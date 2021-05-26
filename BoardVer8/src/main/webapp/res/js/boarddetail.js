var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;
//  console.log('cmtVal : ' + cmtVal);
//	console.log(cmtFrmElem.dataset.iboard); 
	// 위처럼 .으로 속성값에 접근이 가능
	
	var param = {
		iboard: cmtListElem.dataset.iboard,
		cmt: cmtVal
	};
	regAjax(param);
}

// 서버에 등록해주는 함수
function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res) {
		return res.json();
	}) // 데이터 형식으로 바꿔줌(Servlet에서 append로만 된 값)
	.then(function(myJson) {
		
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('등록 실패!');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
//				alert('등록 성공!');
				getListAjax();
			break;
		}
	})
}
// 서버에게 댓글 리스트를 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		
		makeCmtElemList(myJson);
	});
}

// html이 아닌 js로 댓글창 구현하기
// 메모리로 <table></table> << 해당 형식이 생성되도록 설정한 것
function makeCmtElemList(data) {
	
//	case 1: 에서 getListAjax();를 호출하며 생기는 중복 테이블을 없애기
	cmtListElem.innerHTML = '';
	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');
//	<th>내용</th>과 같음
	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';
//  Title 안쪽으로 소속시킨 것	
	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);
//	모두를 table 안으로 소속시킨 것
	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);
	
//	세션에 박힌 로그인 값을 가져와서 삭제 및 수정 구현, dataset으로 사용할 때는 대문자 불가능
	var loginUserPk = cmtListElem.dataset.login_user_pk;
	
// data는 makeCmtElemList(data)의 data값, 반복문은 함수라는 인자값을 가지며 item을 계속해서 넣어준다는 의미	
	data.forEach(function(item) {
		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');
// innerText, append 모두 값을 넣을 수 있음		
		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);
		
		if(parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			
//			삭제=ajax로 날릴 것, 안에 적지 않고 따로 함수를 생성 해 안에서 호출만 해두기 
			delBtn.addEventListener('click', function() {
				delAjax(item.icmt);
			})
			
			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';
			
			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}
		
		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);
		
		tableElem.append(trElemCtnt);
	});
}
// 삭제하는 함수
function delAjax(icmt) {
	fetch('cmtDelUpd?icmt=' + icmt)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		switch(myJson.result) {
			case 0:
				alert('댓글 삭제 실패');
			break;
			case 1:
				getListAjax();
			break;
		}
	});
}


getListAjax(); // 해당 파일이 import되자마자 함수를 1회 호출하는 것