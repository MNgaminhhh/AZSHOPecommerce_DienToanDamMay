<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<div class="container mt-4">
    <form action="insert" method="POST">
        <div class="form-group">
            <label for="category_id">Category ID:</label>
            <input type="text" id="category_id" name="category_id" class="form-control">
        </div>

        <div class="form-group">
            <label for="category_name">Name:</label>
            <input type="text" id="category_name" name="category_name" class="form-control">
        </div>

        <div class="form-group">
            <input type="submit" value="Category Insert" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
</html>
