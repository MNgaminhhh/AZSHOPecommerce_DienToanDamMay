<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Danh mục</h2>
        <div class="panel-group category-products" id="accordian">
            <!--category-productsr-->
            <c:forEach var="category" items="${categories}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href="<c:url value='/home?category_id=${category.category_id}'></c:url>">${category.category_name}</a>
                        </h4>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--/category-products-->
        <div class="brands_products">
            <!--brands_products-->
            <h2>Nhà cung cấp</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach var="sup" items="${suppliers}">
                        <li><a href="<c:url value='/home?supplier_id=${sup.supplier_id}'></c:url>">${sup.supplier_name}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!--/brands_products-->

        <div class="brands_products">
            <!--brands_products-->
            <h2>Giá</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="<c:url value='/home?price_range=1'></c:url>">Dưới $100</a></li>
                    <li><a href="<c:url value='/home?price_range=2'></c:url>">Từ $100 đến $500</a></li>
                    <li><a href="<c:url value='/home?price_range=3'></c:url>">Từ $500 đến $1000</a></li>
                    <li><a href="<c:url value='/home?price_range=4'></c:url>">Từ $1000 đến $2000</a></li>
                    <li><a href="<c:url value='/home?price_range=5'></c:url>">Lớn hơn $2000</a></li>
                </ul>
            </div>
        </div>
        <!--/price-range-->
    </div>
</div>
