package com.yuni.domain;

import java.util.Date;

public class MemberVO {
	int no;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String Picture;
	private String joinDate;
	private String orgfileName;
	
	
	
	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getPicture() {
		return Picture;
	}



	public void setPicture(String picture) {
		Picture = picture;
	}



	public String getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}



	public String getOrgfileName() {
		return orgfileName;
	}



	public void setOrgfileName(String orgfileName) {
		this.orgfileName = orgfileName;
	}



	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
				+ memberName + ", Picture=" + Picture + ", joinDate=" + joinDate + ", orgfileName=" + orgfileName + "]";
	}
	
	
	

}
