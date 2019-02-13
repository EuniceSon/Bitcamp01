package com.yuni.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuni.domain.EmployeeDTO;

public interface EmployeeMapper {
	
	public List<EmployeeDTO> getEmployeeList();
	public List<EmployeeDTO> getEmployeeListPage(@Param("firstRow") int firstRow,@Param("getRecordCountPerPage") int getRecordCountPerPage);
	public int insertEmployee(EmployeeDTO e);

	
}
