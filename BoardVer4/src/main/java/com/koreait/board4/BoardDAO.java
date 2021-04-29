package com.koreait.board4;
// Data Access Object (DB 쿼리 실행)
import java.sql.*;
public class BoardDAO {
	// 글 등록
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board " + " (title, ctnt) " + " VALUES (?, ?) ";
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql); // 해당 쿼리로 준비하기 prepare 과거형X
			ps.setString(1, vo.getTitle()); // sql 안에 값을 담는 방법
//			ps.setInt(1, 1);
//			ps.setInt(2, 10);				타입에 맞춰서 적어주기
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButils.close(con, ps);
		}
		
		return 0;
	}

}
