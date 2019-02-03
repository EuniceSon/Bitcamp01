package com.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.EmployeeDAO;
import com.controller.model.EmployeeDTO;

import com.controller.model.PagingManager;

public class EmployeeListAction implements Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		PrintWriter out = response.getWriter();
		EmployeeDAO eDao = new EmployeeDAO();
		

		List<EmployeeDTO> empList = eDao.getEmployeeList();
		
		

		
		int currentPageNumber =0;	// 기본 페이지 값
		
		if(request.getParameter("page") != null) {
			currentPageNumber = Integer.parseInt(request.getParameter("page"));
		}else {
			currentPageNumber = 1;     // 처음으로 게시판 페이지에 들어온 경우
		}
		
		//현재 페이지 요청에 따라 달라짐
		List<EmployeeDTO> recordList = empList;			// 처리할 데이터 리스트 
		int recordTotalCount =empList.size();							//전체 데이터 리스트.size 는 총 게시물의 수 
		int recordCountPerPage=4;							// 한 페이지당 뿌려줄 게시물 	
		int pageDivision = 3; // 아래에 보여질 페이지 최대 수 - 예) [1][2][3] / [4][5][6]
		
	
		PagingManager pm = new PagingManager(recordList, currentPageNumber, recordCountPerPage, pageDivision);
		
		pm.getPageTotalCount();
		pm.getEndRow();
		pm.getFirstRow();
		pm.getEndBlock();
		pm.getStarBlock();
		
		
		
		List<EmployeeDTO> list = eDao.getEmployeeList(pm.getFirstRow(), pm.getEndRow());
		request.setAttribute("list", list);
		System.out.println("currentPageNumber:   "+currentPageNumber);
		System.out.println("firRow:   "+pm.getFirstRow());
		System.out.println("endRow:   "+pm.getEndRow());
		System.out.println("recordTotalCount:   "+pm.getRecordTotalCount());
		System.out.println("PageTotalCount:   "+pm.getPageTotalCount());
		System.out.println("currentPageNumber:   "+currentPageNumber);
		System.out.println("StartBlock:   "+pm.getStarBlock());
		System.out.println("endBlock:   "+pm.getEndBlock());
		
	
		System.out.println("   db에서 가져온 갯수   "+list.size());
		System.out.println(list);
		
		request.setAttribute("currentPage", currentPageNumber);
		request.setAttribute("PageTotalCount", pm.getPageTotalCount());
		request.setAttribute("pageDivision", pageDivision);
		request.setAttribute("startBlock", pm.getStarBlock());
		request.setAttribute("endBlock", pm.getEndBlock());
		
		
		return "/employee/employee.jsp";
	}
}
