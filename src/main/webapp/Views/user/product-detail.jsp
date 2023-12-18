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
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="templates/images/product/${product.image }" alt="" />
								<h3>ZOOM</h3>
							</div>
						</div>
						<div class="col-sm-7">
							<div class="product-information">
								<!--/product-information-->
								<h2>${product.product_name }</h2>
								<p>Mã sản phẩm: ${product.product_id }</p>
								<span> <span><fmt:formatNumber value="${product.price}" pattern="#,##0" />
												₫</span> <label>Quantity:</label>
									<input type="text" value="3" />
									<button type="button" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
									</button>
								</span>
								<p>
									<b>Tồn kho: </b>${product.stock_quantity }</p>
								<p>
									<b>Nhà cung cấp: </b>${supplier.supplier_name }</p>
								<p>
									<b>Mô tả sản phẩm: </b>${product.description }</p>
							</div>
							<!--/product-information-->
						</div>
					</div>
					<!--/product-details-->

					<div class="viewed_products_items">
						<!--recommended_items-->
						<h2 class="title text-center">Sản phẩm đã xem</h2>

						<div id="viewed_products-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="i" items="${viewed_product_active }">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<img style="width: auto; height: 134px"
															src="templates/images/product/${i.image }" alt="" />
														<h2><fmt:formatNumber value="${product.price}" pattern="#,##0" />
												₫</h2>
														<p>${i.product_name }</p>
														<button type="button" class="btn btn-default add-to-cart">
															<i class="fa fa-shopping-cart"></i>Add to cart
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<c:forEach var="j" items="${viewed_product }">
									<div class="item">
										<c:forEach var="i" items="${j }">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img style="width: auto; height: 134px"
																src="templates/images/product/${i.image }" alt="" />
															<h2>$${i.price }</h2>
															<p>${i.product_name }</p>
															<button type="button" class="btn btn-default add-to-cart">
																<i class="fa fa-shopping-cart"></i>Add to cart
															</button>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
							<a class="left viewed_products-item-control"
								href="#viewed_products-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right viewed_products-item-control"
								href="#viewed_products-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/viewed_products -->

					<div class="same_cate_items">
						<!--recommended_items-->
						<h2 class="title text-center">Sản phẩm cùng loại</h2>

						<div id="same_cate-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="i" items="${same_cate_active }">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<img style="width: auto; height: 134px"
															src="templates/images/product/${i.image }" alt="" />
														<h2><fmt:formatNumber value="${product.price}" pattern="#,##0" />
												₫</h2>
														<p>${i.product_name }</p>
														<button type="button" class="btn btn-default add-to-cart">
															<i class="fa fa-shopping-cart"></i>Add to cart
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<c:forEach var="j" items="${same_cate }">
									<div class="item">
										<c:forEach var="i" items="${j }">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img style="width: auto; height: 134px"
																src="templates/images/product/${i.image }" alt="" />
															<h2>$${i.price }</h2>
															<p>${i.product_name }</p>
															<button type="button" class="btn btn-default add-to-cart">
																<i class="fa fa-shopping-cart"></i>Add to cart
															</button>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
							<a class="left same_cate-item-control"
								href="#same_cate-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right same_cate-item-control"
								href="#same_cate-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/same_cate_items-->


					<div class="same_supplier_items">
						<!--recommended_items-->
						<h2 class="title text-center">Sản phẩm cùng nhà cung cấp</h2>

						<div id="same_supplier-item-carousel" class="carousel slide"
							data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">
									<c:forEach var="i" items="${same_supplier_active }">
										<div class="col-sm-4">
											<div class="product-image-wrapper">
												<div class="single-products">
													<div class="productinfo text-center">
														<img style="width: auto; height: 134px"
															src="templates/images/product/${i.image }" alt="" />
														<h2><fmt:formatNumber value="${product.price}" pattern="#,##0" />
												₫</h2>
														<p>${i.product_name }</p>
														<button type="button" class="btn btn-default add-to-cart">
															<i class="fa fa-shopping-cart"></i>Add to cart
														</button>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<c:forEach var="j" items="${same_supplier }">
									<div class="item">
										<c:forEach var="i" items="${j }">
											<div class="col-sm-4">
												<div class="product-image-wrapper">
													<div class="single-products">
														<div class="productinfo text-center">
															<img style="width: auto; height: 134px"
																src="templates/images/product/${i.image }" alt="" />
															<h2>$${i.price }</h2>
															<p>${i.product_name }</p>
															<button type="button" class="btn btn-default add-to-cart">
																<i class="fa fa-shopping-cart"></i>Add to cart
															</button>
														</div>
													</div>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:forEach>
							</div>
							<a class="left same_supplier-item-control"
								href="#same_supplier-item-carousel" data-slide="prev"> <i
								class="fa fa-angle-left"></i>
							</a> <a class="right same_supplier-item-control"
								href="#same_supplier-item-carousel" data-slide="next"> <i
								class="fa fa-angle-right"></i>
							</a>
						</div>
					</div>
					<!--/same_supplier_items -->

				</div>
			</div>
		</div>
	</section>
</body>
</html>