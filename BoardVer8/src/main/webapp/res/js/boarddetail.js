var cmtFrmElem = document.querySelector('#cmtFrm');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;
//  console.log('cmtVal : ' + cmtVal);
//	console.log(cmtFrmElem.dataset.iboard); 
	// 위처럼 .으로 속성값에 접근이 가능
	
	var param = {
		iboard: cmtFrmElem.dataset.iboard,
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
	
	fetch('/board/cmtInsSel', init)
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
				alert('등록 성공!');
			break;
		}
	})
}
// 서버에게 댓글 리스트를 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtFrmElem.dataset.iboard;
	
	fetch('/board/cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
	});
}

getListAjax(); // 해당 파일이 import되자마자 함수를 1회 호출하는 것