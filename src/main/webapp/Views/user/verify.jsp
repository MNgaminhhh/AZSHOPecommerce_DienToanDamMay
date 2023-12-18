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
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<h2>Hệ thống đã gửi mã kích hoạt đến email</h2>
						<h2>Vui lòng kiểm tra email để lấy mã kích hoạt tài khoản</h2>
						<form action="VerifyCode" method="post">
							<input type="text" placeholder="XXXXXX" name="authcode" />
							<button type="submit" class="btn btn-default">Kích hoạt</button>
						</form>
					</div>
					</div>
			</div>
		</div>
	</section>
	<!--/form-->
</body>
</html>