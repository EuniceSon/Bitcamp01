package com.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.model.EmployeeDAO;
import com.controller.model.EmployeeDTO;
import com.controller.model.MemberDAO;
import com.controller.model.MemberDTO;

public class RegEmployeeAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		

		// 회원가입 입력폼 창에서 넘어온 데이터 처리해 주자.
		int empno =Integer.parseUnsignedInt(request.getParameter("empno"));
		String ename =request.getParameter("ename");
		String job=request.getParameter("job");
		int mgr=Integer.parseUnsignedInt(request.getParameter("mgr"));
		String hiredate=request.getParameter("hiredate");
		int sal=Integer.parseUnsignedInt(request.getParameter("sal"));
		int comm=Integer.parseUnsignedInt(request.getParameter("comm"));
		int deptno=Integer.parseUnsignedInt(request.getParameter("deptno"));
		
		EmployeeDTO eDto = new EmployeeDTO();
		eDto.setEmpno(empno);
		eDto.setEname(ename);
		eDto.setJob(job);
		eDto.setMgr(mgr);
		eDto.setHiredate(hiredate);
		eDto.setSal(sal);
		eDto.setComm(comm);
		eDto.setDeptno(deptno);
		
		eDto.toString();
			
		EmployeeDAO eDao= new EmployeeDAO();
		int res =eDao.insertEmployee(eDto);
		if(res>0) {
			System.out.println("성공");
		}else {
			System.out.println("싫패");
		}
				
	}
}
