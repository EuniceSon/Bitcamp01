package com.yuni.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailSenderController {
	
	@Inject
	private MailSendService service;
	
	
	@RequestMapping("/mail/filesend")
	public String fileSend() {
	      service.mailFileSender("sonyoon7@naver.com", "윤");
	      service.simpleMailSend("kjh4015@gmail.com", "종혀니");
	      service.simpleMailSend("cn3085@naver.com ", "태주야");
		return "mail/mailsend";
	}
	
	
	
	@RequestMapping("/mail/simplemailsend")
	public String simpleMailSend() {
	      service.simpleMailSend("kjh4015@gmail.com", "태주바보");
	      service.simpleMailSend("sonyoon7@gmail.com", "안녕하세요");
	      
	      
		
		return "mail/mailsend";
	}
	

	@RequestMapping("/mail/mailsend")
	public String mailsend() {
		
		service.mailSender("cn3085@naver.com");
		
		return "mail/mailsend";
	}
	
}
