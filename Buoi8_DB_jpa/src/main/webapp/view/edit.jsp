<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h2>Quản lý sản phẩm</h2>
<form method="post" action="/product/update/${data.id}">
    <div>
        <label>Mã</label>
        <input type="text" name="productCode" value="${ data.productCode }"/>
    </div>
    <div>
        <label>Tên</label>
        <input type="text" name="productName" value="${ data.productName }"/>
    </div>
    <div>
        <label>Giá</label>
        <input type="text" name="price" value="${ data.price }"/>
    </div>
    </div>
    <div>
        <button>Lưu</button>
    </div>

</form>
</body>
</html>