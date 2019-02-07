package com.yuni.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView getMemberList() throws Exception {
		
		ModelAndView mav= new ModelAndView();
		logger.info("show all list....................");		
		
		mav.addObject("list",service.MemberListAll());
		mav.setViewName("/member/list"); // /WEB-INF/view/hello.jsp
		return mav;
		
	}

	
}
