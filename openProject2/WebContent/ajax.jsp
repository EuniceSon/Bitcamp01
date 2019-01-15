<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						
						console.log($(this))
						console.log(i)
						$('#result').append('<p>'+val.joinDate+', '+val.memberId+', '+val.memberName+', '+val.memberNo+', '+val.memberPwd);
						
						
					})
				},error:function(data){
					
					console.log('error')
					
				}
				
				
			})
			
		})
		
	
	})
	



</script>
</head>
<body>

 <input type="button" id="btn" value="가져오기"> 
 <div id="result"></div>
</body>
</html>