package com.koreait.board4;

import javax.servlet.ServletException;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(fileNm).forward(request, response);
//		풀기
//		RequestDispatcher rd = request.getRequestDispatcher(jsp);
//		rd.forward(request, response);
	}
//	"10" = 10, "10a" = 0이 되도록 하는 메소드
	public static int parseStringToInt(String num) {
		try {
			return Integer.parseInt(num);			
		} catch(Exception e) {
			
		}
		  return 0;
	}
//	getParameter값을 부르는 두 줄 코드를 요약하는 메소드
	public static int getParamInt(HttpServletRequest request, String iboard) {
		String key = request.getParameter(iboard);
		int intVal = parseStringToInt(key);
		return intVal;
//		OR return parseStringToInt(request.getParameter(iboard));
	}
}
