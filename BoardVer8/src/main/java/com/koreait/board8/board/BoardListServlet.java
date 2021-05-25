package com.koreait.board8.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDTO param = new BoardDTO();
		
//		 -------------페이징--------------
		final int recordCnt = 5;
		
		int cPage = MyUtils.getParamInt("cPage", request); // 현재 페이지
		if(cPage == 0) {
			cPage = 1;
		}
		
		int startIdx = (cPage - 1) * recordCnt;

		param.setStartIdx(startIdx);
		param.setRecordCnt(recordCnt);
		
//		--------------- 검색 ------------------ list.jsp에서 날린 값 받아주기
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
//			검색 값이 있을 때만 값을 담도록 설정하기
			param.setSearchType(searchType);
			param.setSearchText(searchText);
			
		}
		
		request.setAttribute("list", BoardDAO.selBoardList(param)); // 리스트 뿌리기
		request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param)); // 페이징
		
		MyUtils.openJSP("리스트", "board/list", request, response);
		
	}

}
