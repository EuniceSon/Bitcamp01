<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
      <h1>${memberVO.picture }</h1>
          <img src="../upload/c037ee8f-9818-4409-905e-8a9139a14c18_2.jpg" alt="">
      </div>
      <div class="mem_info">
        <div><strong>회원 번호</strong><span>: ${memberVO.memberNo }</span></div>
        <div><strong>회원 아이디</strong><span>: ${memberVO.memberId }</span></div>
        <div><strong>회원 이름</strong><span>: ${memberVO.memberName }</span></div>
          
      </div>
       
       
   </div>
    
</body>
</html>