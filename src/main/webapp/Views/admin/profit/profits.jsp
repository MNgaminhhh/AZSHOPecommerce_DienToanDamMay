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
	<c:if test="${message != null}">
		<span>${message}</span>
	</c:if>
	<c:if test="${error != null}">
		<span>${error}</span>
	</c:if>

	<div class="container mt-4">
		<c:set var="totalQuantity" value="0" />
		<c:set var="totalPrice" value="0" />


		<a href="<c:url value='/admin/profit/insert'></c:url>"
			class="btn btn-primary"> <i class="fa-solid fa-plus"></i> Nhập
			mới
		</a><br>

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>ID hóa đơn</th>
					<th>ID sản phẩm</th>
					<th>Số lượng bán ra</th>
					<th>Doanh thu</th>
					<th>Thời gian</th>
					<th>Thao tác</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bill" items="${billDetails}" varStatus="loopStatus">
					<tr>
						<td>${bill.detailID}</td>
						<td>${bill.billID}</td>
						<td>${bill.productID}</td>
						<td>${bill.quantity}</td>
						<td><fmt:formatNumber value="${bill.price}" pattern="#,##0" />đ
						</td>
						<td><c:forEach var="bills" items="${bills}">
								<c:if test="${bills.bill_id eq bill.billID}">
									<c:out value="${bills.order_date}" />
								</c:if>
							</c:forEach></td>
						<td><a
							href="<c:url value='/admin/profit/update?detailID=${bill.detailID}'></c:url>"
							class="btn btn-warning btn-sm"> <i
								class="fa-solid fa-pen-to-square"></i> Cập nhật
						</a> <a
							href="<c:url value='/admin/profit/delete?detailID=${bill.detailID}'></c:url>"
							class="btn btn-danger btn-sm"> <i class="fa-solid fa-trash"></i>
								Xóa
						</a></td>
					</tr>
					<%-- Accumulate values --%>
					<c:set var="totalQuantity" value="${totalQuantity + bill.quantity}" />
					<c:set var="totalPrice" value="${totalPrice + bill.price}" />
					<%-- Display totals when processing the last item --%>
					<c:if test="${loopStatus.last}">
						<tr>
							<td colspan="4"><strong>Tổng số sản phẩm bán ra:
									${totalQuantity}</strong></td>
							<td colspan="5"><strong>Tổng doanh thu: <fmt:formatNumber
										value="${totalPrice}" pattern="#,##0" />đ
							</strong></td>
							<td></td>
						</tr>
					</c:if>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<input type="text" id="datepicker">

	<script>
		document.addEventListener('DOMContentLoaded', function() {
			flatpickr("#datetimepicker", {
				enableTime : true, // Cho phép chọn giờ và phút
				dateFormat : "d/m/Y H:i", // Định dạng ngày tháng và giờ
				time_24hr : true
			// Sử dụng định dạng giờ 24
			});
		});
	</script>

	<!-- Thư viện Flatpickr CSS và JS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

</body>
</html>