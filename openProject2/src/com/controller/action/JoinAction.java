package com.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;
import com.oreilly.servlet.MultipartRequest;

public class JoinAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("되나");
		System.out.println(request.getParameter("memberId"));
		
//		getParameterNames()
		

		// 회원가입 입력폼 창에서 넘어온 데이터 처리해 주자.
//				String memberPwd= request.getParameter("memberPwd").trim();
//				String memberName= request.getParameter("memberName").trim();
//				String memberPic = request.getParameter("picture").trim();
//				String memberId = request.getParameter("memberId").trim();
//				System.out.println(memberId);
//				System.out.println(memberPic);
				
				
//				//업로드용 폴더 이름
//				String saveFolder= request.getServletContext().getRealPath("upload");
//				String encType="utf-8";
//				int max_size=5*1024*1024;
//				
//				try {
//					MultipartRequest multi = new MultipartRequest(request, saveFolder, max_size, encType );
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//						
//				
				
				
//				MemberDTO mDTO = new MemberDTO();
//				mDTO.setMemberId(memberId);
//				mDTO.setMemberPwd(memberPwd);
//				mDTO.setMemberName(memberName);
//				mDTO.setPicture(memberPic);
//				
//				MemberDAO dao = new MemberDAO();
//				int res = dao.insertMember(mDTO);
//				
//				
//				PrintWriter out;
//				try {
//					out = response.getWriter();
//					if(res > 0) {  // 공지글 삽입이 성공한 경우
//						out.println("<script>");
//						out.println("alert('회원가입  성공')");
//						out.println("location.href='joinForm.do'");
//						out.println("</script>");
//					}else {
//						out.println("<script>");
//						out.println("alert('회원가입 실패')");
//						out.println("history.back()");
//						out.println("</script>");
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
	}
}
