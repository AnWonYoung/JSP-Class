package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail4")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String iboard = request.getParameter("iboard"); // jsp에서 보낸 키 값 받아오기
//		
//		int intIboard = Integer.parseInt(iboard);
		
		int iboard = MyUtils.getParamInt(request, "iboard");

		BoardVO data = BoardDAO.selBoard(iboard);
		
		
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/view/detail4.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
