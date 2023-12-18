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
		<div class="container">

			<div class="step-one">
				<h2 class="heading">Thông tin đơn hàng</h2>
			</div>

			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-4">
						<div class="shopper-info">
							<p>Thông tin người gửi</p>
							<form>
								<input id="senderName" type="text" placeholder="Tên người gửi"
									value="AZSHOP" readonly> <input id="senderPhone"
									type="text" placeholder="Số điện thoại" value="0981141044"
									readonly> <input id="senderAddress" type="text"
									placeholder="Địa chỉ" value="P14, Gò vấp, HCM" readonly>
							</form>
						</div>
					</div>
					<div class="col-sm-4 clearfix">
						<div class="shopper-info">
							<p>Thông tin người nhận</p>
							<form>
								<input id="receiverName" type="text"
									placeholder="Tên người nhận"> <input id="receiverPhone"
									type="text" placeholder="Số điện thoại"> <input
									id="receiverAddress" type="text" placeholder="Địa chỉ">
							</form>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="order-message">
							<p>Lời nhắn</p>
							<textarea name="message" id="message"
								placeholder="Nếu cần shop lưu ý điều gì thì viết vào đây"
								rows="12"></textarea>
						</div>
					</div>
				</div>
			</div>

			<div class="step-one">
				<h2 class="heading">Chi tiết đơn hàng</h2>
			</div>
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
									<p>$${cart.product.price }</p>
								</td>
								<td class="cart_quantity">
									<div class="cart_quantity_button">
										<p style="font-size: 25px">${cart.quantity }</p>
									</div>
								</td>
								<td class="cart_total">
									<p style="font-size: 25px" class="cart_total_price">
										<fmt:formatNumber value="${cart.total_price}" pattern="#,##0" />
										₫
									</p>
								</td>
							</tr>
							<tr>
								<td colspan="4">&nbsp;</td>
								<td colspan="2">
									<table class="table table-condensed total-result">
										<tr>
											<td>Tổng giá trị các sản phẩm</td>
											<td><fmt:formatNumber value="${total}" pattern="#,##0" />
												₫/td>
										</tr>
										<tr class="shipping-cost">
											<td>Phí ship</td>
											<td>10.000₫</td>
										</tr>
										<tr>
											<td>Giá trị đơn hàng</td>
											<td><span><fmt:formatNumber value="${total_amount}" pattern="#,##0" />
												₫</span></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="step-one">
				<h2 class="heading">Phương thức thanh toán</h2>
			</div>
			<div class="checkout-options">
				<ul class="nav">
					<li><label><input id="cash" name="paymentMethod"
							type="radio"> Tiền mặt</label></li>
					<li><label><input id="card" name="paymentMethod"
							type="radio"> Thẻ ngân hàng</label></li>
				</ul>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="total_area" style="width: 500px; font-size: 20px">
						<button style="font-size: 20px; width: 300px; margin: 30px 0px"
							class="btn btn-default check_out" id="checkoutButton"
							onclick="validateForm(${total_amount }, event)">Thanh
							toán</button>
					</div>
				</div>
			</div>
			<!--/checkout-options-->
		</div>
	</section>
	<!--/#cart_items-->
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
	// Đăng ký sự kiện sau khi trang đã được tải
    function validateForm(total_amount) {
    	event.preventDefault();
        var senderName = document.getElementById('senderName').value;
        var senderPhone = document.getElementById('senderPhone').value;
        var senderAddress = document.getElementById('senderAddress').value;

        var receiverName = document.getElementById('receiverName').value;
        var receiverPhone = document.getElementById('receiverPhone').value;
        var receiverAddress = document.getElementById('receiverAddress').value;

        var paymentMethodCash = document.getElementById('cash').checked;
        var paymentMethodCard = document.getElementById('card').checked;

        if (!senderName || !senderPhone || !senderAddress || !receiverName || !receiverPhone || !receiverAddress) {
            alert('Vui lòng điền đầy đủ thông tin người gửi và người nhận.');
            return false;
        }

        if (!(paymentMethodCash || paymentMethodCard)) {
            alert('Vui lòng chọn phương thức thanh toán.');
            return false;
        }
		if (paymentMethodCard){
            window.location.href = '/AZSHOP/user/paymentMethodCart?total_amount='+total_amount;
		}
		else{
	        // Ajax request to submit data
	        $.ajax({
	            url: '/AZSHOP/user/addbill',
	            type: 'GET',
	            data: {
	                // your data here
	                total_amount: ${total_amount},
	                receiver : receiverName,
	                phone : receiverPhone,
	                address : receiverAddress 
	            },
	            success: function (data) {
	                // Process the success response
	                window.location.href = '/AZSHOP/user/thanks';
	            },
	            error: function (xhr) {
	                // Handle the error if needed
	            }
	        });
		}

        return true;
    }
</script>
</body>
</html>