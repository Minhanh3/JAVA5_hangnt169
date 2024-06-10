<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-container h2 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2>Update Product</h2>
        <form action="/san-pham/ud/${spct.id}" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control" id="id" name="id" value="${spct.id}" readonly>
            </div>
            <div class="mb-3">
                <label for="sanPhamId" class="form-label">Tên SP</label>
                <select class="form-select" id="sanPhamId" name="sanPhamId">
                    <c:forEach items="${sp}" var="sp">
                        <option value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="NSXId" class="form-label">Nhà sản xuất</label>
                <select class="form-select" id="NSXId" name="NSXId">
                    <c:forEach items="${nsxE}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="MSId" class="form-label">Màu Sắc</label>
                <select class="form-select" id="MSId" name="MSId">
                    <c:forEach items="${msE}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="dspId" class="form-label">ID Dòng SP</label>
                <select class="form-select" id="dspId" name="dspId">
                    <c:forEach items="${dspE}" var="dspp">
                        <option value="${dspp.id}">${dspp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="namBh" class="form-label">Năm bảo hành</label>
                <input type="text" class="form-control" id="namBh" name="namBh" value="${spct.namBh}">
            </div>
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô tả</label>
                <input type="text" class="form-control" id="moTa" name="moTa" value="${spct.moTa}">
            </div>
            <div class="mb-3">
                <label for="soLuongTon" class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" id="soLuongTon" name="soLuongTon" value="${spct.soLuongTon}">
            </div>
            <div class="mb-3">
                <label for="giaNhap" class="form-label">Giá nhập</label>
                <input type="number" class="form-control" id="giaNhap" name="giaNhap" value="${spct.giaNhap}">
            </div>
            <div class="mb-3">
                <label for="giaBan" class="form-label">Giá bán</label>
                <input type="number" class="form-control" id="giaBan" name="giaBan" value="${spct.giaBan}">
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form>
    </div>
</div>
</body>
</html>
