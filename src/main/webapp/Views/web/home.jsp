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
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<h2 class="title text-center">Sản phẩm</h2>
						<c:if test="${not empty(message)}">
							<p style="text-align: center;">${message}</p>
						</c:if>
						<!--Product-->
						<div id="content">
							<c:forEach var="product" items="${products }">
								<div class="productAjax col-sm-4">
									<div class=" product-image-wrapper single-products">
										<div class="productinfo text-center">
											<a
												href="<c:url value='/product-detail?product_id=${product.product_id}'></c:url>">
												<img style="width: auto; height: 134px"
												src="templates/images/product/${product.image }" alt="" />
											</a>
											<h2>
												<fmt:formatNumber value="${product.price}" pattern="#,##0" />
												₫
											</h2>
											<p>${product.product_name }</p>
											<button type="button" class="btn btn-default add-to-cart"
												id="addToCart"
												onclick="clickToAddCart(${user_id}, ${product.product_id}, 1)">
												<i class="fa fa-shopping-cart"></i>Add to cart
											</button>

										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="pagination-area">
						<ul class="pagination">
							<c:if test="${indexp>1 }">
								<li><a href=""><i class="fa fa-angle-double-left"></i></a></li>
							</c:if>
							<c:forEach begin="1" end="${endPage}" var="i">
								<li><a href="${pageContext.request.contextPath}/home?indexPage=${i}" class='${indexp==i?"active":""}'>${i }</a></li>
							</c:forEach>							
							<c:if test="${indexp<endPage }">
								<li><a href=""><i class="fa fa-angle-double-right"></i></a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</section>


	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(window).scroll(
				function() {
					if ($(window).scrollTop() + $(window).height() >= $(
							document).height()) {
						loadAjax();
					}
				});

		function loadAjax() {
			var amount = $(".productAjax").length;
			$.ajax({
				url : "/AZSHOP/loadAjax",
				type : "get",
				data : {
					exists : amount,
					category_id: ${category_id},
					supplier_id: ${supplier_id},
					start_range: ${start_range},
					end_range  : ${end_range},
					indexPage  : ${indexp}
				},
				success : function(data) {
					$("#content").append(data);
				},
				error : function(xhr) {
					// Xử lý lỗi nếu cần
				}
			});
		}
	</script>
	<script>
		function clickToAddCart(u_id, p_id, q) {
			var user_id = u_id;
			if (user_id === 0) {
		           // Nếu user_id không tồn tại, chuyển hướng đến trang /user/login
		           window.location.href = '${pageContext.request.contextPath}/user/login';
		        }else{
			// Lấy giá trị từ thẻ input
			var quantity = q;
			var product_id = p_id;
	
			// Simulate an asynchronous action, for example, adding to cart
			setTimeout(function() {
				// Hiển thị thông báo thành công
				Swal.fire({
					icon : 'success',
					title : 'Đã thêm vào giỏ hàng!',
					showConfirmButton : false,
					timer : 1500
				});
			}, 500); // Simulate a delay of 500 milliseconds (replace with your actual logic)
			// Gửi yêu cầu đến Servlet
			var xhr = new XMLHttpRequest();
			xhr
					.open(
							'POST',
							'${pageContext.request.contextPath}/user/add-cart',
							true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					console.log('Đã nhận phản hồi từ Servlet:',
							xhr.responseText);
					// Xử lý phản hồi từ Servlet nếu cần
				}
			};
			xhr.send(quantity + "," + product_id);
		}};
	</script>
</body>
</html>