package com.koreait.board;
// 요청에 응답할 수 있는 곳
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list") // URL 중요!
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		클라이언트(브라우저)에서 값이 서버쪽으로 넘어왔을 때
//		값 빼내는 방법 > requset.getParameter(키값);
		
//		서블릿에서 jsp로 값 전달하는 방법
//		값 넣는 방법 > request.setAttribute(키값, 벨류값);
//		값 빼는 방법 > request.getAttribute(키값, 벨류값);
		
		request.setAttribute("data", Database.list);
		
		String jsp = "/WEB-INF/jsp/list.jsp"; // get 방식은 jsp파일을 응답으로 한다
		request.getRequestDispatcher(jsp).forward(request, response);
	}

}
