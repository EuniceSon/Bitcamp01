<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
   
</head>
<jsp:include page="top.jsp"></jsp:include>
<body>
    <% 
    	if(request.getAttribute("result")!=null){
    	int res= (int)request.getAttribute("result");
    		if(res>0){
    %>
    	
    	 <script>alert('로그인에 성공 하셨습니다 ')</script>
    <%
    		}else{
    %>
    	<script>
    		alert('로그인에 실패 하셨습니다 ')
    		location.href='${pageContext.request.contextPath}/main.jsp'
    		
    	</script>
    <%
    		}
    	
    	}
    %>
    <div style="width:1250px; margin:0 auto; background-color: pink; height:600px;">
    	
    	<h1>메인페이지</h1>
    </div>
 	
</body>
<script>

	
</script>
</html>