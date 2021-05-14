package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.user.UserVO;


public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		String jsp = "/WEB-INF/view/" + fileNm + ".jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}
	
	// int로 변환하는 메소드 (만약 문자열이 섞였다면 0을 반환 - 미설정 시 에러 발생, catch로 미리 잡아주기)
	public static int parseStringToInt(String val) {
		try {
			return Integer.parseInt(val);
		}catch(Exception e) {
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest req) {
		String val = req.getParameter(key);
		int intVal = MyUtils.parseStringToInt(val);
		
		return intVal;
	}
	
	public static UserVO getLoginUser(HttpServletRequest req) {
		if(req == null) { return null;}
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}
	
	public static int getLoginPK(HttpServletRequest req) {
		return getLoginUser(req).getIuser();
	}
	
}
