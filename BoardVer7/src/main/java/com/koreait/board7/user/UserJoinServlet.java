package com.koreait.board7.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/userJoin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		System.out.println("uid" + uid);
		System.out.println("upw" + upw);
		System.out.println("unm" + unm);
		System.out.println("gender" + gender);
		
		int result = 0; // UserDAO.join(객체)형식이 아닌
		
		PrintWriter pw = response.getWriter();
		pw.append(String.format("{\"result\": %d}", result)); // = {"result": 1} 무조건 1이 리턴 됨 {key값 : value값}
									  // function(myJson)으로 객체화 되어 들어감
		
	}

}
