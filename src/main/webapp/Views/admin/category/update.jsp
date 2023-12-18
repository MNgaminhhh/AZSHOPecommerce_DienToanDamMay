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
		<form action="update" method="POST">
			<div class="form-group">
				<label for="category_id">ID:</label><br>
				<input type="text" name="category_id" id="category_id" value="${category.category_id}" readonly="readonly" class="form-control"/>
			</div>

			<div class="form-group">
				<label for="category_name">Name:</label><br>
				<input type="text" name="category_name" id="category_name" value="${category.category_name}" class="form-control"/>
			</div>

			<div class="form-group">
				<input type="submit" value="Category Update" class="btn btn-primary">
			</div>
		</form>
	</div>

</body>
</html>