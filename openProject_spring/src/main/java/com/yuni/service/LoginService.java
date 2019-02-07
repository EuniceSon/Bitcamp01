package com.yuni.service;


import com.yuni.domain.MemberVO;

public interface LoginService {

	public MemberVO login(MemberVO vo) throws Exception;
	
}
