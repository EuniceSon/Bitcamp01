 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js
	"></script>
  </head> 
  <body> 
    <h1> Rest Modify</h1>
    
    <form>
    	<input type="text" id="id">
    	<input type="text" id="newname">
    	
    	<input type="button" value="전송" id="btn">
    
    </form>
    <script>
    
    
    $('#btn').on('click', function(){
    	
    	var arr = {
    			id : $('#id').val(), 
    			newname : $('#newname').val()
    			};
        	$.ajax({
        		 url: '../rest/1'
        		 ,type:'PUT'
        		 ,data :JSON.stringify(arr)
        			,dataType : 'json',
        			contentType : 'application/json; charset=utf-8',
        			async : false,
        		 /* ,contentType: 'text/html;charset=utf-8' */
        		  success : function(msg){
        					alert(JSON.stringify(msg));
        					console.log('success')
        					
        				},error:function(){
        					console.log('sfd')
        				}
        		
        		
        	})
        	
    	
    })
    
	
    
    </script>
    
  </body> 
 </html>