package com.koreait.board7.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.Const;
import com.koreait.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 페이징 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search"); // 검색 기능
		if(search == null) {search = "";} // 위에서 null이 넘어와서 처리
		
		int page = MyUtils.getParamInt(Const.PAGE, request);
	    if(page == 0) { page = 1; } // 페이지가 0일 수 없도록 설정 (예방)
	   
	    int recordCnt = 3; // 3개의 레코더만 만들 수 있도록
	    int sIdx = (page -1) * recordCnt; // 페이징 레코더 계산식
	    
	    BoardVO param = new BoardVO();
	    param.setsIdx(sIdx);
	    param.setPage(recordCnt);
	    param.setSearch(search);
	    
	    request.setAttribute("list", BoardDAO.selBoardList(param)); // 인덱스와 페이징 값을 보내줌
		request.setAttribute("totalPage", BoardDAO.getAllPage(param));
		
		MyUtils.openJSP("글 목록", "board/BoardList", request, response);
	}


}
