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

</head>
<body>
	<%@ include file="/common/user/header.jsp"%>
	<decorator:body></decorator:body>
	<%@ include file="/common/user/footer.jsp"%>

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