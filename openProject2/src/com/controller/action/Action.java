package com.controller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	// 추상메서드
	void execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
