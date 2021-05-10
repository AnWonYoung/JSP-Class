package com.koreait.board;
// write 사이트가 응답하는 곳 ( 두 개의 메소드가 존재 )
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/write.jsp"; // request로 화면 띄우기
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	// 여기서부터는 처리!!
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		String title = request.getParameter("title"); // 브라우저에서 어떤 값을 받은 것은 request.Parameter로 받아주기
		String ctnt = request.getParameter("ctnt");	  // 제목과 내용 모두 받겠다는 뜻
		
		// BoardVO의 클래스 객체를 생성, iboard는 이용하지 않음
		BoardVO vo = new BoardVO(); // 값을 받고 객체에 담아줄 것
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		Database.list.add(vo); // 위에서 불렀던 걸 다시 담아주기(유연성을 위함)
		
//		List<BoardVO> refList = Database.list;
//		refList.add(vo);
//		31번 줄 풀어썼을 때
		
		
		response.sendRedirect("/list"); // 처리 후 get방식으로 주소 이동하기(화면 이동)
		
	}

}







