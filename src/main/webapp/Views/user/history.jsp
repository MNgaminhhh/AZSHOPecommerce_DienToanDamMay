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
		<c:if test="${empty bills}">
			<h3>No bills available.</h3>
		</c:if>

		<div class="features_items" style="margin-top: 50px;">
			<h2 class="title text-center">Đơn hàng</h2>
		</div>
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td>Mã đơn hàng</td>
							<td>Ngày đặt hàng</td>
							<td>Tổng tiền</td>
							<td>Số điện thoại</td>
							<td>Địa chỉ</td>
							<td>Xem chi tiết</td>
						</tr>
					</thead>
					<c:forEach var="bill" items="${bills}">
						<tr>
							<td>${bill.bill_id}</td>
							<td>${bill.order_date}</td>
							<td>${bill.total_amount}</td>
							<td>${bill.phone}</td>
							<td>${bill.address}</td>
							<td><a
								href="<c:url value='/user/billDetails?billId=' />${bill.bill_id}">Chi tiết</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</section>
</body>
</html>