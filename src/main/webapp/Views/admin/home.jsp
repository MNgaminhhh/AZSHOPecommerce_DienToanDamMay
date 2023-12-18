<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="features_items">
        <br><br>
        <h2 class="title text-center" style="font-size: 50px">Xin chào Admin !</h2>
        <c:if test="${not empty(message)}">
            <p style="text-align: center;">${message}</p>
        </c:if>
        
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</body>
</html>
