<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>Changepassword</h2>
						<form action="changepass" method="post">
							<input type="text" placeholder="Old password" id="oldpass"
								name="oldpass" /> <input type="text" placeholder="New password"
								id="newpass" name="newpass" />
							<button type="submit" class="btn btn-default">Change
								password</button>
						</form>
					</div>
					<!--/login form-->
				</div>
			</div>
	</section>
</body>
</html>