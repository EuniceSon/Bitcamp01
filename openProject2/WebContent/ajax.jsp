<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img {width:300px;}
	table {border-collapse:collapse;}
	td, th{border:1px solid black;}
	.table2 {background-color:gray;}
	.td1 {text-align:center; background-color:black; color:white; font-size:30px; position:relative;}
	.td1 a {text-decoration:none; color:white; position: absolute; right:0; top:0; font-size: 20px;}
	 p{margin :5px 0;}
	.container {display:inline-block; position:absolute; top:30% ; left:30%; z-index:1; display:none;}
	.dimm			{ position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0,0,0,0.6); z-index:0; display:none; }
	
</style>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn').click(function(){
			$.ajax({
				url:'http://localhost/openProject/ajaxTest.do'
				,dataType:'json'
				,contentType: 'application/json; charset=utf-8'
				,cache: false

				,success:function(data){
				
					console.log(data)
					$.each(data, function(i, val){
						var index=++i
						//console.log($(this))
						//console.log(i)
						$('.table1').append('<tr><td>'+index+'<td class="'+val.memberId+'">'+val.memberId+'<td>'+val.memberPwd
								+'<td>'+val.picture+'<td>'+val.memberName+'<td>'
								+val.joinDate+'<td><a href="#" class="modiBtn">수정</a> <a href="#">삭제</a>')
							
							
					})
				},error:function(data){
					
					console.log('error')
					
				}
			})
		})
		
		//수정 버튼이 눌렸을때 
		$('body').on('click','.modiBtn',function(){
			$('.nick').text($(this).parent().parent().find('td:eq(4)').text())	
			$('.dimm').show()
			$('.container').show()
			
				var Idval=$(this).parent().parent().find('td:eq(1)').text();
				var newName =$('.newName').val();
				console.log($('.newName'))
			//수정 확인 버튼 눌렸을ㅐ
			$('.sendBtn').click(function(){
				var newName =$('.newName').val();
				$('.container').hide()
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
							$('.Thead').siblings().empty();
						$.each(data, function(i, val){
							var index=++i
							console.log($(this))
							console.log(i)
							$('.Thead').siblings(':eq('+index+')').after('<tr><td>'+index+'<td class="'+val.memberId+'">'+val.memberId+'<td>'+val.memberPwd
							+'<td>'+val.picture+'<td>'+val.memberName+'<td>'
							+val.joinDate+'<td><a href="#" class="modiBtn">수정</a> <a href="#">삭제</a>');
							
								
								
						})
					},error:function(data){
						
						console.log('error')
						
					}
				})
				$('.container').hide()
				$('.dimm').hide()
			
			})
			
		})
		
		$('.closeBtn').click(function(){
			$('.container').hide()
			$('.dimm').hide()
		})
		
		// 삭제 버튼이 눌렸을 때 이벤트 
		$('body').on('click','.modiBtn',function(){})
		
		
	
	})
	



</script>
</head>
<body style="background-color:pink">
 <div class="dimm"></div>

 <input type="button" id="btn" value="가져오기"> 
 <input type="text" id="inp">
 <input type="button" id="anotherBtn" value="다른거">
 <img src="./img/4.jpg">
 <div id="result">
 	      <table class="table1">
           <tr class="Thead">
        	  <th>회원번호</th>
               <th>회원 아이다(이메일)</th>
               <th>비밀번호</th>
               <th>회원 사진</th>
               <th>회원 닉네임</th>
               <th>회원가입일</th>
               <th>관리</th>
           </tr>

       </table>      
 </div>
 
 <div class="container">
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
                        <td><input type="text" name="memberName" class="newName"></td>
                    </tr>   
                <!--     <tr>
                        <th>사진</th>
                        <td><input type="file" name="picture"></td>
                    </tr>  -->                  
                    <tr>
                        <th></th>
                        <td><input type="submit" value="등록" class="sendBtn"></td>
                    </tr>
               </table>
          
       </div>
   </div>

</body>
</html>