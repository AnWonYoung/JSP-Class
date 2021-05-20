package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	
	public static int insBoard(BoardVO param) {
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
	
	public static List<BoardVO> selBoard() {
		List<BoardVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select A.iboard, A.title, A.regdt, B.unm from t_board A left "
					  + "join t_user B on A.iuser = B.iuser order by A.iboard DESC";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {		// 한 줄이 나올 때만 if문
				BoardVO vo = new BoardVO();
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static BoardVO selBoard(BoardVO param) {
		BoardVO result = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql ="SELECT B.unm, A.iboard, A.title, A.ctnt, A.iuser, A.regdt, "
				+ "if(C.iboard IS NULL, 0, 1) AS isFav "
				+ "FROM t_board A "
				+ "INNER JOIN t_user B "
				+ "ON A.iuser = B.iuser "
				
				+ "LEFT JOIN t_board_fav C "
				+ "ON A.iboard = C.iboard "
				+ "AND C.iuser = ? "
				+ "WHERE A.iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser()); // 로그인 user PK
			ps.setInt(2, param.getIboard());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardVO();
				
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setRegdt(rs.getString("regdt"));
				result.setIuser(rs.getInt("iuser"));
				result.setUnm(rs.getString("unm"));
				result.setIsFav(rs.getInt("isFav"));
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
		
	}
	
	public static int delBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board WHERE iboard = ? " ;
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, vo.getIboard());
			ps.setInt(2, vo.getIuser()); 
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
		
	}
	
	public static int updBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}

}
