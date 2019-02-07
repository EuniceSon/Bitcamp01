package com.yuni.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	private static final Logger logger=
			LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("doC") // 특정 URI 에 매칭되는 클래스나 메소드임을 명시하는 애노테이션
	public String doC( @ModelAttribute("msg") String msg) {
						//자동으로 해당 객체를 뷰까지 전달하도록 만드는 애노테이션  메소드, 파라미터로 사용 함 
		logger.info("doB called.........");
		
		return "result"; // doC 메소드값으로 사용된 result 는 결과적으로 /WEB-INF/views/result.jsp 파일을 찾아서 실행 함 
	}

}
