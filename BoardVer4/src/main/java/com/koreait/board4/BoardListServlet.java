package com.koreait.board4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list4")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<BoardVO> list = BoardDAO.selBoardList();
		 request.setAttribute("list", list);
		
		String view = "/WEB-INF/view/list4.jsp";
		MyUtils.openJSP(view, request, response);
	}
}
