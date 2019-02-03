package com.controller.model;

/**
 * @author sonyo
 *
 */
public class MemberDTO {
	int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String Picture;
	private String joinDate;
	private String orgfileName;



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


	public MemberDTO(int memberNo, String memberId, String memberPwd, String memberName, String picture,
			String joinDate, String orgfileName) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		Picture = picture;
		this.joinDate = joinDate;
		this.orgfileName = orgfileName;
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
	public String getOrgfileName() {
		return orgfileName;
	}


	public void setOrgfileName(String orgfileName) {
		this.orgfileName = orgfileName;
	}


	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
				+ ", memberName=" + memberName + ", Picture=" + Picture + ", joinDate=" + joinDate + ", orgfileName="
				+ orgfileName + "]";
	}




}
