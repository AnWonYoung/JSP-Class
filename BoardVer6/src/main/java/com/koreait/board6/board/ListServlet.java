package com.koreait.board6.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.MyUtils;
import com.koreait.board6.user.UserVO;


@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = BoardDAO.selBoard();
		request.setAttribute("list", list);
		
		HttpSession hs = request.getSession();
	
		UserVO loginUser = (UserVO) hs.getAttribute("loginUser");
		
		if(loginUser == null) { 
			response.sendRedirect("/user/login");
			return;	
		}
		
		MyUtils.openJSP("board/list", request, response);
	}
}
