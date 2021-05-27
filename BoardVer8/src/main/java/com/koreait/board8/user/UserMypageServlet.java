package com.koreait.board8.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("마이페이지", "user/mypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getRealPath("/res/img"); // 해당 메소드는 곧 없어진다는 뜻
		
		int maxFileSize = 10_485_760; // 10*1024*1024(10mb)
		
		System.out.println("uploadPath : " + uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "UTF-8", new DefaultFileRenamePolicy());
		// MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
		// 파일을 저장할 디렉토리 지정 (uploadPath)
		// 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
		// new DefaultFileRenamePolicy() 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
		
		int loginUserPk = MyUtils.getLoginUserPK(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk; // 여기서 설정하면서 로그인이 필수
		
		// 파일 객체 생성
		File folder = new File(targetFolder);
		if(!folder.exists()) { // 폴더가 존재하지 않으면 false
			folder.mkdirs(); // false일 때 폴더를 생성한다는 뜻(무조건 mkdirs를 사용)
		}
		// 업로드가 된 파일명 받아오기
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println("fileNm : " + fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); // indexOf만 하면 왼쪽부터 찾음, last는 오른쪽에서부터 찾아서 해당 위치값을 전달
		String ext = fileNm.substring(lastDotIdx); // 위에서 받은 값을 자르고 jpg라는 확장자만 따오게 됨
		String newfileNm = UUID.randomUUID().toString() + ext; //UUID를 문자열로 바꾼 다음 아래에서 사용
		
		// 위 주소값을 파일로 이동
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm); // 위에서 temp안에 들어간 사진을 불러온 것
		imgFile.renameTo(new File(targetFolder + "/" + newfileNm)); // 안에 이동하려는 파일 주소값을 적어두기(이걸 UUID로 적용)
																		  // renameTo를 사용해서 원래 위치하고자 하는 폴더에 이동하는 원리
	}

}
