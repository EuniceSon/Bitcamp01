package com.yuni.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yuni.domain.MemberVO;
import com.yuni.persistence.MemberMapper;


//왜 interface 로 해야하는거... 의미가 없어 보이는데...?

@Service
public class JoinServiceImpl implements JoinService {
	
	@Inject
	private MemberMapper memberDao ;

	@Override
	public void register(MemberVO vo) {

		memberDao.insertMember(vo);
	}

	@Override
	public List<MemberVO> MemberListAll() throws Exception {
		return memberDao.listAll();
	}

	@Override
	public List<MemberVO> MemberListPage(int firstRow, int recordCountPerPage) throws Exception {
		
		return memberDao.listPage(firstRow, recordCountPerPage);
	}

	@Override
	public void modify(String oldName, String newName) {
		memberDao.updateMember(oldName, newName);
		
	}

	@Override
	public void delete(String memberId) {
		memberDao.deleteMember(memberId);
	}
	
	
	

}
