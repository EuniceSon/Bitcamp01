package com.yuni.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuni.domain.MemberVO;

public interface MemberMapper {
	public String getTime(); // DB의 현재 시간을 확인한다.
	
	public void insertMember(MemberVO vo); // DB의 tbl_member 테이블에 데이터를 추가한다.
	public void deleteMember(String memberId);
	
	
	public MemberVO readWithPW(String memberId, String memberPwd) throws Exception;
	
	public List<MemberVO> listAll() throws Exception;
	public List<MemberVO> listPage(@Param("firstRow") int firstRow,@Param("recordCountPerPage")int getRecordCountPerPage);

	public void updateMember (String oldName, String newName) ;
	public MemberVO correctCode(String memberId, String verifyCode) throws Exception;
	public void verifyCode(String memberId, String verifyCode);
	
}
