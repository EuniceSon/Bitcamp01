package com.controller.action;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

public class MemberListAction implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		MemberDAO mDao = new MemberDAO();
		List<MemberDTO> list = mDao.getMemberList();
		request.setAttribute("list", list);
		
//		System.out.println(list.size());
//		System.out.println(list.toString());
		
		return "/memberList/Memberlist2.jsp";
		
		
	}
}
