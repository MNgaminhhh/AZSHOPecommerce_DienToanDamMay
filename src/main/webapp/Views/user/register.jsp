<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="col">
				<c:if test="${not empty message}">
					<div class="alert laert-success">${message}</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert laert-success">${error}</div>
				</c:if>
			</div>
		
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Register new account</h2>
						<form action="register" method="post">
							<input type="text" placeholder="User Name" id="username" name="username" /> 
							<input type="text" placeholder="Email" id="email" name="email" /> 
							<input type="text" placeholder="Password" id="password" name="password" />
							<button type="submit" class="btn btn-default">Sign up</button>
						</form>
					</div>
					<!--/login form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
</body>
</html>