<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cảm ơn bạn đã đặt hàng</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	color: #333;
	margin: 0;
	padding: 0;
	text-align: center;
}

.thank-you-container {
	max-width: 600px;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #e44d26;
}

p {
	font-size: 18px;
	line-height: 1.6;
	margin-bottom: 20px;
}

.order-details {
	margin-top: 30px;
	border-top: 1px solid #ccc;
	padding-top: 20px;
}

.back-to-home {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	text-decoration: none;
	background-color: #e44d26;
	color: #fff;
	font-weight: bold;
	border-radius: 4px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="thank-you-container">
			<h1>Cảm ơn bạn đã đặt hàng!</h1>
			<p>Chúng tôi rất trân trọng vì đã có cơ hội được phục vụ bạn.</p>
			<p>Đơn hàng của bạn đã được xác nhận và đang được xử lý.</p>

			<p>Bạn sẽ nhận được thông báo qua email khi đơn hàng của bạn được
				vận chuyển.</p>

			<a href="${pageContext.request.contextPath}/home"
				class="back-to-home">Quay lại trang chủ</a>
		</div>
	</div>

</body>
</html>