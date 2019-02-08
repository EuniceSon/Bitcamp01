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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuni.domain.MemberVO;
import com.yuni.domain.PagingManager;
import com.yuni.service.JoinService;

@Controller
public class MemberListController {
	private static final Logger logger = LoggerFactory.getLogger(MemberListController.class);
	@Inject
	private JoinService service;
	
//	@RequestMapping(value="/Memberlist" , method=RequestMethod.GET)
//	public String memberListShow(Model model) throws Exception {
//		logger.info("show all list....................");
//		
//		service.MemberListAll(); 
//		model.addAttribute("list",service.MemberListAll());
//		
//		return "/member/view";
//	}
	
	@RequestMapping(value = "/Memberlist", method = RequestMethod.GET)
	public String getMemberList(HttpServletRequest rq, Model model) throws Exception {
		getMemberListPage(rq, model);
		
		return "/member/list";
		
	}
	@RequestMapping(value = "/ajaxModi" , method = RequestMethod.GET)
	public String modiMember (HttpServletRequest rq, Model model) throws Exception {
		String memberId= rq.getParameter("Id");
		String newName= rq.getParameter("newName");
		System.out.println(memberId);
		System.out.println(newName);
		service.modify(memberId, newName);
		getMemberListPage(rq, model);
		
		return "member/ajaxlist";
		/*
		 View에서 파라미터 값을 컨트롤러로 받아오는 방법중에 두가지 방법이 있는데,

		@RequestBody 어노테이션을 이용하여 가져오거나 HttpServletRequest 객체를 이용하여 가져오는 방법이 있다. 두가지 차이점이 있는데,
		@RequestBody -> POST 방식
		HttpServletRequest -> GET 방식
		 
		*/
	}
	
	@RequestMapping(value="/ajaxDel")
	public String delMember(HttpServletRequest rq, Model model) throws Exception {
		String memberId= rq.getParameter("Id");
		System.out.println("memberid......................................  "+memberId);
		
		service.delete(memberId);
		getMemberList(rq, model);
		
		return "member/ajaxlist";
	}
	
	
	public void getMemberListPage(HttpServletRequest rq, Model model) throws Exception {
		int page=1;
		List<MemberVO> list2= service.MemberListAll();
		if(rq.getParameter("page")!=null) {
			page= Integer.parseInt( rq.getParameter("page"));
		}
		PagingManager pm = new PagingManager(list2, page);
		
		logger.info("show all list....................");		
		int firstRow = pm.getFirstRow()-1;
		int recordCountPerPage = pm.getRecordCountPerPage();
		
		System.out.println(pm.getFirstRow()+", "+pm.getRecordCountPerPage());
		List<MemberVO> list =  service.MemberListPage(firstRow, recordCountPerPage);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", pm.getCurrentPage());
		model.addAttribute("pageDivision", pm.getPageDivision());
		model.addAttribute("startBlock", pm.getStartBlock());
		model.addAttribute("endBlock", pm.getEndBlock());
		model.addAttribute("PageTotalCount", pm.getPageTotalCount());
	}

	
}
