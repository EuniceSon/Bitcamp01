package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
//	@RequestMapping(value="/register" , method={RequestMethod.GET,RequestMethod.POST})
	
	//Model 클래스는 스프링 MVC에서 제공하는 데이터 전달용 객체라고 생각하면 됨
	//Model클래스는 Map 과 유사하게 키, 값 으로 데이터를 저장하는 역할을 함
	//과거 Servlet 에서 RequestDispatcher 데이터 저장 했듯이 스프링에서는 Model을 이용함 
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public void registerGET(BoardVO board, Model model)throws Exception{
		logger.info("register get.........");
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr)throws Exception{
		logger.info("register post.........");
		logger.info(board.toString());
		
		service.regist(board);
		
		//RedirectAttributes 은 리다이렉트 시점에 한번만 사용되는 데이터 전송할 수 있는
		// addFlashAttribute() 기능지원
		rttr.addAttribute("msg","SUCCESS");
		
		
		//새로고침했을 때 redirect 해서 도배 방지
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/listAll" , method=RequestMethod.GET)
	public void listAll(Model model) throws Exception{
		logger.info("show all list....................");
		
		model.addAttribute("list",service.listAll());
	}
	
	@RequestMapping(value="/read" , method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		logger.info("show all list....................");
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/readPage" , method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno,@ModelAttribute("cri")Criteria cri, Model model) throws Exception{
		//URI 'readPage'로 설정했기때문에 이메서드랑 연결됨 
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/remove" , method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno,RedirectAttributes rttr) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		logger.info("show all list....................");
		
		service.remove(bno);
		rttr.addAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/modify" , method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage" , method=RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("bno") int bno,@ModelAttribute("cri")Criteria cri,Model model) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage" , method=RequestMethod.POST)
	public String modifyPagingPOST(BoardVO board, Criteria cri,RedirectAttributes rttr) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		service.modify(board);
		rttr.addAttribute("page",cri.getPage());
		rttr.addAttribute("pagePageNum",cri.getPerPageNum());
		rttr.addAttribute("msg","SUCCESS");
		return "redirect:/board/listPage";
	}
	
	
	
	@RequestMapping(value="/modify" , method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		logger.info("mod post....................");
		
		service.modify(board);
		rttr.addAttribute("msg","SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listCri" , method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception{
		//RequestParam 은 Servlet에서 requestParameter()와 유사 
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	 @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	   public void listPage(@ModelAttribute("cri")Criteria cri, Model model) throws Exception {
	      logger.info(cri.toString());
	      
	      model.addAttribute("list", service.listCriteria(cri));
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCri(cri);
	      pageMaker.setTotalCount(131);
	      
	      pageMaker.setTotalCount(service.listCountCriteria(cri));
	      
	      model.addAttribute("pageMaker", pageMaker);
	   }
	 
		@RequestMapping(value="/removePage" , method=RequestMethod.POST)
		public String remove(@RequestParam("bno") int bno,Criteria cri,RedirectAttributes rttr) throws Exception{
			//RequestParam 은 Servlet에서 requestParameter()와 유사 
			
			logger.info("mod post....................");
			
			service.remove(bno);
			rttr.addAttribute("page",cri.getPage());
			rttr.addAttribute("pagePageNum",cri.getPerPageNum());
			rttr.addAttribute("msg","SUCCESS");
			return "redirect:/board/listPage";
		}
}
