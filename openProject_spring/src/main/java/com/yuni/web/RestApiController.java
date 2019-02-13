package com.yuni.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuni.domain.MemberVO;
import com.yuni.service.JoinService;
import com.yuni.service.JoinServiceImpl;

@RestController
public class RestApiController {

	@Inject
	JoinService service;
	
	@GetMapping("/rest/msgs")
	public List<MemberVO> getMsg( //required 는  기본 true 임 반드시 필요 없으면 오류남, 없어도 상관없게 하려면 false
			
			) throws Exception {
		//PathVariable 은 경로를 따와서  변수 로 지장 하겠다
		//{} 중괄호 반드시 
		
		return service.MemberListAll();
	}
	
	
	@PutMapping("/rest/{no}")
	public MemberVO put (@PathVariable("no")int no,
						//@RequestParam("id")String memberId
			
			@RequestBody Map<String, Object>params
			) {
	
		if(no==1) {
			String id= (String) params.get("id");
			String newName= (String) params.get("newName");
			System.out.println("된다된다");
			System.out.println(params.get("id"));
			System.out.println(params.get("newName"));
			service.modify(id, newName);
		}
		
		return no+"";
		
	}
	
	
	
	
}
