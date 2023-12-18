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
            <Label>Người mua</Label><br>
            <input type="text" name="user_id"class="form-control">
        </div>

        <div class="form-group">
            <Label>Ngày tạo</Label><br>
            <input type="date" name="order_date"class="form-control">
        </div>

        <div class="form-group">
            <Label>Số lượng</Label><br> <input
            type="number" name="total_amount"class="form-control">
        </div>

        <div class="form-group">
            <Label>Người nhận</Label><br>
            <input type="text" name="receiver"class="form-control">
        </div>

        <div class="form-group">
            <Label>SĐT</Label><br>
            <input type="text" name="phone"class="form-control">
        </div>

        <div class="form-group">
            <Label>Địa chỉ</Label><br>
            <input type="text" name="address"class="form-control">
        </div>

        <input type="submit" value="Bill Insert"class="btn btn-primary">
    </form>
</div>
</body>
</html>