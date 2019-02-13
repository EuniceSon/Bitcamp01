package com.yuni.service;


import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuni.domain.MemberVO;
import com.yuni.persistence.MemberMapper;
import com.yuni.util.Aes256;

@Service
public class LoginServiceImpl implements LoginService {

		@Inject
		private MemberMapper memberDao;
		
		@Autowired
		private Aes256 aes256;
		

		@Override
		public MemberVO login(MemberVO vo) throws Exception {
			System.out.println( vo.getMemberPwd());
			vo.setMemberId(aes256.encrypt(vo.getMemberId()));
			vo.setMemberPwd(aes256.encrypt(vo.getMemberPwd()));
			System.out.println(vo.getMemberId());
		
			return memberDao.readWithPW(vo.getMemberId(), vo.getMemberPwd());
		}
		
		
	
}
