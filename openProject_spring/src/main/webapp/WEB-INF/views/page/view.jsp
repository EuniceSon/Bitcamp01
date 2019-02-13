<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" href="../resources/css/base.css">
    <link rel="stylesheet" href="../resources/css/my.css">
    <link rel="stylesheet" href="../resources/css/main.css">
</head>
    <jsp:include page="../top.jsp"></jsp:include>
<body>
    <div class="top">
        <div class="inner">
            <h2>회원  마이페이지 </h2>
        </div>       
   </div>
   <div class="my">
      <div class="img">
      <h1>${memberVO.originalPic }</h1>
     	 <c:if test="${empty memberVO.originalPic }">
          <img src="../upload/7.jpg" alt="default">
          </c:if>
           <c:if test="${!empty memberVO.originalPic }">
           <img src="../upload/${memberVO.originalPic }" alt="">
           </c:if>
      </div>
      <div class="mem_info">
        <div><strong>회원 번호</strong><span>: ${memberVO.no }</span></div>
        <div><strong>회원 아이디</strong><span>: ${memberVO.memberId }</span></div>
        <div><strong>회원 이름</strong><span>: ${memberVO.memberName }</span></div>
          
          <div>
          	<a href="" class="verify">정회원 등록</a>
          </div>
		<form>
		<div class="hide">
			<input type ="text"><input class="click" type="submit" value="인증하기"> 	
		</div>
		</form>
		          
      </div>
       
       
   </div>
   
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <script>
   		$('.hide').hide();
   		$('.verify').on('click' , function(e){
   			e.preventDefault();
   			
   				$.ajax({
   					type:'post'
   					,traditional:true
   					,url:'/web/sendmail'
   					,contentType: 'text/html; charset=utf-8'
   					,cache: false
   					,data: {Id:'${memberVO.memberId }'}
   				})
   			
   			$(this).hide();
   			$('.hide').show();
   			
   			
   		})
   
   
   
   </script>
    
</body>
</html>