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
			<label>ID: </label><br>
			<input type="text" name="product_id" value="${product.product_id}" readonly="readonly" class="form-control">
		</div>

		<div class="form-group">
			<Label>Name</Label><br>
			<input type="text" name="product_name" value="${product.product_name }" class="form-control">
		</div>

		<div class="form-group">
			<Label>Description</Label><br>
			<textarea class="form-control" name="description" rows="3" cols="30" >${product.description} </textarea>
		</div>

		<div class="form-group">
			<Label>Price</Label><br>
			<input type="text" name="price" value="${product.price}" class="form-control">
		</div>

		<div class="form-group">
			<Label>Image</Label><br>
			<input type="text" name="image" value="${product.image}" class="form-control">
		</div>

		<div class="form-group">
			<Label>Category ID</Label><br>
			<input type="text" name="category_id" value="${product.category_id}" readonly="readonly" class="form-control">
		</div>

		<div class="form-group">
			<Label>Supplier ID</Label><br>
			<input type="text" name="supplier_id" value="${product.supplier_id}" class="form-control">
		</div>

		<div class="form-group">
			<Label>Amount</Label><br>
			<input type="text" name="amount" value="${product.stock_quantity}" class="form-control">
		</div>

		<div class="form-group">
			<Label>Stoke</Label><br>
			<input type="text" name="stoke" value="${product.sold_quantity}" class="form-control">
		</div>

		<div class="form-group">
			<input type="submit" value="Product update" class="btn btn-primary">
		</div>
	</form>
	</div>
</body>
</html>