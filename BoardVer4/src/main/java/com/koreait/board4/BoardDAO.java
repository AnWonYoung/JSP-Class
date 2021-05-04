package com.koreait.board4;
// Data Access Object (DB 쿼리 실행)
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BoardDAO {
	// 글 등록 write에 사용
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null; // VALUES 안에 값 넣기가 편해짐, 물음표 안에 값을 넣으며 쿼리를 완성 및 실행까지 시켜주는 역할
		
		String sql = " INSERT INTO t_board " + " (title, ctnt) " + " VALUES (?, ?) ";
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql); // 해당 쿼리로 준비하기 prepare 과거형X
			ps.setString(1, vo.getTitle()); // sql 안에 값을 담는 방법
			ps.setString(2, vo.getCtnt());
//			ps.setInt(1, 1);
//			ps.setInt(2, 10);				타입에 맞춰서 적어주기
			
			return ps.executeUpdate(); // int만 리턴해줌 insert, update, delete = 1 넘어와야 해당 명령이 잘 처리된 것 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButils.close(con, ps);
		}
		
		return 0;
	}
	
	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null; // 클래스명
		ResultSet rs = null;
		
		String sql = "SELECT iboard, title, regdt FROM t_board"
					 + " ORDER BY iboard ASC "; // 빈칸 앞,뒤 중 한 곳에 반드시 주기
												 // 내림차순으로 정렬하기
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql); // 메소드명
			// 위는 필수적
			
			
			rs = ps.executeQuery(); // 쿼리 실행 
			
			// rs.next메소드가 하는 일 두 가지
			// 최초 실행 시 첫 번째 줄을 의미함 return 타입은 boolean
			// 첫 째줄에 레코드가 있으면 true 반대는 false
			// 다음 실행 시 두 번째 줄을 의미하며 계속 반복함
			// db 테이블을 삭제하면 while 반복이 돌지 않고 실행X(리턴은 O)
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo); // 래퍼런스 변수. 위치는 객체 생성 아래면 상관 없음
				
				int iboard = rs.getInt("iboard"); // int 타입의 컬럼명 iboard의 값을 달라는 것
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButils.close(con, ps, rs);
		}
		
		
		return list;
	}
	// detail에 사용 타입 주의
	public static BoardVO selBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM t_board WHERE iboard = ? ";
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);				
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setRegdt(regdt);
				
				return vo;
				
			}
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DButils.close(con, ps, rs);
			}	
			return null;
		}
	
	public static int delBoard(BoardVO data) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_board WHERE iboard = ? ";
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, data.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButils.close(con, ps);
		}
		
		return 0;
	}
	
	public static int updBoard(BoardVO data) {
		Connection con = null;
		PreparedStatement ps = null; // VALUES 안에 값 넣기가 편해짐, 물음표 안에 값을 넣으며 쿼리를 완성 및 실행까지 시켜주는 역할
		
		String sql = " UPDATE t_board " + " SET title = ? " + " , ctnt = ? " + 
					" WHERE iboard = ?";
		
		try {
			con = DButils.getCon();
			ps = con.prepareStatement(sql); // 해당 쿼리로 준비하기 prepare 과거형X
			ps.setString(1, data.getTitle()); // sql 안에 값을 담는 방법
			ps.setString(2, data.getCtnt());
			ps.setInt(3, data.getIboard());

			return ps.executeUpdate(); // int만 리턴해줌 insert, update, delete = 1 넘어와야 해당 명령이 잘 처리된 것 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButils.close(con, ps);
		}
		
		return 0;
	}
}
