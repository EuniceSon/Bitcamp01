package com.controller.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;


//@WebServlet(urlPatterns = "*.do") // .do라고 찍혀서 넘어오는 페이지 요청은 다 컨트롤러가 받아서 처리 해줌

public class FrontController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
	// <커맨드, 핸들러인스턴스> 매핑 정보 저장
	private Map commandHandlerMap = new java.util.HashMap();

	public void init(ServletConfig config) throws ServletException {
		// 초기화 시켜 줄 때    
		
		
		String configFile = config.getInitParameter("configFile");// 설정 파일의 위치
		Properties prop = new Properties();
		// 해쉬 맵의 옛날 버전이 해쉬 테이블 이다 -> 해쉬테이블을 변형시킨게 properties (key/value 모두 String 이어야 함 )
		FileInputStream fis = null;
		//buffer 는 100mb 이상일때 써주면 됨 
		try {
			String configFilePath = config.getServletContext().getRealPath(configFile); // 시스템의 절대 경로 가져옴
			System.out.println("절대 경로  : "+configFilePath);
			
			fis = new FileInputStream(configFilePath);
			prop.load(fis); // 파일 읽어서 property 객체로 변환
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		Iterator keyIter = prop.keySet().iterator(); // proerty는 순서없는 집합이라 줄세우려면 iterator써야 함
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next(); //command 에 key 값이 하나씩 담기면서 반복됨  
			String handlerClassName = prop.getProperty(command); //value 값 
			try {
				Class handlerClass = Class.forName(handlerClassName);//클래스 객체 메모리에 로드
				Object handlerInstance = handlerClass.newInstance(); //인스턴스 객체 생성
				commandHandlerMap.put(command, handlerInstance);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}
// -------------------------------------------------------------------------------------------------
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

//		// 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI();

		// getContextPath() : 현재 프로젝트명을 반환하는 메서드.
		String path = request.getContextPath();

		// command 문자열 변수에는 *.do
		String command = uri.substring(path.length() + 1);
		System.out.println("command ==> " + command);
		

		
		Action handler =  (Action) commandHandlerMap.get(command);  //command 키에 해당하는 값(객체)를 담아줌 
		
		
		
		if (handler == null) {
			//handler = new NullHandler(); 에러처리 해주면 됨 
		}
		String viewPage = null;
		try {
			viewPage = handler.execute(request, response);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
