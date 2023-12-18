<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ include file="/common/taglib.jsp"%>--%>
<%@ include file="/common/admin/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
    <a href="<c:url value='/admin/category/insert'></c:url>" class="btn btn-primary">
        <i class="fa-solid fa-plus"></i> Nhập mới</a><br>

    <table class="table table-bordered table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên mặt hàng</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${listcate}" >
            <tr>
                <td>${category.category_id}</td>
                <td>${category.category_name}</td>
                <td>
                    <a href="<c:url value='/admin/category/update?category_id=${category.category_id}'></c:url>
                        "class="btn btn-warning btn-sm"> <i class="fa-solid fa-pen-to-square"></i> Cập nhật</a>
                    <a href="<c:url value='/admin/category/delete?category_id=${category.category_id}'></c:url>
                        "class="btn btn-danger btn-sm"> <i class="fa-solid fa-trash"></i> Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
