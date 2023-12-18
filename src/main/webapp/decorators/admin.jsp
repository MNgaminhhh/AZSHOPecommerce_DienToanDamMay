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
	<title>Admin | E-Shopper</title>
	<link href='<c:url value="/templates/css/bootstrap.min.css"/>'
		  rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
		  integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
		  crossorigin="anonymous" referrerpolicy="no-referrer" />
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
<%@ include file="/common/admin/header.jsp"%>

	<section>
		<div class="container">
			<div class="row">
				<decorator:body></decorator:body>
			</div>
		</div>
	</section>

<%@ include file="/common/admin/footer.jsp"%>
</body>
</html>