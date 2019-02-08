package com.yuni.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yuni.domain.MemberVO;
import com.yuni.persistence.MemberDAO;


//왜 interface 로 해야하는거... 의미가 없어 보이는데...?

@Service
public class JoinServiceImpl implements JoinService {
	
	@Inject
	private MemberDAO memberDao ;

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
	
	

}
