<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="col">
				<c:if test="${not empty message}">
					<div class="alert laert-success">${message}</div>
				</c:if>
			</div>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Login to your account</h2>
						<form action="login" method="post">
							<input type="text" placeholder="User Name" id="username"
								name="username" /> <input type="password"
								placeholder="Password" id="password" name="password" /> <span>
								<input type="checkbox" class="checkbox" name="remember">
								Keep me signed in
							</span>
							<h5>
								<a href="<c:url value='/user/forgotpass'></c:url>">Forgot
									password</a>
							</h5>
							<button type="submit" class="btn btn-default">Login</button>
							<button type="button" class="btn btn-default"
								onclick="window.location.href='<c:url value='/user/register'></c:url>'">
								Register</button>
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