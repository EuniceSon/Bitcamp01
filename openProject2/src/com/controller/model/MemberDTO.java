package com.controller.model;

/**
 * @author sonyo
 *
 */
public class MemberDTO {
	int memberNo;
	String memberId;
	String memberPwd;
	String memberName;
	String Picture;
	String joinDate;

	public MemberDTO() {
	}
	

	public MemberDTO(int memberNo, String memberId, String memberPwd, String memberName, String picture,
			String joinDate) {
		this();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		Picture = picture;
		this.joinDate = joinDate;
	}


	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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


	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", Picture=" + Picture + ", joinDate=" + joinDate + "]";
	}
	

}
