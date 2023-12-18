<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/admin/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<c:if test="${message!=null}">
  <span>${message}</span>
</c:if>
<c:if test="${error!=null}">
  <span>${error}</span>
</c:if>


<div class="container mt-4">
  <a href="<c:url value='/admin/bill/insert'></c:url>" class="btn btn-primary">
    <i class="fa-solid fa-plus"></i> Nhập mới</a><br>

  <table class="table table-bordered table-striped">
    <thead>
    <tr>
      <th>ID</th>
      <th>Người mua</th>
      <th>Ngày tạo</th>
      <th>Tông tiền</th>
      <th>Người nhận</th>
      <th>SĐT</th>
      <th>Địa chỉ</th>
      <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bill" items="${bills}" >
      <tr>
        <td>${bill.bill_id}</td>
        <td>${bill.user_id}</td>
        <td>${bill.order_date}</td>
        <td>
    	<fmt:formatNumber value="${bill.total_amount}" pattern="#,##0" />đ
		</td>
        <td>${bill.receiver}</td>
        <td>${bill.phone}</td>
        <td>${bill.address}</td>
        <td>
          <a href="<c:url value='/admin/bill/update?bill_id=${bill.bill_id}'></c:url>
            "class="btn btn-warning btn-sm"> <i class="fa-solid fa-pen-to-square"></i> Cập nhật</a>

          <a href="<c:url value='/admin/bill/delete?bill_id=${bill.bill_id}'></c:url>
            "class="btn btn-danger btn-sm"> <i class="fa-solid fa-trash"></i> Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>