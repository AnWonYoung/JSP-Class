package com.koreait.board8.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board8.DBUtils;

// entity(DB)
// domain (select 결과물)
// DTO (parameter)
// UserVO로 위 3가지를 모두 설정했음 --> 지금부터 분리

public class UserDAO {
	// 아이디가 있으면 return 1; || 아이디가 없으면 return 0;
	public static int selIdChk(String uid) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select iuser from t_user where uid = ? ";
						// uid보다 iuser가 빠를 것
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid.trim()); // 공백을 없애는 trim
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static UserEntity selUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserEntity result = null;
		
		String sql = "select iuser, uid, upw, unm, profileImg from t_user where uid = ? ";
		
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
				String profileImg = rs.getString("profileImg");
				
				result = new UserEntity();
				
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
				result.setProfileImg(profileImg);
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
	}
	
	public static int updUser(UserEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		String updString = null;
		
		String sql = "UPDATE t_user SET ";
		if(param.getUpw() != null && !param.getUpw().equals("")) {
			sql += " upw = ? ";
			updString = param.getUpw();
		} else if(param.getProfileImg() != null && !param.getProfileImg().equals("")) {
			sql += " profileImg = ? ";
			updString = param.getProfileImg();
		}
		sql += " WHERE iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, updString);
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
