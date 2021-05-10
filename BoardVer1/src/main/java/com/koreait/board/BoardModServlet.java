package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		request.setAttribute("data", Database.list.get(Integer.parseInt(no)));
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");		// 어떤 no값을 받아 수정할지 정해주기
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
//		BoardVO vo = new BoardVO();
//		// 이전 값을 받은 다음 수정하기
//		vo.setTitle(title);
//		vo.setCtnt(ctnt);
//		Database.list.set(Integer.parseInt(no), vo);
		
		// 위보다 아래가 더 수정의 개념에 가까움
		// 새롭게 객체를 생성하여 바꾸기 보다 있는 값을 수정하기
		int intNo = Integer.parseInt(no);
		BoardVO vo = Database.list.get(intNo);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		// 주소값 이동
		
		response.sendRedirect("/detail?no=" + no);
	}

}
