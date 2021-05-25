package com.koreait.board8.cmt;
// 등록, 수정, 삭제 파라미터 (등록은 도메인에서)
public class BoardCmtEntity {
	private int icmt;
	private int iboard;
	private int iuser;
	private String cmt;
	private String regdate;
	
	public int getIcmt() {
		return icmt;
	}
	public void setIcmt(int icmt) {
		this.icmt = icmt;
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
