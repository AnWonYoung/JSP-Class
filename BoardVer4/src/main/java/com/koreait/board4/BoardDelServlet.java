package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del4")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard"); // del4의 키값 받아오기
		int intIboard = Integer.parseInt(iboard);		// 정수형 변경
		
		BoardVO data = new BoardVO();
		data.setIboard(intIboard);
		BoardDAO.delBoard(data);
		
		response.sendRedirect("/list4");
	}


}
