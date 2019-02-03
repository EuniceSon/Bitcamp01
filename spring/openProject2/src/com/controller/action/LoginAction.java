package com.controller.action;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

public class LoginAction implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//가입 입력폼 창에서 넘어온 데이터 처리해 주자.
		String memberId = request.getParameter("memberId").trim();
		String memberPwd= request.getParameter("memberPwd").trim();
		
		//DB에서 memberId 랑 memberPwd있는지 보기 
		MemberDAO mDao = new MemberDAO();
		MemberDTO mDto= mDao.getMemberObj(memberId, memberPwd);

		int result =mDao.idInvaildCheck(memberId, memberPwd);
		System.out.println("result    :   "+ result);
	
		PrintWriter out = response.getWriter();
		if(result>0) {
			//성공하면 session 생성 
			
			HttpSession session=  request.getSession();
			session.setAttribute("memberDto", mDto);
	
		}else {
			
		}
		
		request.setAttribute("result", result );
		
		
		return "/main.jsp";
	}
}
