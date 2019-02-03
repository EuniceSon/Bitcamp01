 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 
 <%@include file="../include/header.jsp" %>
	<div class="box-footer" style="width:400px; margin:0 auto">
	<form action="/user/loginPost" method="post">
		<div class="form-group has-feedback">
			<input type="text" name="uid" class="form-control" placeholder="USER_ID"/>
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		<div class="form-group has-feedback">
			<input type="password" name="upw" class="form-control" placeholder="password"/>
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
		
		
		<div class="row">
			<div class="col-xs-8">
				<div class="checkbox icheck">
					<label>
						<input type="checkbox" name="useCookie">	Remember Me				
					</label>
				</div>
			</div><!-- /col-xs -->
			<div class="col=xs-4">
				<button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
			</div><!-- /col-xs -->
		</div>
	
	</form>
	</div>
 
 <%@include file="../include/footer.jsp" %>