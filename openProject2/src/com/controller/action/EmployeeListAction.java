package com.controller.action;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.EmployeeDAO;
import com.controller.model.EmployeeDTO;
import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

public class EmployeeListAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		EmployeeDAO eDao = new EmployeeDAO();
		

		List<EmployeeDTO> list = eDao.getEmployeeList();
		request.setAttribute("list", list);
		
		System.out.println(list.size());
		System.out.println(list.toString());
		
		
		
	}
}
