package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.user.UserVO;
import com.koreait.board4.utils.MyUtils;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = BoardDAO.selBoard();
		request.setAttribute("list", list);
		
		HttpSession hs = request.getSession();
	
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser"); // loginUser 키 값은 list EL식을 쓰는데 사용

		//로그인 X > login으로 이동
		
		if(loginUser == null) { // false로 다시 잡을 필요X 로그인을 했을 경우에만 loginUser로 값이 담김
			response.sendRedirect("/user/login");
			return;			// return 필수
		}
		//로그인 O > list로 이동 
		MyUtils.openJSP("board/list", request, response);
	}
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		
		// LoginServlet의 키 값을 받아오기
		Boolean loginSuccess = (Boolean)hs.getAttribute("loginSuccess");
		System.out.println("loginSuccess : " + loginSuccess);
		
		if(loginSuccess == null || loginSuccess == false) { //로그인을 안했거나,틀렸을 때 모두 login창으로 이동
			response.sendRedirect("/user/login");			// 로그인 성공은 LoginServlet
			return;
		}
		
		MyUtils.openJSP("board/list", request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
