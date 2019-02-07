package com.yuni.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yuni.domain.MemberVO;
import com.yuni.service.LoginService;


@Controller
@RequestMapping("/login/*")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private LoginService service;
	
	
	@RequestMapping(value="/loginForm", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("vo")MemberVO vo) {
		//@ModelAttribute 는 submit form 내용 전장해서 전달 받거나 다시 view로 넘겨서 출력하기 위해 사용 되는 Object 이다 
		
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("/login/loginForm");
	}
	
	@RequestMapping(value="/loginForm", method=RequestMethod.POST)
	public ModelAndView loginPOST(MemberVO vo, HttpServletRequest rq,
			HttpSession session, Model model)throws Exception {
		
		
		MemberVO vo2 = service.login(vo);
		
		if(vo2!=null) { //회원가입이 되었으면
			//세션 생성 
			session=rq.getSession();
			session.setAttribute("memberVO", vo2);
			
		}
		
		logger.info(vo.getMemberId());  //받아오고
		
		//model.addAttribute("memberVO", vo2);  // 넘겨 주기 
		
		ModelAndView mav= new ModelAndView();
		
		logger.info(vo2.getMemberName());  //dao 결과값 받아오는거 확인 할 수 있음 
		mav.setViewName("redirect:/main");
		
		return mav;
		
		
	}
	
	
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public void logout(HttpServletRequest rq, 
//			HttpSession session) {
//		//@ModelAttribute 는 submit form 내용 전장해서 전달 받거나 다시 view로 넘겨서 출력하기 위해 사용 되는 Object 이다 
//		session=rq.getSession();
//		session.invalidate();
//		ModelAndView mav= new ModelAndView();
//		
//		mav.setViewName("redirect:/loginForm");
//	}
	
	  @RequestMapping(value="/logout")
	    public String logout(HttpSession session) {
	        session.invalidate(); // 세션 전체를 날려버림
//	      session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
	        return "redirect:/login/loginForm"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	    }


	
	
}
