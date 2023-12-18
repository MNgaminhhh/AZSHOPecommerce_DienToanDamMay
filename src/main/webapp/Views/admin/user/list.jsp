<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/admin/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${message!=null}">
		<span>${message}</span>
	</c:if>
	<c:if test="${error!=null}">
		<span>${error}</span>
	</c:if>

	<div class="container mt-4">

		<a href="<c:url value='/admin/user/insert'></c:url>" class="btn btn-primary">
			<i class="fa-solid fa-plus"></i> Nhập mới</a><br>

		<table class="table table-bordered table-striped">
			<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Email</th>
				<th>Role</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="user" items="${users}" >
				<tr>
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.role}</td>
					<td>${user.status}</td>
					<td>
						<a href="<c:url value='/admin/user/update?userID=${user.userID}'></c:url>
							"class="btn btn-warning btn-sm"> <i class="fa-solid fa-pen-to-square"></i> Cập nhật</a>
						<a href="<c:url value='/admin/user/delete?userID=${user.userID}'></c:url>
							"class="btn btn-danger btn-sm"> <i class="fa-solid fa-trash"></i> Xóa</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>