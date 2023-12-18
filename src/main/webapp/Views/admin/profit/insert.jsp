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
    <form action="insert" method="post">
        <div class="form-group">
            <Label>ID hóa đơn</Label><br>
            <input type="number" name="billID" class="form-control">
        </div>

        <div class="form-group">
            <Label>ID sản phẩm</Label><br>
            <input type="number" name="productID" class="form-control">
        </div>

        <div class="form-group">
            <Label>Số lượng đã bán</Label><br> <input
            type="number" name="quantity" class="form-control">
        </div>

        <div class="form-group">
            <Label>Lợi nhuận</Label><br>
            <input type="number" name="price" class="form-control">
        </div>

        <div class="form-group">
            <input type="submit" value="Bill Insert" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
</html>