<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Home | E-Shopper</title>
<link href='<c:url value="/templates/css/bootstrap.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/templates/css/font-awesome.min.css"/>'
	rel="stylesheet">
<link href='<c:url value="/templates/css/prettyPhoto.css"/>'
	rel="stylesheet">
<link href='<c:url value="/templates/css/price-range.css"/>'
	rel="stylesheet">
<link href='<c:url value="/templates/css/animate.css"/>'
	rel="stylesheet">
<link href='<c:url value="/templates/css/main.css"/>' rel="stylesheet">
<link href='<c:url value="/templates/css/responsive.css"/>'
	rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="templates/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="templates/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="templates/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="templates/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="templates/images/ico/apple-touch-icon-57-precomposed.png">

<style>
/* CSS cho popup */
.popup {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	z-index: 1000;
}

.popup img {
	max-width: 100%;
	max-height: 80vh;
	display: block;
	margin: 0 auto;
}

/* CSS cho nút đóng popup */
.close-btn {
	position: absolute;
	top: 10px;
	right: 10px;
	cursor: pointer;
}

.popup-background {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	z-index: 999;
}
</style>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>

	<%@ include file="/common/web/slider.jsp"%>

	<section>
		<div class="container">
			<div class="row">
				<%@ include file="/common/web/left.jsp"%>
				<decorator:body></decorator:body>
			</div>
		</div>
	</section>

	<%@ include file="/common/web/footer.jsp"%>
	<script
		src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
	<df-messenger intent="WELCOME" chat-title="AZ-bot"
		agent-id="fbbf7f5b-bd8d-4b32-8b8d-ed2fdd480232" language-code="vi"></df-messenger>
	<script src="templates/js/jquery.js"></script>
	<script src="templates/js/bootstrap.min.js"></script>
	<script src="templates/js/jquery.scrollUp.min.js"></script>
	<script src="templates/js/price-range.js"></script>
	<script src="templates/js/jquery.prettyPhoto.js"></script>
	<script src="templates/js/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</body>
</html>