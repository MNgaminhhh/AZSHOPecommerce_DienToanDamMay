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

		<c:if test="${not empty message}">
			<script>
				function showMessage(mess) {
					setTimeout(function() {
						// Hiển thị thông báo thành công
						Swal.fire({
							icon : 'error',
							title : mess,
							showConfirmButton : false,
							timer : 1500
						});
					}, 500); // Simulate a delay of 500 milliseconds (replace with your actual logic)
				}
				var messageFromJSP = '${message}';
				// Thực thi function thông báo khi biến message tồn tại
				showMessage(messageFromJSP);
			</script>
		</c:if>
		<div class="features_items" style="margin-top: 50px;">
			<h2 class="title text-center">Giỏ hàng</h2>
		</div>
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Hình ảnh</td>
							<td class="description">Tên sản phẩm</td>
							<td class="price">Đơn giá</td>
							<td class="quantity">Số lượng</td>
							<td class="total">Thành tiền</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cart" items="${carts}">
							<tr>
								<td class="cart_product"><a href=""><img width="80px"
										height="auto"
										src="${pageContext.request.contextPath}/templates/images/product/${cart.product.image}"
										alt="error"></a></td>
								<td class="cart_description">
									<h4>
										<a href="">${cart.product.product_name }</a>
									</h4>
									<p>Mã sản phẩm: ${cart.product.product_id}</p>
								</td>
								<td class="cart_price">
									<p>
										<fmt:formatNumber value="${cart.product.price}"
											pattern="#,##0" />
										₫
									</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<form id="updateCartForm${cart.cart_id }"
											action="${pageContext.request.contextPath}/user/update-cart"
											method="get">
											<button class="cart_quantity_input" name="quantity" value="1"
												style="width: 25px; height: auto;">+</button>
											<input type="hidden" name="cart_id" value="${cart.cart_id}">
											<input type="hidden" name="isCheck" value="false">
										</form>
										<form id="updateCartForm${cart.cart_id }"
											action="${pageContext.request.contextPath}/user/update-cart"
											method="get">
											<input class="cart_quantity_input" type="text"
												name="quantity" value="${cart.quantity}" autocomplete="off"
												size="2"> <input type="hidden" name="cart_id"
												value="${cart.cart_id}"> <input type="hidden"
												name="isCheck" value="true">
										</form>
										<form id="updateCartForm${cart.cart_id }"
											action="${pageContext.request.contextPath}/user/update-cart"
											method="get">
											<button class="cart_quantity_input" name="quantity"
												value="-1" style="width: 25px; height: auto;">-</button>
											<input type="hidden" name="cart_id" value="${cart.cart_id}">
											<input type="hidden" name="isCheck" value="false">
										</form>
									</div>
								</td>
								<td class="cart_total">
									<p class="cart_total_price">
										<fmt:formatNumber value="${cart.total_price}" pattern="#,##0" />
										₫
									</p>
								</td>
								<td class="cart_delete"><a class="cart_quantity_delete"
									href="${pageContext.request.contextPath}/user/delete-cart?cart_id=${cart.cart_id}"><i
										class="fa fa-times"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!--/#cart_items-->
	<section id="do_action" style="justify-content: flex-end;">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="total_area" style="width: 500px; font-size: 20px">
						<p>
							Giá trị đơn hàng: <span><fmt:formatNumber value="${total}"
									pattern="#,##0" /> ₫</span>
						</p>
						<a style="font-size: 20px" class="btn btn-default check_out"
							href="${pageContext.request.contextPath}/user/checkout">Đặt
							hàng</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#do_action-->
	<!-- Sử dụng sự kiện onchange để tự động gửi biểu mẫu khi số lượng thay đổi -->
	<script>
		document.querySelector('.cart_quantity_input').addEventListener(
				'change', function() {
					document.getElementById('updateCartForm').submit();
				});
	</script>
</body>
</html>