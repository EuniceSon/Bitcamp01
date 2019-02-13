package com.yuni.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuni.domain.MemberVO;
import com.yuni.service.JoinServiceImpl;

@RestController
public class RestApiController {

	@Inject
	JoinServiceImpl service;
	
	@GetMapping("/rest/msgs")
	public List<MemberVO> getMsg( //required 는  기본 true 임 반드시 필요 없으면 오류남, 없어도 상관없게 하려면 false
			
			) throws Exception {
		//PathVariable 은 경로를 따와서  변수 로 지장 하겠다
		//{} 중괄호 반드시 
		
		return service.MemberListAll();
	}
	
	
	
}
