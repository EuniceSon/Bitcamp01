package com.yuni.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuni.domain.MemberVO;
import com.yuni.persistence.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	@Inject
	private MemberMapper dao;
	
	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}
	
//	@Test
//	public void testInsertMember() throws Exception {
//		MemberVO vo = new MemberVO();
//		vo.setMemberId("user00");
//		vo.setMemberPwd("user00");
//		vo.setMemberName("USER00");
//		
//		
//		dao.insertMember(vo);
//	}
	
//	@Test
//	public void testReadMember() throws Exception {
//		MemberVO vo = dao.readMember("user00");
//	}
//	
	@Test
	public void testReadWithPW() throws Exception {
		MemberVO vo = dao.readWithPW("yuni", "1010");
		System.out.println(vo.getMemberId());
		System.out.println(vo.getMemberPwd());
		System.out.println(vo.getMemberName());
	}
}
