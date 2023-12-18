<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/admin/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <canvas id="profitChart" width="10%"></canvas>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js'></script>
    <script>
        document.addEventListener('DOMContentLoaded', function() {

            var dataMap = new Map();

            <c:forEach var="billDetail" items="${billDetails}">
            
            <c:forEach var="bill" items="${bills}">
            
	            var date = "${bill.order_date}";
	            var profit = ${billDetail.price};
	
	            if (dataMap.has(date)) {
	                dataMap.set(date, dataMap.get(date) + profit);
	            } else {
	                dataMap.set(date, profit);
	            }
            </c:forEach>
            </c:forEach>

            var sortedDays = Array.from(dataMap.keys()).sort();

            var profits = sortedDays.map(function(date) {
                return dataMap.get(date);
            });

            var ctx = document.getElementById('profitChart').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: sortedDays,
                    datasets: [{
                        label: 'Lợi nhuận ngày ($)',
                        data: profits,
                        backgroundColor: ['green'],
                        borderColor: 'rgba(33,164,222,0.6)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        x: {
                            type: 'category',
                            labels: sortedDays,
                            title: {
                                display: true,
                                text: 'Ngày'
                            }
                        },
                        y: {
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Lợi nhuận ($)'
                            }
                        }
                    }
                }
            });
        });
    </script>
</div><br><br>
<div class="container mt-4">
    <table class="table table-bordered">
        <thead>
        <h3 class="text-center table-header">Bảng thống kê</h3>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Danh mục</th>
            <th>Nhà cung cấp</th>
            <th>Tồn kho</th>
            <th>Đã bán</th>
            <th>Doanh thu</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="STT">
            <c:forEach var="billDetail" items="${billDetails}" varStatus="billDetailIndex">
                    <tr>
                    <c:if test="${billDetailIndex.index eq STT.index}">
                         <td>${STT.index + 1}</td>
                        <td>${product.product_name}</td>
                        <td>${product.category_id}</td>
                        <td>${product.supplier_id}</td>
                        <td>${product.stock_quantity}</td>
                        <td>${billDetail.quantity}</td>
                        <td><fmt:formatNumber value="${billDetail.price}" pattern="#,##0" />đ
                     </c:if>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>