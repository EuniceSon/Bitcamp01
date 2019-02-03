package com.controller.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class EmployeeDAO {
//	public static void main(String[] args) {
//		
//		EmployeeDAO e = new EmployeeDAO();
//		EmployeeDTO eDto = new EmployeeDTO();
//		eDto.setEmpno(7782);
//		eDto.setEname("CLARK");
//		eDto.setJob("MANAGER");
//		eDto.setMgr(7839);
//		eDto.setHiredate("1981-6-9");
//		eDto.setSal(2450);
//		eDto.setComm(0);
//		eDto.setDeptno(10);
//		System.out.println(e.insertEmployee(eDto));
//		
//		
//	}

	Connection conn = null;

	public EmployeeDAO() {
		String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8"; // DB이름인 book_ex를
																										// 적절히 변경
		String DB_USER = "root"; // DB의 userid와 pwd를 알맞게 변경
		String DB_PASSWORD = "1234";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<EmployeeDTO> getEmployeeList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from emp";
		try {

			// 연결 된 conn 은 prepareStatement() 메소드를 가지고 있다
			pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				eDto.setEmpno(rs.getInt(1));
				eDto.setEname(rs.getString(2));
				eDto.setJob(rs.getString(3));
				eDto.setMgr(rs.getInt(4));
				eDto.setHiredate(rs.getString(5));
				eDto.setSal(rs.getInt(6));
				eDto.setComm(rs.getInt(7));
				eDto.setDeptno(rs.getInt(8));
		
				list.add(eDto);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}

		}
		return null;

	}
	
	public List<EmployeeDTO> getEmployeeList(int firstRow, int endRow) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select a.* from (SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, emp.* FROM emp, (SELECT @ROWNUM := 0) R)a where a.ROWNUM >= ? and a.ROWNUM< ?;";
		try {

			// 연결 된 conn 은 prepareStatement() 메소드를 가지고 있다
			pstmt = (PreparedStatement) this.conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				eDto.setEmpno(rs.getInt(2));
				eDto.setEname(rs.getString(3));
				eDto.setJob(rs.getString(4));
				eDto.setMgr(rs.getInt(5));
				eDto.setHiredate(rs.getString(6));
				eDto.setSal(rs.getInt(7));
				eDto.setComm(rs.getInt(8));
				eDto.setDeptno(rs.getInt(9));
		
				list.add(eDto);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}

		}
		return null;

	}
	
	public int insertEmployee(EmployeeDTO e) {
		 PreparedStatement pstmt = null;
//		 ResultSet rs = null;
		 String sql="insert into emp  values( ?, ?, ?, ?, DATE( ? ), ?, ?, ? )";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 pstmt.setInt(1, e.getEmpno());
			 pstmt.setString(2, e.getEname() );
			 pstmt.setString(3, e.getJob());
			 pstmt.setInt(4, e.getMgr());
			 pstmt.setString(5, e.getHiredate());
			 pstmt.setInt(6, e.getSal());
			 pstmt.setInt(7, e.getComm());
			 pstmt.setInt(8, e.getDeptno());
			 
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e2){} 
			if(conn != null) try{conn.close();}catch(SQLException e3){}   

		}

		return-1;
	}
	
	
}
