package com.koreait.board8.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board8.MyUtils;

@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("title", "로그인"); // setAttribute로 담아야 template${requestScope.변수명}에 담김
//		request.setAttribute("page", "user/login");
//		String jsp = "/WEB-INF/view/template.jsp";
//		request.getRequestDispatcher(jsp).forward(request, response);
		MyUtils.openJSP("로그인", "user/login", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserEntity vo = new UserEntity();
		vo.setUid(uid);
		
		UserEntity result = UserDAO.selUser(vo);
		
		if(result == null) { // 아이디가 없는 경우
			request.setAttribute("errMsg", "아이디를 확인하세요.");
			
		} else if (BCrypt.checkpw(upw, result.getUpw())) { // 아이디 O 비밀번호 체크
			result.setUpw(null);
			
			HttpSession hs = request.getSession();
			hs.setAttribute("loginUser", result);
			response.sendRedirect("/board/list");
			return ;
			
		}else {		// 비밀번호 틀림
			request.setAttribute("errMsg", "비밀번호를 확인하세요.");
		}
		
		doGet(request, response);
	}

}
