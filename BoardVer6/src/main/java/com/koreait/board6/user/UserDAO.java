package com.koreait.board6.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board6.DBUtils;

public class UserDAO {
	public static UserVO selUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserVO result = null;
		
		String sql = "select iuser, uid, upw, unm from t_user where uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");
				
				result = new UserVO();
				
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
	}
	
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into t_user (uid, upw, unm, gender)"
					+ " values (?,?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
		
	}
}
