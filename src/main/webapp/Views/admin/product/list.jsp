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
<div class="container mt-4">
	<a href="<c:url value='/admin/product/insert'></c:url>" class="btn btn-primary">
		<i class="fa-solid fa-plus"></i> Nhập mới</a><br>

	<table class="table table-bordered table-striped">
		<thead>
		<tr>
			<th>ID</th>
			<th>Tên</th>
			<th>Mô tả</th>
			<th>Giá</th>
			<th>Danh mục</th>
			<th>Nhà cung cấp</th>
			<th>Ảnh</th>
			<th>Tồn kho</th>
			<th>Đã bán</th>
			<th>Thao tác</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="product" items="${products}" varStatus="STT">
			<tr>
				<td>${STT.index+1}</td>
				<td>${product.product_name}</td>
				<td>${product.description}</td>
				<td>
			    <fmt:formatNumber value="${product.price}" pattern="#,##0" />đ
			   </td>
				<td>${product.category_id}</td>
				<td>${product.supplier_id}</td>
				<td>${product.image}</td>
				<td>${product.stock_quantity}</td>
				<td>${product.sold_quantity}</td>
				<td>
					<a href="<c:url value="/admin/product/update?product_id=${product.product_id}"></c:url>
						"class="btn btn-warning btn-sm"> <i class="fa-solid fa-pen-to-square"></i> Cập nhật</a>
					<br><br>
					<a href="<c:url value="/admin/product/delete?product_id=${product.product_id}"></c:url>
						"class="btn btn-danger btn-sm"> <i class="fa-solid fa-trash"></i> Xóa</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>