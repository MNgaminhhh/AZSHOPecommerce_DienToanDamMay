<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
</head>
<body>
	<div class="container">
	<h3>Thông tin người dùng</h3>
    <p>Xin chào, ${username}!</p>
    <p>Email: ${email}</p>
    <a href="<c:url value='/user/changepass'></c:url>">Đổi mật khẩu</a>
    </div>
</body>
</html>