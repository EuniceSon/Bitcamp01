<%@page import="com.controller.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원리스트</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberList.css">
</head>
 <jsp:include page="../top.jsp"></jsp:include>
<body>
 <div class="dimm"></div>
    <div class="top">
        <div class="inner">
            <h2> 회원 리스트 </h2>
        </div>       
   </div>
   <div class="container">
       <table>
           <tr class="Thead">
               <th>회원번호</th>
               <th>회원 아이다(이메일)</th>
               <th>비밀번호</th>
               <th>회원 사진</th>
               <th>회원 이름</th>
               <th>회원가입일</th>
               <th>관리</th>
           </tr>
           <% 
           ArrayList list = ((ArrayList)request.getAttribute("list"));
           
           for(int i=0; i<list.size(); i++){
        	MemberDTO mdto=(MemberDTO)list.get(i);
        	  
        	%>
           
            <tr >
               <td><%= mdto.getMemberNo() %></td>
               <td><%= mdto.getMemberId() %></td>
               <td><%= mdto.getMemberPwd() %></td>
               <td><%= mdto.getPicture() %></td>
               <td><%= mdto.getMemberName() %></td>
               <td><%= mdto.getJoinDate() %></td>
               <td>
                   <a href="modiBtn">수정</a>
                   <a href="#">삭제</a>
               </td>
           </tr>
           <% }%>
       </table>
       
   </div>
   
 
    
</body>
</html>