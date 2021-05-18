var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

// 댓글 삭제
function delCmt(iboard, icmt) {
	console.log(`iboard : ${iboard}, icmt: ${icmt}`); // 여기 el식 아님!
	
	if(confirm('삭제 하시겠습니까?')) {
	location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
		
	}
	
}

//function delboard(iboard) {
//	console.log(`iboard : ${iboard}`);
//	if(confirm(`게시글을 삭제하겠습니까?`)) {
//		location.href = `Delboard.del?iboard=${iboard}`;
//	}
//}

// 댓글 수정을 눌렀을 때 실행
function updCmt(icmt, cmt) {
	console.log ('icmt : %s', icmt);
	console.log ('cmt : %s', cmt);
	
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	
	insFrm.className = 'hidden';
	updFrm.className = '';
}

function showInsFrm() {
		insFrm.className = '';
		updFrm.className = 'hidden';
}