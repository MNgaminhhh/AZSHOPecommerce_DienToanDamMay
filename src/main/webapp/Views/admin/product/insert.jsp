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
	<form action="insert" method="POST">
		<div class="form-group">
			<Label>Name</Label><br>
			<input type="text" name="product_name" class="form-control">
		</div>

		<div class="form-group">
			<Label>Description</Label><br>
			<textarea name="description" rows="3" cols="30" class="form-control"></textarea>
		</div>

		<div class="form-group">
			<Label>Price</Label><br> <input type="text"
			name="price" class="form-control">
		</div>

		<div class="form-group">
			<Label>Image</Label><br> <input
			type="text" name="image" class="form-control">
		</div>

		<div class="form-group">
			<Label>Category ID</Label><br> <input type="text"
			name="category_id" class="form-control">
		</div>

		<div class="form-group">
			<Label>Seller ID</Label><br> <input
			type="text" name="seller_id" class="form-control">
		</div>

		<div class="form-group">
			<Label>Amount</Label><br>
			<input type="text" name="amount" class="form-control">
		</div>

		<div class="form-group">
			<Label>Stoke</Label><br>
			<input type="text" name="stoke" class="form-control">
		</div>
		
		<input type="submit"
			value="Product insert"class="btn btn-primary">
	</form>
</div>
</body>
</html>