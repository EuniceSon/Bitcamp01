package com.yuni.web;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuni.util.Aes256;
import com.yuni.util.Sha256;

@Controller
@RequestMapping("member/login")
public class SecurityTestController {
	
	@Autowired
	private Sha256 sha256;
	
	@Autowired
	private Aes256 aes256;
	
	
	@GetMapping
	public String form() {
		return "member/form";
	}
	
	@PostMapping
	public String login(
			@RequestParam("id") String id,
			@RequestParam("pwd") String pw
			) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		System.out.println("암호화 전 데이터 ==> " + id + ":" + pw);
		
		System.out.println("=================================");
		System.out.println("암호화 된 id : " + sha256.encrypt(id));
		System.out.println("암호화 된 pw : " + sha256.encrypt(pw));
		System.out.println("=================================");

		String encId = aes256.encrypt(id); 
		String encPw = aes256.encrypt(pw);
		System.out.println("aes256 함호화 id : " + encId);
		System.out.println("aes256 함호화 pw : " + encPw);
		System.out.println("=================================");
		System.out.println("aes256 복호화 encid : " + aes256.decrypt(encId));
		System.out.println("aes256 복호화 encpw : " + aes256.decrypt(encPw));
		
		return "member/login";
	}
	
	
	
	
	
	
	
	
	
}

