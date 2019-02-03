package com.controller.action;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;
import com.controller.model.PagingManager;

public class MemberListAction implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		MemberDAO mDao = new MemberDAO();
		List<MemberDTO> list = mDao.getMemberList();
		request.setAttribute("list", list);
		
//		System.out.println(list.size());
//		System.out.println(list.toString());
		List<MemberDTO> recordList =list;
//		Integer.parseInt(request.getParameter("page"))
		int currentPageNumber=1;
		if(request.getParameter("page")!=null) {
			currentPageNumber=Integer.parseInt(request.getParameter("page"));
		}
		int recordCountPerPage =5;
		int pageDivision=3;
		
		PagingManager page = new PagingManager(recordList, currentPageNumber, recordCountPerPage, pageDivision);
		
		System.out.println("      page.getStarBlock()    :    "+page.getStarBlock());
		System.out.println("       page.getEndBlock()    :    "+page.getEndBlock());
		System.out.println("       page.getFirstRow()    :    "+page.getFirstRow());
		System.out.println("         page.getEndRow()    :    "+page.getEndRow());
		System.out.println("page.getPageTotalCount()     :    "+page.getPageTotalCount());
		System.out.println("page.getRecordCountPerPage() :    "+page.getRecordCountPerPage());
		System.out.println(" page.getRecordTotalCount()  :    "+page.getRecordTotalCount());
		MemberDAO Dao= new MemberDAO();
		List<MemberDTO> list2 = Dao.getMemberList(page.getFirstRow(),page.getEndRow());
		request.setAttribute("nowPage", currentPageNumber);
		request.setAttribute("pageDivision", pageDivision);
		request.setAttribute("startBlock", page.getStarBlock());
		request.setAttribute("endBlock",page.getEndBlock());
		request.setAttribute("firstrow",page.getFirstRow());
		request.setAttribute("endrow", page.getEndRow());
		request.setAttribute("allPage", page.getPageTotalCount());
		request.setAttribute("totalRecord", page.getRecordTotalCount());
		request.setAttribute("list2", list2);
		System.out.println(list2.size());
		System.out.println(list2);
		return "/memberList/Memberlist2.jsp";
		
		
	}
}
