package com.koreait.board6.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board6.MyUtils;

@WebServlet("/user/userLogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/userLogin", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO vo = new UserVO();
		vo.setUid(uid);
//		vo.setUpw(upw);
		
		UserVO result = UserDAO.selUser(vo);
		
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
