package com.koreait.board6.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class CmtDAO {
	public static void insCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO t_board_cmt (iboard, iuser, cmt)"
					  + "VALUES (?,?,?)";
		
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
	
	public static List<CmtVO> selCmtList(int iboard) {
		List<CmtVO> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select B.unm "
					 + " , A.icmt, A.cmt, A.regdate, A.iuser "
					 + " from t_board_cmt A "
					 + " inner join t_user B "
					 + " on A.iuser = B.iuser "
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
				vo.setunm(rs.getString("unm"));

				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}
	
	public static int delCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " delete from t_board_cmt where icmt = ? and iuser = ? ";
		
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
	
	public static int updCmt(CmtVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "update t_board_cmt set cmt = ? where icmt = ? and iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, param.getCmt());
			ps.setInt(2, param.getIcmt());
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
