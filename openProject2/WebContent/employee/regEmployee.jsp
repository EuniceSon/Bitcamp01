<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
     
    <link rel="stylesheet" href="../css/joinNlogin.css"/>
    <link rel="stylesheet" href="../css/main.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<jsp:include page="../top.jsp"></jsp:include>
<body>
   
   <div class="top">
        <div class="inner">
            <h2>사원등록</h2>

        </div>       
   </div>
   <div class="container">
       <div class="content" >
           <form action="regEmployee.do" method="post">
               <table>
                    <tr>
                        <th>사원번호</th>
                        <td><input type="text" name="empno"><br>
                        	<p style="font-size:8px; color:red; display:none" class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr>   
                    <tr>
                        <th>사원 이름</th>
                        <td><input type="text" name="ename">
                       		<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr>   
                    <tr>
                        <th>직책</th>
                        <td><input type="text" name="job">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr>   
                    <tr>
                        <th>매니저 번호</th>
                        <td><input type="text" name="mgr">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr>
                    <tr>
                        <th>입사일</th>
                        <td><input type="text" name="hiredate" class="date">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        	<p style="font-size:8px; color:red; display:none"class="incor" >YYYY-MM-DD형식으로 입력해 주세요</p>
                        </td>
                    </tr> 
                    <tr>
                        <th>급여</th>
                        <td><input type="text" name="sal">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr> 
                    <tr>
                        <th>수수료</th>
                        <td><input type="text" name="comm">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr> 
                    <tr>
                        <th>부서번호</th>
                        <td><input type="text" name="deptno">
                        	<p style="font-size:8px; color:red; display:none"  class="nes">>필수입력사항입니다</p>
                        </td>
                    </tr>                    
                    <tr>
                        <th></th>
                        <td><input type="submit" value="등록"></td>
                    </tr>
               </table>
           </form>
       </div>
   </div>
    <script>
    $('input[type="submit"]').click(function(){
    	console.log('asf')
    	if($('input[type="text"]').val()==''||$('input[type="text"]').val()==null){
    		alert('입력창이 완성되지 않았습니다.')
    		$('form').attr('action','#')
    	}else{
    		$('form').attr('action','regEmployee.do')
    	}
    })
    
   $('input[type="text"]').focusout(function(){
	   $(this).siblings('.nes').show();
	   console.log($(this).is('.date'))
	   if($(this).is('.date')){
		   var chk1 = /^(19|20)\d{2}-([1-9]|1[012])-([1-9]|[12][0-9]|3[01])$/;
		   var chk2 = /^(19|20)\d{2}\/([0][1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01])$/;
		   if (chk1.test($(this).val()) == false && chk2.test($(this).val()) == false)
		    { // 유효성 검사에 둘다 성공하지 못했다면
		        alert("1999-1-1 형식 또는 \r\n1999-01-01 형식으로 날자를 입력해주세요.");
		        $(this).siblings('.incor').show()
		        $(this).val('');
		        
		       return false;
		    }
		  console.log($(this).val())
		   
		   
	   }
	   
   })
    </script>
</body>
</html>