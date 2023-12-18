<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<header id="header">
	<!--header-->
	<div class="header_top">
		<!--header_top-->
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="contactinfo">
						<ul class="nav nav-pills">
							<li><a href="#"><i class="fa fa-phone"></i> +123 456 789</a></li>
							<li><a href="#"><i class="fa fa-envelope"></i>
									@student.hcmute.edu.vn</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="social-icons pull-right">
						<ul class="nav navbar-nav">
							<li><a target="_blank"
								href="/"><i
									class="fa fa-facebook"></i></a></li>
							<li><a target="_blank"
								href="/"><i
									class="fa fa-twitter"></i></a></li>
							<li><a target="_blank"
								href="/"><i
									class="fa fa-linkedin"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header_top-->

	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="${pageContext.request.contextPath}/home">
							<h2 style="color: #B4B1AB; font-family: abel; font-size: 50px">
								<span style="color: #FE980F;">AZ</span>-SHOP
							</h2>
						</a>
					</div>
				</div>
				<div class="col-sm-7">
					<div class="shop-menu pull-right padding-left">
						<ul class="nav navbar-nav">
							<li><a
								href="${pageContext.request.contextPath}/admin/category/list"><i
									class="fa-solid fa-list-ol"></i> Quản lý danh mục</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/product/list"><i
									class="fa-brands fa-product-hunt"></i> Quản lý Hàng hóa</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/user/list"><i
									class="fa fa-user"></i> Quản lý User</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/bill/list"><i
									class="fa-solid fa-file-invoice-dollar"></i> Quản lý hóa đơn</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/profit/profits"><i
									class="fa-solid fa-money-bill"></i> Báo cáo doanh thu</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/statistic/statistic"><i
									class="fa-solid fa-chart-simple"></i> Thống kê</a></li>
							<li><a href="${pageContext.request.contextPath}/user/logout"><i
									class="fa fa-unlock"></i> Đăng xuất</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

</header>

