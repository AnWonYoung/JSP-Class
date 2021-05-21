package com.koreait.board4.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.cmt.CmtDAO;
import com.koreait.board4.utils.MyUtils;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO vo = new BoardVO();
		request.setAttribute("data", BoardDAO.selBoard(iboard));
		request.setAttribute("Cmtlist", CmtDAO.Cmtlist(iboard)); // 댓글 list를 뿌리기 위해 작성 >> el식에 활용
		
		MyUtils.openJSP("board/detail", request, response);
	}


}
 