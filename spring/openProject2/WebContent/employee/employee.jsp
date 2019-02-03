<%@page import="com.controller.model.EmployeeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>사원리스트</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/memberList.css">
</head>
<jsp:include page="../top.jsp"></jsp:include>
<body>
	<div class="top">
		<div class="inner">
			<h2>사원 리스트</h2>
		</div>
	</div>
	<div class="container">
		<table>
			<tr class="Thead">
				<th>사원번호</th>
				<th>사원 이름</th>
				<th>직책</th>
				<th>매니저 번호</th>
				<th>입사일</th>
				<th>급여</th>
				<th>수수료</th>
				<th>부서번호</th>
			</tr>
			
			<c:forEach var="i" items="${list }">
				<tr>
					<td>${i.empno }</td>
					<td>${i.ename }</td>
					<td>${i.job }</td>
					<td>${i.mgr }</td>
					<td>${i.hiredate }</td>
					<td>${i.sal }</td>
					<td>${i.comm }</td>
					<td>${i.deptno }</td>
				</tr>
			</c:forEach>
			
		</table>
		<div style="width:950px;  background-color:pink">
			<div style="width:200px; margin:0 auto; background-color:pink">
				 <c:if test="${currentPage > pageDivision }">
	        	  	[<a href="<%=request.getContextPath() %>/EmployeeList.do?page=1">◀◀</a>]
	        	  	[<a href="<%=request.getContextPath() %>/EmployeeList.do?page=${currentPage-1 }">◀</a>]
	        	  </c:if>
	        	  
	        	  <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
	        	    <c:if test="${i == currentPage }">
	        	    	<u><b>[${i }]</b></u>
	        	    </c:if>
	        	    <c:if test="${!(i == currentPage) }">
	        	    	[<a href="<%=request.getContextPath() %>/EmployeeList.do?page=${i }">${i }</a>]
	        	    </c:if>
	        	  </c:forEach>
	        	  
	        	  <c:if test="${endBlock < PageTotalCount }">
	        	  	[<a href="<%=request.getContextPath() %>/EmployeeList.do?page=${currentPage+1 }">▶</a>]
	        	  	[<a href="<%=request.getContextPath() %>/EmployeeList.do?page=${PageTotalCount  }">▶▶</a>]
	        	  </c:if>
			</div>
		</div>

	</div>

</body>
</html>