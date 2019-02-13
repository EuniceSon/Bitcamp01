package com.yuni.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.yuni.domain.MemberVO;
import com.yuni.persistence.MemberMapper;

@Service
public class LoginServiceImpl implements LoginService {

		@Inject
		private MemberMapper memberDao;

		@Override
		public MemberVO login(MemberVO vo) throws Exception {
			System.out.println( vo.getMemberPwd());
			return memberDao.readWithPW(vo.getMemberId(), vo.getMemberPwd());
		}
		
		
	
}
