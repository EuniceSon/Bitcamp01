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
	public ModelAndView getMemberList(HttpServletRequest rq, Model model) throws Exception {
		int page=1;
		List<MemberVO> list2= service.MemberListAll();
		if(rq.getParameter("page")!=null) {
			page= Integer.parseInt( rq.getParameter("page"));
		}
		
		
		PagingManager pm = new PagingManager(list2, page);
		
	
		ModelAndView mav= new ModelAndView();
		logger.info("show all list....................");		
		
		int firstRow = pm.getFirstRow()-1;
		int recordCountPerPage = pm.getRecordCountPerPage();
		
		System.out.println(pm.getFirstRow()+", "+pm.getRecordCountPerPage());
		List<MemberVO> list =  service.MemberListPage(firstRow, recordCountPerPage);
		mav.addObject("list", list);
		model.addAttribute("currentPage", pm.getCurrentPage());
		model.addAttribute("pageDivision", pm.getPageDivision());
		model.addAttribute("startBlock", pm.getStartBlock());
		model.addAttribute("endBlock", pm.getEndBlock());
		model.addAttribute("PageTotalCount", pm.getPageTotalCount());
		
		mav.setViewName("/member/list"); // /WEB-INF/view/hello.jsp
		return mav;
		
	}

	
}
