<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    
</head>
<body>
 <jsp:include page="../top.jsp"></jsp:include>
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
				,url:'ajaxModi'
				,dataType:'html'
				,contentType: 'text/html; charset=utf-8'
				,cache: false
				,data: {Id:Idval, newName:newName}
				,success:function(data){
				
					console.log(data)
						/* $('.Thead').siblings().empty(); */
						console.log("나의형제들");
						$('body').empty();
						$('body').append(data)

				},error:function(data){
					
					console.log('error')
					
				}
			})
			$('.modiContainer').hide();
			$('.dimm').hide();
		 
		})
	$('.delBtn').click(function(){
		
		var Idval=$(this).parent().siblings().eq(1).text();
		console.log(Idval)
		 if(confirm('삭제 하시겠습니까?')){
			$.ajax({
				type:'get'
				,traditional:true
				,url:'ajaxDel'
				,dataType:'html'
				,contentType: 'text/html; charset=utf-8'
				,cache: false
				,data: {Id:Idval}
				,success:function(data){

					$('body').empty();
					$('body').append(data)
				
					
				},error:function(data){
					
					console.log('error')
					
				}
			})
			
			
			
			console.log('예스')
		}else{
			console.log('노')
		} 
	})
		
	$('.closeBtn').click(function(){
		$('.modiContainer').hide()
		$('.dimm').hide()
	})
   
   </script>
    
</body>
</html>