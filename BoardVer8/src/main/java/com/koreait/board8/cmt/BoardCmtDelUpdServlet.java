package com.koreait.board8.cmt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.MyUtils;

@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 댓글 삭제 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPK(request); // 없어도 삭제는 되지만 보안 취약, 세션에 박힌 값 가져오기
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.delBoardCmt(param);
		
		System.out.println("result : " + result);
		
		response.getWriter()
			.append("{")
			.append("\"result\":")
			.append(String.valueOf(result))
			.append("}").flush();
	}
	// 댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request);
		int iboard = MyUtils.getParamInt("iboard", request);
		
		System.out.println("icmt : " + icmt);
		System.out.println("cmt : " + cmt);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setCmt(cmt);
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		int result = BoardCmtDAO.updCmt(param);
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}").flush();
		
	}

}
