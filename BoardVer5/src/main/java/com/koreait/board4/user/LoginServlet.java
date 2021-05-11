package com.koreait.board4.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.utils.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인이 되어 있을 때 로그인 페이지로 가면 list로 이동하는 방법
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO.loginUser(vo);
		System.out.println("result : " + result);
		
		if(result == 1 ) {
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", vo);  // 로그인 성공했을 때 list로 이동, 실패는 ListServlet
												  // vo가 가르키는 UserVO객체는 (iuser, uid, unm의 값만)
			response.sendRedirect("/board/list");
			
			return;
		}
		
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러 발생";
			break;
		case 2:
			errMsg = "아이디를 확인하세요";
			break;
		case 3:
			errMsg = "비밀번호를 확인하세요";
			break;
		}
		request.setAttribute("errMsg" , errMsg); // login.jsp EL식에 사용
		doGet(request, response); // --> 맨 위 doGet 메소드 호출을 통해서 다이렉트로 주소 이동 연결
//			
//			response.sendRedirect("login"); --> 쿼리스트링으로 연결 (메소드가 끊겨 있음, 주소값 연결 불가)
	}

}
