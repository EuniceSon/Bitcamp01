<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="../resources/css/joinNlogin.css">
    <link rel="stylesheet" href="../resources/css/main.css">
    
</head>
    <jsp:include page="../top.jsp"></jsp:include>
<body>


    <div class="top">
        <div class="inner">
            <h2> 로그인</h2>
        </div>       
   </div>
    <div class="container">
       <div class="content" >
           <form action="/web/login/loginForm" method="post">
               <table>
                    <tr>
                        <th>아이디(이메일)</th>
                        <td><input type="text" name="memberId"></td>
                    </tr>   
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="text" name="memberPwd"></td>
                    </tr>   
                     <tr class="submit">
                        <th></th>
                        <td><input type="submit" value="로그인"></td>
                    </tr>
                    
               </table>
           </form>
        </div>
    </div>
    
</body>
</html>