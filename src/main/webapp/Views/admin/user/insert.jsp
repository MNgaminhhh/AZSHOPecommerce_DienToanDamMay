<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
	<form action="insert" method="post">
		<div class="form-group">
			<Label>Tên </Label><br>
			<input type="text" name="userName" class="form-control">
		</div>

		<div class="form-group">
			<Label>Mật khẩu</Label><br> <input type="text"
			name="password" class="form-control">
		</div>

		<div class="form-group">
			<Label>Email</Label><br> <input
			type="text" name="email" class="form-control">
		</div>

		<div class="form-group">
			<Label>Role</Label><br> <input type="text"
			name="role" class="form-control">
		</div>

		<div class="form-group">
			<Label>Status</Label><br> <input type="text"
			name="status"class="form-control">
		</div>
		
		<input type="submit"
			value="Tạo mới" class="btn btn-primary">
	</form>
</div>
</body>
</html>