<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

	<div> 글번호 : <span id = "iboard"></span> </div>
	<div> 글제목 : <span id= "title"></span></div>
	<div> 등록시간 : <span id = "regdt"></span></div>
	<div id="ctnt"></div>
	
	<script>
		function ajax(iboard) {
			console.log('iboard : ' + iboard);
			
			const param = {iboard}
			
			const init = {	
				method: 'POST',
				body: new URLSearchParams(param)
			}
			
			fetch('/board/detail', init)
			.then(function(res) {
				return res.json();
			})
			.then(function(myJson) {
				console.log(myJson);
				
				setData(myJson);
			});
		}
		// 디테일에 값 넣어주는 함수 (span의 id값 사용)
		function setData(data) {
			var iboardElem = document.querySelector('#iboard');
			var titleElem = document.querySelector('#title');
			var regdtElem = document.querySelector('#regdt');
			var ctntElem = document.querySelector('#ctnt');
			
			iboardElem.innerText = data.iboard;
			titleElem.innerText = data.title;
			regdtElem.innerText = data.regdt;
			ctntElem.innerText = data.ctnt;
		}
		ajax(${param.iboard});
	</script>
</body>
</html> 