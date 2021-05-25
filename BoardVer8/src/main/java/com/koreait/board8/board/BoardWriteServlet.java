package com.koreait.board8.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.MyUtils;

@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("글쓰기", "board/write", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iuser = MyUtils.getLoginUserPK(request);
		
		BoardEntity param = new BoardEntity();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setIuser(iuser);
		
		BoardDAO.insBoard(param);
		
		response.sendRedirect("/board/list");
	}

}
