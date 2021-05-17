function delCmt(iboard, icmt) {
	console.log(`iboard : ${iboard}, icmt: ${icmt}`); // 여기 el식 아님!
	
	if(confirm('삭제 하시겠습니까?')) {
	location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
		
	}
	
}