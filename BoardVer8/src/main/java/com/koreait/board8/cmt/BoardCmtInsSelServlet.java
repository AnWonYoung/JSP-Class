package com.koreait.board8.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board8.MyUtils;
// cmt 전체 AJAX로 처리할 것
@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 댓글 리스트 날리기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		
		List<BoardCmtDomain> list = BoardCmtDAO.selBoardCmtList(param);
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("json : " + json);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter()
		.append(json);
	}
	

	
	// 댓글 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		boarddetail.js regAjax(param)함수에 등록된 값들이 여기로 날아옴
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPK(request); // iuser값은 세션 값으로
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		
//		json형태로 보내주기 {"result": result} 형태
		int result = BoardCmtDAO.insCmt(param);
		
//		Gson gson = new Gson();
//		String json = gson.toJson(result);
//		System.out.println("json : " + json);
		
//		response.getWriter().append(json);
		
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}");
		
//		System.out.println("result : " + result);

	}

}
