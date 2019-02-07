package com.yuni.service;

import java.util.List;

import com.yuni.domain.EmployeeDTO;
import com.yuni.domain.MemberVO;

public interface EmployService {
	
	
	public void register (EmployeeDTO dto);
	public List<EmployeeDTO> employListAll()throws Exception;
	public List<EmployeeDTO> employListPage(int firstRow, int endRow)throws Exception;
}
