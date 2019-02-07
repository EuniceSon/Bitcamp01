<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title id="title">Document</title>
    
    resources/css/main.css  와 /resources/css/main.css 의 차이! 
      
</head>
<body>

 -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <div class="header">
     <div class="top">
          <h1 class="logo"><a href="<%=request.getContextPath() %>/main">Open Project</a></h1>
      </div>
   </div>
    <div class="nav">
       <div class="nav_inner">
            <ul>
            
                <li><a href="${pageContext.request.contextPath}/join/joinForm">회원가입</a></li>
                <c:if test="${ empty memberVO }">
                <li><a href="<%=request.getContextPath() %>/login/loginForm">회원로그인</a></li>
                </c:if>
               
               <c:if test="${ !empty memberVO }">
                 <li><a href="<%-- <%=request.getContextPath() %>/login/logout --%>#" id="logout">로그아웃</a></li>
           		</c:if>
                <li><a href="<%=request.getContextPath() %>/myPage/myPageView" id="myPage">회원마이페이지(회원)</a></li>
                <li><a href="<%=request.getContextPath() %>/Memberlist" id="memberList">회원리스트(회원)</a></li>
                <li><a href="<%=request.getContextPath() %>/EmployeeList">사원리스트</a></li>
                <li><a href="<%=request.getContextPath() %>/employee/regEmployee">사원등록</a></li>
            </ul>
       </div>
    </div>  


<!-- </body> -->
<script>
	<%--  $('#myPage').click(function(){
		// #memberList
		if(<%=userID%>==null){
			alert('로그인을 해주시기 바랍니다.')
			console.log($(this).attr('href','<%=request.getContextPath() %>/login/login.jsp'))
		}
		
			
	}) --%>
	$('#logout').click(function(){
		
		if(confirm('로그아웃 하시겠습니까?')){
			$(this).attr('href','<%=request.getContextPath() %>/login/logout')
			
		}else{
			
		}
	})

</script>
<!-- </html> -->