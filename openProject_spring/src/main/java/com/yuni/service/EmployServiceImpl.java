package com.yuni.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.yuni.domain.EmployeeDTO;
import com.yuni.domain.MemberVO;
import com.yuni.persistence.EmployeeDAO;

@Service
public class EmployServiceImpl  implements EmployService{
	
	@Inject
	private SqlSession session;

	private EmployeeDAO dao;
	
	@Override
	public void register(EmployeeDTO dto) {
		dao= session.getMapper(EmployeeDAO.class);
		
	}

	@Override
	public List<EmployeeDTO> employListAll() throws Exception {
		dao= session.getMapper(EmployeeDAO.class);
		return dao.getEmployeeList();
	}

	@Override
	public List<EmployeeDTO> employListPage(int firstRow, int getRecordCountPerPage) throws Exception {
		dao= session.getMapper(EmployeeDAO.class);
		return dao.getEmployeeListPage(firstRow, getRecordCountPerPage);
	}


	
	
	
}
