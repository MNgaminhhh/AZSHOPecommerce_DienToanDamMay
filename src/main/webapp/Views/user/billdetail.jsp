<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="cart_items">
		<div class="features_items" style="margin-top: 50px;">
			<h2 class="title text-center">Chi tiết đơn hàng</h2>
		</div>
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td>Mã sản phẩm</td>
							<td>Tên sản phẩm</td>
							<td>Số lượng</td>
							<td>Giá tiền</td>
						</tr>
					</thead>
					<c:forEach var="billdetail" items="${billdetail}">
						<tr>
							<td>${billdetail.product.product_id}</td>
							<td>${billdetail.product.product_name}</td>
							<td>${billdetail.quantity}</td>
							<td>${billdetail.price}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>