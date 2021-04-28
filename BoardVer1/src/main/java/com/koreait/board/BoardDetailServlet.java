package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx = request.getParameter("no");
		
		request.setAttribute("data", Database.list.get(Integer.parseInt(idx)));
		// idx가 현재 String 타입이므로 형변환 시켜주기
		
		// 화면 나타내기
		String jsp = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		// get방식으로 서버한테 값을 전달할 때는 쿼리스트링으로 전달해야 함
		// post방식으로 서버한테 값을 전달할 때는 form 태그 사용, method를 post로 한 뒤 전달하기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
	}

}
