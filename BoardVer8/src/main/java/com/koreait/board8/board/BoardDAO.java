package com.koreait.board8.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board8.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		String sql = "SELECT "
				+ "	A.iboard, A.title, A.iuser, A.regdt "
				+ "	, B.unm as writerNm"
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
	
	try {
		con = DBUtils.getCon();
		ps = con.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {		// 한 줄이 나올 때만 if문
			BoardDomain vo = new BoardDomain();
			int iboard = rs.getInt("iboard");
			String title = rs.getString("title");
			String regdt = rs.getString("regdt");
			//String writerNm = rs.getString("writerNm");
			
			vo.setIboard(iboard);
			vo.setTitle(title);
			vo.setRegdt(regdt);
			vo.setWriterNm(rs.getString("writerNm")); // unm을 담을 수 없어서 해당 변수로 바꾼 것
			
			list.add(vo);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBUtils.close(con, ps, rs);
	}
		return list;
	}

}
