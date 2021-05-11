package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board4.utils.DBUtils;

public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_user " + "(uid, upw, unm, gender) " + 
					 " values " + " (?,?,?,?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); // 생성즉시 ps는 null이 아님
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate(); // 영향을 미친 수의 정수 값을 리턴
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
	
	//로그인 성공:1, 아이디없음:2, 비밀번호틀림: 3, 에러: 0
	
	public static int loginUser(UserVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM t_user WHERE uid = ? "; // 로그인은 select문, where절에서 id값만으로 확인
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
//				return rs.getString(1).equals(param.getUpw()) ? 1 : 2; << param.getUpw는 내가 친 비번
				String dbPw = rs.getString("upw"); // db에 저장된 비번
				if(dbPw.equals(param.getUid())) {
					return 1;
				} else {
					return 3;
				}
				
			} else {
				//아이디가 없는 경우
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

}
