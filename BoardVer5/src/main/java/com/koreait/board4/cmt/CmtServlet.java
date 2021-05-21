package com.koreait.board4.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board4.utils.MyUtils;

@WebServlet("/board/cmt")
public class CmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// 댓글 삭제하기
	// iboard, icmt, iuser 값이 필요함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request); // detail로 넘기기 위한 값
		int icmt = MyUtils.getParamInt("icmt", request); 	// del 메소드에 필요한 값
		int iuser = MyUtils.getParamInt("iuser", request);
		
		CmtVO vo = new CmtVO();
		vo.setIuser(iuser);
		vo.setIcmt(icmt);
		
		CmtDAO.cmtDel(vo);
		
		response.sendRedirect("/board/detail?iboard=" + iboard);
		
	}

	// 댓글 수정 및 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginPK(request); // iuser은 세션에서 가져오는 것
		String cmt = request.getParameter("cmt");
		int icmt = MyUtils.getParamInt("icmt", request);
		
		CmtVO vo = new CmtVO();
		vo.setIcmt(icmt);
		vo.setIuser(iuser);
		vo.setCmt(cmt);
		
	}

}
