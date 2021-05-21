package com.koreait.board4.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.utils.DBUtils;

// 생성해야 하는 메소드
// 값을 뿌리는 list, 값을 넣는 insert, 값을 삭제하는 del, 값을 수정하는 upd
// list -> sql문은 inner join으로 걸어서 select하기, while문으로 값이 읽다면 반복해서 읽어내고 뿌릴 수 있도록

// 값을 뿌릴 list 메소드
public class CmtDAO {
	public static List<CmtVO> Cmtlist (int iboard) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select B.unm, A.icmt, A.cmt, A.regdate, A.iuser"
					 + " from t_board_cmt A inner join t_user B on A.iuser = B.iuser"
					 + " where iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			CmtVO vo = new CmtVO();
			
			vo.setIcmt(rs.getInt("icmt"));
			vo.setCmt(rs.getString("cmt"));
			vo.setRegdate(rs.getString("regdate"));
			vo.setIuser(rs.getInt("iuser"));
			vo.setUnm(rs.getString("unm"));
			
			list.add(vo);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);	
		}
		return list;
	}
// 값을 넣을 insert 메소드
	public static void cmtInsert (CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " insert into t_board_cmt (iboard, iuser, cmt) values (?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			ps.setString(3, param.getCmt());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
// 값을 삭제하는 메소드
	public static int cmtDel (CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "delete from t_board_cmt where icmt ? and iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
// 값을 수정하는 메소드
	public static int cmtUpd (CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "update t_board_cmt set cmt where icmt = ? and iuser = ? " ;
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
