<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
<form action="update" method="post">
    <div class="form-group">
        <label>ID: </label><br>
        <input type="text" name="detailID" value="${billDetail.detailID}" readonly="readonly" class="form-control">
    </div>

    <div class="form-group">
        <Label>ID hóa đơn</Label><br>
        <input type="text" name="billID"value="${billDetail.billID}" class="form-control">
    </div>

    <div class="form-group">
        <Label>ID sản phẩm</Label><br>
        <input type="number" name="productID" value="${billDetail.productID}" class="form-control">
    </div>

    <div class="form-group">
        <Label>Số lượng</Label><br>
        <input type="number" name="quantity" value="${billDetail.quantity}" class="form-control">
    </div>

    <div class="form-group">
        <Label>Lợi nhuận</Label><br>
        <input type="number" name="price" value="${billDetail.price}" class="form-control">
    </div>

    <div class="form-group">
        <input type="submit" value="Bill Update"/>
    </div>
</form>
</div>
</body>
</html>