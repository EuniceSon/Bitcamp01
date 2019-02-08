package com.yuni.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yuni.domain.MemberVO;
import com.yuni.service.JoinService;

@Controller
public class JoinController {
	
	@Inject
	private JoinService service;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView goToMain() {
		
		ModelAndView mav= new ModelAndView();
		logger.info("main 으로 이동............");
		
		
		mav.setViewName("main"); // /WEB-INF/view/hello.jsp
		mav.addObject("id", "cool");
		return mav;
		
	}
	@RequestMapping(value="/join/joinForm" , method=RequestMethod.GET)
	public void registerGET( Model model)throws Exception{
		logger.info("register get.........");
	}

	@RequestMapping(value="/join/joinForm" , method=RequestMethod.POST)
	public ModelAndView registPOST(HttpServletRequest request, MultipartFile file, Model model, MemberVO vo) throws IOException, Exception {
	
		if(!file.isEmpty()) {
			logger.info("================================================");
			logger.info("getName: "+file.getName());
			logger.info("originalName: "+file.getOriginalFilename());
			logger.info("getSize(): "+file.getSize());
			logger.info("getContentType(): "+file.getContentType());
			logger.info("================================================");
			
			logger.info(" before "+vo.getOrgfileName());
			vo.setOrgfileName(file.getOriginalFilename());
			logger.info(" after "+vo.getOrgfileName());
			
			String uri = "/upload";
			String dir=request.getSession().getServletContext().getRealPath(uri); //절대경로 
			String fileName=file.getOriginalFilename();  //실제 파일 이름
			String savedName=uploadFile(dir, fileName, file.getBytes());
			vo.setPicture(savedName);
			logger.info(dir);
//			model.addAttribute("savedName",savedName);
	      }
		service.register(vo);
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/main");
		return mav;
		
	}
	
	private String uploadFile(String dir,String originalName, byte[] fileDate)throws Exception{
		UUID uid=UUID.randomUUID();
		String savedName= uid.toString()+"_"+originalName;
		
		File target= new File(dir, savedName); //경로, 이름 
		FileCopyUtils.copy(fileDate, target);
		return savedName;
		
//		1. 디렉토리 생성
//		File dir = new File("디렉토리의 경로");
//		2. 부모 디렉토리를 파라미터로 인스턴스 생성
//		File newFile = new File(dir,"파일명");


		
	}
	

	
//	@RequestMapping(value="/myPage/myPageView" , method=RequestMethod.GET)
//	public ModelAndView mypage(HttpServletRequest rq, HttpSession session, RedirectAttributes rttr)throws Exception{
//		if(rq!=null) {
//			
//			session =rq.getSession(false); //있으면 받고 없으면 생성하지 마 
//			if(session!=null) {
//				MemberVO vo=(MemberVO) session.getAttribute("memberVO");
//				
//				logger.info("session 있는가 "+vo.getMemberId());
//			}
//			
//		}
//		logger.info("mypage get.........");
//		ModelAndView mav= new ModelAndView();
//		mav.setViewName("redirect:/myPage/myPage");
//		return mav;
//	}
	
	@RequestMapping(value = "/myPage/myPageView", method = RequestMethod.GET)
	public ModelAndView mypage(HttpServletRequest rq, HttpSession session) throws Exception {
		
		if(rq!=null) {
			
			session =rq.getSession(false); //있으면 받고 없으면 생성하지 마 
			if(session!=null) {
				MemberVO vo=(MemberVO) session.getAttribute("memberVO");
				
				logger.info("session 있는가 "+vo.getMemberId());
			}
			
		}
		
		ModelAndView mav= new ModelAndView();
		logger.info("myPage............넘어가라잉........");		
		
		//mav.addObject("list",service.MemberListAll());
		mav.setViewName("/page/view"); // /WEB-INF/view/hello.jsp
		return mav;
		
	
	}

}
