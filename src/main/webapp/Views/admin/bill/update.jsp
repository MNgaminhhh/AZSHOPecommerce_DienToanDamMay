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
        <input type="text" name="bill_id" value="${bill.bill_id}" readonly="readonly" class="form-control">
    </div>

    <div class="form-group">
        <Label>Người mua</Label><br>
        <input type="text" name="user_id"value="${bill.user_id}" class="form-control">
    </div>

    <div class="form-group">
        <Label>Ngày tạo</Label><br>
        <input type="date" name="order_date" value="${bill.order_date}" class="btn btn-primary">
    </div>

    <div class="form-group">
        <Label>Số lượng</Label><br> <input
        type="number" name="total_amount" value="${bill.total_amount}" class="form-control">
    </div>

    <div class="form-group">
        <Label>Người nhận</Label><br>
        <input type="text" name="receiver" value="${bill.receiver}" class="form-control">
    </div>

    <div class="form-group">
        <Label>SĐT</Label><br>
        <input type="text" name="phone" value="${bill.phone}" class="form-control">
    </div>

    <div class="form-group">
        <Label>Địa chỉ</Label><br>
        <input type="text" name="address" value="${bill.address}" class="form-control">
    </div>

    <div class="form-group">
        <input type="submit" value="Bill Update" class="btn btn-primary">
    </div>
</form>
</div>
</body>
</html>