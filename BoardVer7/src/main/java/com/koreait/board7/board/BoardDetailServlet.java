package com.koreait.board7.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board7.MyUtils;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("디테일", "board/detail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		
		BoardVO result = BoardDAO.selBoard(param);
		
		response.setCharacterEncoding("UTF-8");
		
		// 위에 담긴 값을 JSON 형태로 만들어 주기
		
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson(); //gson 다운 후 라이브러리 사용 (객체 주소값만 보내면 끝)
		String json = gson.toJson(result);
		
		System.out.println(json);
		
		pw.append(json);
		
		// 아래를 위 gson 라이브러리로 처리
		/*pw.append("{\"iboard\":");
		pw.append(String.valueOf(result.getIboard()));
		pw.append(", \"title\": ")
		.append("\"")
		.append(result.getTitle())
		.append("\", \"ctnt\": \"")
		.append(result.getCtnt())
		.append("\"}");
		*/
	}

}
