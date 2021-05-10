package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod4")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // detail Servlet과 비슷
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
	
		BoardVO data = BoardDAO.selBoard(intIboard);
		
		String view = "/WEB-INF/view/mod4.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
	// write Servlet과 비슷
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard"); // iboard값을 이미 알고 있을 때는 받아야 함
		String title = request.getParameter("title"); // getParameter 값은 항상 String
		String ctnt = request.getParameter("ctnt");
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(intIboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		BoardDAO.updBoard(vo);
		// 디테일로 이동
		response.sendRedirect("/detail4?iboard=" + iboard);	
	}

}
