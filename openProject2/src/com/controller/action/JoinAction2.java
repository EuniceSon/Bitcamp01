package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinAction2 implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = request.getSession().getServletContext(); //어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. 
		String saveDir = context.getRealPath("upload"); //절대경로를 가져옴
		System.out.println("절대경로 >> " + saveDir);
		int maxsize = 3*1024*1024; // 3MB
		String encoding = "utf-8";


		//ServletFileUploadisMultipartContent(request)를 사용하면 boolean 타입으로 넘어오는 Form태그의 전송방식을 확인할 수 있다 

		boolean isMulti = ServletFileUpload.isMultipartContent(request);// boolean타입. ??????
		if (isMulti) {
		    MultipartRequest multi = new MultipartRequest(
		    		request,
		    		saveDir,// 파일을 저장할 디렉토리 지정
		    		maxsize,// 첨부파일 최대 용량 설정(bite) / 3MB / 용량 초과 시 예외 발생
		    		encoding,// 인코딩 방식 지정
		    		new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
		    		);
		    String memberId = multi.getParameter("memberId");  //form 에서 넘어온 데이터 받기 
		    String memberPwd = multi.getParameter("memberPwd");
		    String memberName = multi.getParameter("memberName");
		    String memberPic = multi.getFilesystemName("file"); //file 형식으로 넘어왔을때  중복 제거된 파일 명 
		    String orgfileName = multi.getOriginalFileName("file"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)

		    System.out.println(memberId+",   "+memberPwd+",   "+memberName+",   "+memberPic+",  "+orgfileName);
		    
			MemberDTO mDTO = new MemberDTO();
			mDTO.setMemberId(memberId);
			mDTO.setMemberPwd(memberPwd);
			mDTO.setMemberName(memberName);
			mDTO.setPicture(memberPic);
			mDTO.setOrgfileName(orgfileName);
			
			MemberDAO dao = new MemberDAO();
			int res = dao.insertMember(mDTO);
			if(res>0) {
				System.out.println("회원가입 성공 ");
			}
			
			request.setAttribute("joinSuc", res);
	
		} else {
		    System.out.println("일반 전송 Form입니다");
		}



				return "/main.jsp";
	}

}
