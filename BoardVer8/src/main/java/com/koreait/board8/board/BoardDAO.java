package com.koreait.board8.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board8.DBUtils;

public class BoardDAO {
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
				
		String sql = "SELECT B.unm as writerNm, B.profileImg, "
				+ "	A.iboard, A.title, A.iuser, A.regdt "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser ";
		
//			검색 기능 경우의 수 처리
		switch(param.getSearchType()) {
		case 1: //제목+내용
			sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' "
					, param.getSearchText(), param.getSearchText());
			break;
		case 2: //제목
			sql += String.format("WHERE A.title LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 3: //내용
			sql += String.format("WHERE A.ctnt LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 4: //글쓴이
			//sql += String.format("WHERE B.unm LIKE '%%%s%%' ", param.getSearchText());
			sql += "WHERE B.unm LIKE '%" + param.getSearchText() + "%'";
			break;
		}
				
			sql += " ORDER BY iboard ASC "
				+ " LIMIT ?, ?"; // 페이징 처리 추가
	
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			// 페이징 처리 값 넣어주기
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));
				vo.setProfileImg(rs.getString("profileImg"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
			return list;
		}

// 페이지 end 값을 받아 올 메소드 (list.jsp에서 활용)
	public static int selPagingCnt(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard) / ? ) ")
		.append(" FROM t_board A")
		.append(" INNER JOIN t_user B ")
		.append(" ON A.iuser = B.iuser ");
		
		if(param.getSearchType() > 0) {
			sb.append(" WHERE ");
		}
		
		switch(param.getSearchType()) {
		case 1:
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		// 제목
		case 2:
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		// 내용	
		case 3:
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		// 글쓴이
		case 4:
			sb.append("A.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			
			ps.setInt(1, param.getRecordCnt()); // 페이지 당 몇 개씩 보여줄지의 값을 set
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1); // 첫 번째 컬럼을 의미 (기존에는 컬럼명을 항상 설정했음 / 만약 주고 싶을 땐 as를 준 다음 설정)
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static BoardDomain selBoard(BoardDTO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardDomain result = null;
		
		
		String sql = "SELECT B.unm as writerNm, "
				+ "	A.iboard, A.iuser, A.regdt, A.title, A.ctnt "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardDomain();
				
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("iuser"));
				result.setWriterNm(rs.getString("writerNm"));
				result.setRegdt(rs.getString("regdt"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
		
	}
	
	public static int insBoard(BoardEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt, iuser) VALUES(?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
