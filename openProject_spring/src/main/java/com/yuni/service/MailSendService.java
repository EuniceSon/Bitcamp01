package com.yuni.service;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yuni.persistence.MemberMapperImpl;

@Service
public class MailSendService {
	
	
	@Inject
	private JavaMailSender javaMailSender;
	
	@Inject
	private MemberMapperImpl mapper;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void verifyCode (String memberId, String verifyCode)	{
		
		mapper.verifyCode(memberId, verifyCode);
		
	}
	
	public void mailFileSender(String to, String name) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper= new MimeMessageHelper(mimeMessage, true, "utf-8");
			helper.setSubject("[공지] 이번에는 선물용 파일을 보냅니다 ");
			String htmlContent="<h1>배고파 뭐먹어</h1><br>";
			
			helper.setText(htmlContent, true);
			helper.setTo(new InternetAddress(to, name,"utf-8"));
			
			DataSource datasource = (DataSource) new FileDataSource("C:\\hhh.jpg");
			
			helper.addAttachment(MimeUtility.encodeText("hhh.jpg","utf-8","b"), datasource);
			
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void mailSender(String to ) {
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			//제ㅂㅁ고
			message.setSubject("안녕하세요 고객님 핵 이득 드루와", "utf-8");
			//받는 이메일
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			
			String HtmlMsg = "<h1>배고파 뭐먹어</h1><br>"
					+ "<a href=\"https://store.naver.com/restaurants/detail?entry=plt&id=35727418&query=%ED%98%84%EC%84%A0%EC%9D%B4%EB%84%A4\">눌러봐</a>";
			
			message.setText(HtmlMsg,"utf-8","html");
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
//	
//	public void simpleMailSend(String to, String msg) {
//		
//		//메일 내용 설정 
//		SimpleMailMessage simpleMessage = new SimpleMailMessage();
//		simpleMessage.setSubject("[공지] 테스트 메일 발송 ");
//		simpleMessage.setText(msg); //매개변수로 받아서 처리 할 것
//		simpleMessage.setTo(to);
//		simpleMessage.setFrom("test@test.com");
//		
//		//메일 발송 
//		
//		mailSender.send(simpleMessage); //이걸 담어서 보낼거임 
//		
//	}
//	
}
