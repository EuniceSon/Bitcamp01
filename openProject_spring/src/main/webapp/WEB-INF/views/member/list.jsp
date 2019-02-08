<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원리스트</title>
    <style>
    img {width:300px;}
	table {border-collapse:collapse;}
	td, th{border:1px solid black; padding:5px}
	.table2 {background-color:gray;}
	.td1 {text-align:center; background-color:black; color:white; font-size:30px; position:relative;}
	.td1 a {text-decoration:none; color:white; position: absolute; right:0; top:0; font-size: 20px;}
	 p{margin :5px 0;}
	.modiContainer {display:inline-block; position:absolute; top:30% ; left:40%; z-index:1; width:300px; display:none}
	.dimm			{ position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:0; display:none }
	.newName {width:97%; margin:0; padding:0; height:30px; }
    .new {margin:0; padding:0}
    </style>
    <link rel="stylesheet" href="resources/css/main.css">
    <link rel="stylesheet" href="resources/css/memberList.css">
    
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
       <table class="table1">
           <tr class="Thead">
               <th>회원번호</th>
               <th>회원 아이다(이메일)</th>
               <th>비밀번호</th>
               <th>회원 사진</th>
               <th>회원 이름</th>
               <th>회원가입일</th>
               <th>관리</th>
           </tr>
    
        		<c:forEach items="${list }" var="i" varStatus="status">
           
            <tr>
               <td>${i.no}</td>
               <td>${i.memberId }</td>
               <td>${i.memberPwd }</td>
               <td>${i.orgfileName}</td>
               <td>${i.memberName }</td>
               <td>${i.joinDate }</td>
               <td>
                   <a href="#" class="modiBtn">수정</a>
                   <a href="#">삭제</a>
               </td>
           </tr>

           	</c:forEach>
       </table>
		<div style="width:950px;  background-color:pink">
			<div style="width:200px; margin:0 auto; background-color:pink">
				 <c:if test="${currentPage > pageDivision }">
	        	  	[<a href="<%=request.getContextPath() %>/Memberlist?page=1">◀◀</a>]
	        	  	[<a href="<%=request.getContextPath() %>/Memberlist?page=${currentPage-1 }">◀</a>]
	        	  </c:if>
	        	  
	        	  <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
	        	    <c:if test="${i == currentPage }">
	        	    	<u><b>[${i }]</b></u>
	        	    </c:if>
	        	    <c:if test="${!(i == currentPage) }">
	        	    	[<a href="<%=request.getContextPath() %>/Memberlist?page=${i }">${i }</a>]
	        	    </c:if>
	        	  </c:forEach>
	        	  
	        	  <c:if test="${endBlock < PageTotalCount }">
	        	  	[<a href="<%=request.getContextPath() %>/Memberlist?page=${currentPage+1 }">▶</a>]
	        	  	[<a href="<%=request.getContextPath() %>/Memberlist?page=${PageTotalCount  }">▶▶</a>]
	        	  </c:if>
			</div>
		</div>
       
   </div>
   
    <div class="modiContainer">
       <div class="content" >
          
           
               <table class="table2">
               		<tr>
               			<td colspan=2 class="td1"><h3 style="margin:5px;">수정</h3><a href="#" class="closeBtn">닫기</a></td>
               		<tr>
           <!--          <tr>
                        <th>아이디(이메일)</th>
                        <td><input type="text" name="memberId"></td>
                    </tr>   
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="text" name="memberPwd"></td>
                    </tr>   --> 
                     <tr>
                        <th>기존 닉네임</th>
                        <td><p class="nick"></p></td>
                    </tr>  
                    <tr>
                        <th>닉네임 변경</th>
                        <td class="new"><input type="text" name="memberName" class="newName"></td>
                    </tr>   
                <!--     <tr>
                        <th>사진</th>
                        <td><input type="file" name="picture"></td>
                    </tr>  -->                  
                    <tr>
                        <th></th>
                        <td><input type="button" value="등록" class="sendBtn"></td>
                    </tr>
               </table>
          
       </div>
   </div>
     <script>
 //수정 버튼이 눌렸을때 
 		var Idval;
 		var newName ;
	$('body').on('click','.modiBtn',function(){
		$('.nick').text($(this).parent().parent().find('td:eq(4)').text())	
		$('.dimm').show()
		$('.modiContainer').show()
		
			Idval=$(this).parent().parent().find('td:eq(1)').text();
			newName =$('.newName').val();
			console.log($('.newName'))
		//수정 확인 버튼 눌렸을ㅐ
		
	})
	
		$('.sendBtn').click(function(){
			var newName =$('.newName').val();
			$('.modiContainer').hide()
			$('.dimm').hide()
			$.ajax({
				type:'get'
				,traditional:true
				,url:'http://localhost/openProject/ajaxModi.do'
				,dataType:'json'
				,contentType: 'application/json; charset=utf-8'
				,cache: false
				,data: {Id:Idval, newName:newName}
				,success:function(data){
				
					console.log(data)
						/* $('.Thead').siblings().empty(); */
						console.log("나의형제들");
						$('.Thead').siblings().remove();
					$.each(data, function(i, val){
					var index=++i
						console.log("이거 왜 안되냐 "+$('table1').find($('tr')))
						//console.log(i)
						$('.table1').find('tr').last().after('<tr><td>'+index+'<td class="'+val.memberId+'">'
						+val.memberId+'<td>'+val.memberPwd
						+'<td>'+val.picture+'<td>'+val.memberName+'<td>'
						+val.joinDate+'<td><a href="#" class="modiBtn">수정</a> <a href="#">삭제</a>');
							
							
					})
				},error:function(data){
					
					console.log('error')
					
				}
			})
			$('.modiContainer').hide();
			$('.dimm').hide();
		 
		})
	
	$('.closeBtn').click(function(){
		$('.modiContainer').hide()
		$('.dimm').hide()
	})
   
   </script>
    
</body>
</html>