package com.yuni.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuni.service.MailSendService;

@Controller
public class EmailController {
	
	
	
	@Inject
	MailSendService service; 
	
	
	//@PostMapping(value="sendemail")
	@RequestMapping(value="sendmail")
	public void sendEmail()	{
		
		System.out.println("들어와라 ");
		random();
	}
	
	public String random () {
		String r="";
		for(int i=0 ; i<5; i++) {
			r+=(int)(Math.random()*9);
			
		}
		
		System.out.println(r);
		return r;

	}

}
