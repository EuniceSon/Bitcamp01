package com.yuni.web;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.yuni.domain.MemberVO;
import com.yuni.service.JoinService;

@Controller
public class DownloadController  implements ApplicationContextAware{
	@Inject
	private JoinService service;
	private WebApplicationContext context; 
	
	
	@RequestMapping("download/memberlistPDF")
	public ModelAndView getRanksPdf() throws Exception {
		System.out.println("매핑 됬나요?");
		List<MemberVO> list =service.MemberListAll();
		System.out.println(list);
		return new ModelAndView("memberlistPDF","memberlistPDF", list);
	}
	
	@RequestMapping("download/memberlistXls")
	public ModelAndView getRanksXls() throws Exception {
		System.out.println("매핑 됬나요?");
		List<MemberVO> list =service.MemberListAll();
		System.out.println(list);
		return new ModelAndView("memberlistXls","memberlistXls", list);
	}
	
	
	@RequestMapping("download/file")
	public ModelAndView download() {
		
		System.out.println("매핑 됬나요?");
		
		File file =getFile();
		
							//viewName, modelName, modelObject
		return new ModelAndView("download", "downloadFile", file);
								//커스텀뷰 이름 , 전달데이터 식별이름, 
								//객체 만들어야 함
		
	}

	private File getFile() {
		String path= context.getServletContext().getRealPath("/WEB-INF/notice.txt");
		
		return new File(path);  
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = (WebApplicationContext) applicationContext;
		
		
		
	}

}
