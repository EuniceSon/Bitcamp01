package com.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

import net.sf.json.JSONArray;

public class  ajaxAction implements Action {

	// 추상메서드
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json ;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO mdao = new MemberDAO();
		List<MemberDTO> list =  mdao.getMemberList();
		System.out.println(list);
		JSONArray jarr =JSONArray.fromObject(list);
		out.print(jarr);
		
		
		
		
		
		
		
	}
	
}
