package com.controller.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class MemberDAO {
			Connection conn = null;
	public MemberDAO(){
		String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8"; // DB이름인 book_ex를 적절히 변경 
		   String DB_USER = "root";  // DB의 userid와 pwd를 알맞게 변경 
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
	
	
	public int insertMember(MemberDTO m) {
		 PreparedStatement pstmt = null;
//		 ResultSet rs = null;
		 String sql="insert into member(memberId, memberPwd, memberName, memberPic, originalPic) values(? ,? ,? ,?,? );";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 pstmt.setString(1, m.getMemberId());
			 pstmt.setString(2, m.getMemberPwd());
			 pstmt.setString(3, m.getMemberName());
			 pstmt.setString(4, m.getPicture());
			 pstmt.setString(5, m.getOrgfileName());
			 
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){} 
			if(conn != null) try{conn.close();}catch(SQLException e){}   
			
					
		}
		
		
		return-1;
	}
	
	public int idInvaildCheck (String memberId, String memberPwd) {
		
		 String sql="select memberId from member where memberId='"+memberId+"' and memberPwd='"+memberPwd+"'";
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try {
	
			 pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()) {
				 return 1;
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return -1;
		 
	}
	public int getMember_no (String memberId, String memberPwd) {

		 String sql="select no from member where memberId='"+memberId+"' and memberPwd='"+memberPwd+"'";
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 try {
	
			 pstmt = (PreparedStatement) conn.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 if(rs.next()) {
				 int no =rs.getInt(1);
				 return no;
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return -1;
		
	}
	public MemberDTO getMemberObj(String memberId, String memberPwd){
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="select * from member where memberId='"+memberId+"' and memberPwd='"+memberPwd+"'";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 //List<MemberDTO> list = new ArrayList<MemberDTO>();
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 MemberDTO mDto = new MemberDTO();
				 mDto.setMemberNo(rs.getInt(1));
				 mDto.setMemberId(rs.getString(2));
				 mDto.setMemberPwd(rs.getString(3));
				 mDto.setMemberName(rs.getString(4));
				 mDto.setPicture(rs.getString(5));
				 mDto.setJoinDate(rs.getString(6));
				 mDto.setOrgfileName(rs.getString(7));
				 //list.add(mDto);
				 
				 return mDto;
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){} 
					
		}
		return null;
		
		
	}
	public List<MemberDTO> getMemberList (){
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="select * from member";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 List<MemberDTO> list = new ArrayList<MemberDTO>();
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 MemberDTO mDto = new MemberDTO();
				 mDto.setMemberNo(rs.getInt("no"));
				 mDto.setMemberId(rs.getString("memberId"));
				 mDto.setMemberPwd(rs.getString("memberPwd"));
				 mDto.setMemberName(rs.getString("memberName"));
				 mDto.setPicture(rs.getString("memberPic"));
				 mDto.setJoinDate(rs.getString("joinDate"));
				 list.add(mDto);
				 
			 }
			 return list;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){} 
			if(conn != null) try{conn.close();}catch(SQLException e){}   

		}
		return null;
		
		
	}
	
	public List<MemberDTO> getMemberList (int firstRow, int endRow){
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="select a.* from (SELECT @ROWNUM := @ROWNUM + 1 AS ROWNUM, member.* FROM member, (SELECT @ROWNUM := 0) R)a where a.ROWNUM >= ? and a.ROWNUM< ?;";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 pstmt.setInt(1, firstRow);
			 pstmt.setInt(2, endRow);
			 List<MemberDTO> list = new ArrayList<MemberDTO>();
			 rs=pstmt.executeQuery();
			 while(rs.next()) {
				 MemberDTO mDto = new MemberDTO();
				 mDto.setMemberNo(rs.getInt("no"));
				 mDto.setMemberId(rs.getString("memberId"));
				 mDto.setMemberPwd(rs.getString("memberPwd"));
				 mDto.setMemberName(rs.getString("memberName"));
				 mDto.setPicture(rs.getString("memberPic"));
				 mDto.setJoinDate(rs.getString("joinDate"));
				 mDto.setOrgfileName(rs.getString("originalPic"));
				 list.add(mDto);
				 
			 }
			 return list;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){} 
			if(conn != null) try{conn.close();}catch(SQLException e){}   

		}
		return null;
		
		
	}
	public int updateMember (String id, String replaced) {
		
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 String sql="update member set memberName =? where memberId =?; ";
//		 String sql2 ="select * from member ;";
		 try {
			 
			 // 연결 된  conn 은 prepareStatement() 메소드를  가지고 있다
			 pstmt =(PreparedStatement)this.conn.prepareStatement(sql);
			 pstmt.setString(1, replaced);
			 pstmt.setString(2, id);
			 pstmt.executeUpdate();
//			 pstmt= (PreparedStatement) conn.prepareCall(sql2);
//			 List<MemberDTO> list = new ArrayList<MemberDTO>();
//			 rs=pstmt.executeQuery();
//			 while(rs.next()) {
//				 MemberDTO mDto = new MemberDTO();
//				 mDto.setMemberNo(rs.getInt("no"));
//				 mDto.setMemberId(rs.getString("memberId"));
//				 mDto.setMemberPwd(rs.getString("memberPwd"));
//				 mDto.setMemberName(rs.getString("memberName"));
//				 mDto.setPicture(rs.getString("memberPic"));
//				 mDto.setJoinDate(rs.getString("joinDate"));
//				 list.add(mDto);
				 
//			 }
			 return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){} 
			
					
		}
		
		
		return -1;
		
	}
	
	
	
   
}
