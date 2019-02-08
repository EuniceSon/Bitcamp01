<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
 <link rel="stylesheet" href="resources/css/main.css" type="text/css" >
 
</head>
<jsp:include page="./top.jsp"></jsp:include>
<body>

    <div style="width:1220px; margin:0 auto; background-color: pink; height:600px;">
    	
    	<h1>메인페이지</h1>
    	<h1>${vo.key1 }</h1>
    	<!-- param. 변수명    <-  변수명만쓰면 안먹힘  -->
    	<h1>${param.testParameter}</h1>
    	<h1>${memberVO.memberId }</h1>
    	<img alt="" src="upload/${param.savedName }">
    </div>
 	
</body>

</html>