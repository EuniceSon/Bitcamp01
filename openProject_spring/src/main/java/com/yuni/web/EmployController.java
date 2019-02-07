package com.yuni.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuni.domain.EmployeeDTO;
import com.yuni.domain.PagingManager;
import com.yuni.service.EmployServiceImpl;

@Controller
public class EmployController {
	private static final Logger logger = LoggerFactory.getLogger(EmployController.class);
	@Inject
	EmployServiceImpl service;
	
	@RequestMapping(value="/EmployeeList", method=RequestMethod.GET)
	public String EmployList (HttpServletRequest rq, Model model) throws Exception	{
		int page=1;
		if(rq.getParameter("page")!=null) {
		page = Integer.parseInt(rq.getParameter("page"));
		}
		
		List<EmployeeDTO>list2= service.employListAll();
		System.out.println(list2);
		System.out.println(page);
		
		PagingManager pm = new PagingManager(list2, page);
		System.out.println(pm.getFirstRow()-1 +" . "+pm.getRecordCountPerPage());
		//pm.setRecordList(recordList);
		//pm.setCurrentPage(currentPage);
		List<EmployeeDTO>list= service.employListPage(pm.getFirstRow()-1, pm.getRecordCountPerPage());
		
		model.addAttribute("list", list);
		model.addAttribute("currentPage", pm.getCurrentPage());
		model.addAttribute("pageDivision", pm.getPageDivision());
		model.addAttribute("startBlock", pm.getStartBlock());
		model.addAttribute("endBlock", pm.getEndBlock());
		model.addAttribute("PageTotalCount", pm.getPageTotalCount());
		
		return "employee/employee";
		
	}

}
