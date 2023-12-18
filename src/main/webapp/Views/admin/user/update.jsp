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
	<form action="update" method="post">
		<div class="form-group">
			<label>ID: </label><br>
			<input type="text" name="userID" value="${user.userID}" readonly="readonly" class="form-control"/>
		</div>

		<div class="form-group">
			<Label>Name</Label><br>
			<input type="text" name="userName"value="${user.userName}"  class="form-control"/>
		</div>

		<div class="form-group">
			<Label>Password</Label><br>
			<input type="text" name="password" value="${user.password}" class="form-control"/>
		</div>

		<div class="form-group">
			<Label>Email</Label><br> <input
			type="text" name="email" value="${user.email}" class="form-control"/>
		</div>

		<div class="form-group">
			<Label>Role</Label><br>
			<input type="text" name="role" value="${user.role}" class="form-control"/>
		</div>

		<div class="form-group">
			<Label>Status</Label><br>
			<input type="text" name="status" value="${user.status}" class="form-control"/>
		</div>

		<div class="form-group">
			<input type="submit" value="User update" class="btn btn-primary">
		</div>
	</form>
</div>
</body>
</html>