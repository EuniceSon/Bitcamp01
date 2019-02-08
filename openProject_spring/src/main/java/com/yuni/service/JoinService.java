package com.yuni.service;

import java.util.List;


import com.yuni.domain.MemberVO;

public interface JoinService {
	public void register (MemberVO vo);
	public void modify (String oldName, String newName);
	public void delete (String memberId);
	public List<MemberVO> MemberListAll()throws Exception;
	public List<MemberVO> MemberListPage(int firstRow, int recordCountPerPage)throws Exception;
}
