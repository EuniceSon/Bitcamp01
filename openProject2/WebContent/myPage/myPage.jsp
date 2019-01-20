<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/my.css">
    <link rel="stylesheet" href="../css/main.css">
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
      <h1>${memberDto.picture }</h1>
          <img src="../upload/${memberDto.picture }" alt="">
      </div>
      <div class="mem_info">
        <div><strong>회원 번호</strong><span>: ${memberDto.memberNo }</span></div>
        <div><strong>회원 아이디</strong><span>: ${memberDto.memberId }</span></div>
        <div><strong>회원 이름</strong><span>: ${memberDto.memberName }</span></div>
          
      </div>
       
       
   </div>
    
</body>
</html>