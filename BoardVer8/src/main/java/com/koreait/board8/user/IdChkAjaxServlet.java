package com.koreait.board8.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		// 아이디 값만 사용해서 객체는 쓸 필요 없음
		System.out.println("uid : " + uid);
		
		int result = UserDAO.selIdChk(uid);
		PrintWriter pw = response.getWriter(); // jsp파일을 사용하지 않으니 .append 안의 값으로 응답할 수 있도록 함
		// pw 스스로를 계속해서 return함 
		pw.append("{\"result\" : ");
		pw.append(String.valueOf(result));
		pw.append("}");
		pw.close();
		// {"result" : 0or1}으로 응답하게 됨 >> js 안의 json 형태의 객체로 넘어감
		
	}
}
