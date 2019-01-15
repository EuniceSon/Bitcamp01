<%@page import="com.controller.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title id="title">Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

<% 
	String userID=null;
	if(session.getAttribute("memberDto")!=null){
		 userID= ((MemberDTO)session.getAttribute("memberDto")).getMemberId();
	}

%>


   <div class="header">
     <div class="top">
          <h1 class="logo"><a href="<%=request.getContextPath() %>/main.jsp">Open Project</a></h1>
      </div>
   </div>
    <div class="nav">
       <div class="nav_inner">
            <ul>
            
                <li><a href="${pageContext.request.contextPath}/join/join.jsp">회원가입</a></li>
                <%
		 		if(userID==null){  //로그인이 되있지 않은사람한테만 보임 
		 		%>
                <li><a href="<%=request.getContextPath() %>/login/login.jsp">회원로그인</a></li>
                
                <%} else{%>
                 <li><a href="<%-- <%=request.getContextPath() %>/login/logout.jsp --%>#" id="logout">로그아웃</a></li>
                <%} %>
                <li><a href="<%=request.getContextPath() %>/myPage/myPage.jsp" id="myPage">회원마이페이지(회원)</a></li>
                <li><a href="<%=request.getContextPath() %>/Memberlist.do" id="memberList">회원리스트(회원)</a></li>
                <li><a href="<%=request.getContextPath() %>/EmployeeList.do">사원리스트</a></li>
                <li><a href="<%=request.getContextPath() %>/employee/regEmployee.jsp">사원등록</a></li>
            </ul>
       </div>
    </div>  


</body>
<script>
	$('#myPage').click(function(){
		// #memberList
		if(<%=userID%>==null){
			alert('로그인을 해주시기 바랍니다.')
			console.log($(this).attr('href','<%=request.getContextPath() %>/login/login.jsp'))
		}
		
			
	})
	$('#logout').click(function(){
		
		if(confirm('로그아웃 하시겠습니까?')){
			$(this).attr('href','<%=request.getContextPath() %>/login/logout.jsp')
			
		}else{
			
		}
		
	})

</script>
</html>