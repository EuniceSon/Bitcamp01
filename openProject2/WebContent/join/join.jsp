<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
     
    <link rel="stylesheet" href="../css/joinNlogin.css"/>
    <link rel="stylesheet" href="../css/main.css"/>
</head>
<jsp:include page="../top.jsp"></jsp:include>
<body>
   
   <div class="top">
        <div class="inner">
            <h2> 회원가입</h2>

        </div>       
   </div>
   <!-- 
 MultipartRequest
MultipartRequest(
HttpServletRequest request,		// MultipartRequest : request로 넘어온 데이터와 
MultipartRequest하고 연결해야 한다.
String saveDirectory,			// 저장시킬 폴더의 위치 
int maxPostsize,				// 한 번에 올릴 수 있는 파일의 용량 (Byte단위)
String encoding,				// 파일 업로드의 타입
FileNamePolicy policy 			// 이름 중복 정책 - Default를 사용
)


메서드

<input type="text"/>
getParameterNames() : file이 아닌 일반 데이터들의 파라미터 이름들을 Enumeration으로 가져온다.
getParameterValues() : 폼에서 전송된 파라미터 값들을 배열로 가져온다.
getParameter() : request에 들어 있던 파라미터값을(1개) 가져온다.


<input type="file"/>
getFileNames() : 파일을 여러개 업로드 할 경우 타입이 file이었던 파라미터 이름들을 Enumeration타입으로 가져온다.
getFilesystemNames() : 서버에 올라온 이름(중복 처리가 된 이름)
getOriginFIleName() : 클라이언트가 업로드 할 당시 사용했던 원본 이름 (중복 처리 전)
getContentType() : 업로드 된 파일의 컨텐트 타입을 얻을 때 사용
getFile() : 서버에 업로드 된 파일 객체 자체를 반환하는 메서드
-->
   <div class="container">
       <div class="content" >
           <form action="joinForm.do" method="post" >
               <table>
                    <tr>
                        <th>아이디(이메일)</th>
                        <td><input type="text" name="memberId"></td>
                    </tr>   
                    <tr>
                        <th>비밀번호</th>
                        <td><input type="text" name="memberPwd"></td>
                    </tr>   
                    <tr>
                        <th>이름</th>
                        <td><input type="text" name="memberName"></td>
                    </tr>   
                    <tr>
                        <th>사진</th>
                        <td><input type="file" name="picture"></td>
                    </tr>                   
                    <tr>
                        <th></th>
                        <td><input type="submit" value="등록"></td>
                    </tr>
               </table>
           </form>
       </div>
   </div>
    
</body>
</html>