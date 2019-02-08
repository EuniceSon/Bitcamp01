package com.yuni.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuni.domain.MemberVO;

public interface MemberDAO {
	public String getTime(); // DB의 현재 시간을 확인한다.
	
	public void insertMember(MemberVO vo); // DB의 tbl_member 테이블에 데이터를 추가한다.
	public void deleteMember(String memberId);
	
	public MemberVO readMember(String memberId) throws Exception;
	
	public MemberVO readWithPW(String memberId, String memberPwd) throws Exception;
	
	public List<MemberVO> listAll() throws Exception;
	public List<MemberVO> listPage(@Param("firstRow") int firstRow,@Param("recordCountPerPage")int getRecordCountPerPage);

	public void updateMember (String oldName, String newName) ;
}
