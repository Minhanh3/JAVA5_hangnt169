<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Management</title>
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .form-container h2 {
            margin-bottom: 20px;
        }
        .table-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .table thead th {
            background-color: #343a40;
            color: #fff;
        }
        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .btn-custom {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h2>Add New Product</h2>
        <form action="/san-pham/add" method="post">
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <input type="text" class="form-control" id="id" name="id">
            </div>
            <div class="mb-3">
                <label for="sanPhamId" class="form-label">Tên SP</label>
                <select class="form-select" id="sanPhamId" name="sanPhamId">
                    <c:forEach items="${lis}" var="sp">
                        <option value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="nsxId" class="form-label">Nhà sản xuất</label>
                <select class="form-select" id="nsxId" name="nsxId">
                    <c:forEach items="${li}" var="spNsx">
                        <option value="${spNsx.id}">${spNsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="mauSacId" class="form-label">Màu Sắc</label>
                <select class="form-select" id="mauSacId" name="mauSacId">
                    <c:forEach items="${l}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="dongSPId" class="form-label">Dòng SP</label>
                <select class="form-select" id="dongSPId" name="dongSPId">
                    <c:forEach items="${dspht}" var="dsp">
                        <option value="${dsp.id}">${dsp.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="namBh" class="form-label">Năm bảo hành</label>
                <input type="text" class="form-control" id="namBh" name="namBh">
            </div>
            <div class="mb-3">
                <label for="moTa" class="form-label">Mô tả</label>
                <input type="text" class="form-control" id="moTa" name="moTa">
            </div>
            <div class="mb-3">
                <label for="soLuongTon" class="form-label">Số lượng tồn</label>
                <input type="text" class="form-control" id="soLuongTon" name="soLuongTon">
            </div>
            <div class="mb-3">
                <label for="giaNhap" class="form-label">Giá nhập</label>
                <input type="number" class="form-control" id="giaNhap" name="giaNhap">
            </div>
            <div class="mb-3">
                <label for="giaBan" class="form-label">Giá bán</label>
                <input type="number" class="form-control" id="giaBan" name="giaBan">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
    </div>
    <div class="table-container">
        <h2>Product List</h2>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>ID Sản phẩm</th>
                <th>Nhà Sản Xuât</th>
                <th>Màu Sắc</th>
                <th>Dòng SP</th>
                <th>Năm Bảo Hành</th>
                <th>Mô Tả</th>
                <th>Số Lượng Tồn</th>
                <th>Giá Bán</th>
                <th>Giá Nhập</th>
                <th>Tên SP</th>
                <th>Mã SP</th>
                <th>Hành Động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${spct}" var="sp">
                <tr>
                    <td>${sp.id}</td>
                    <td>${sp.namBh}</td>
                    <td>${sp.moTa}</td>
                    <td>${sp.soLuongTon}</td>
                    <td>${sp.giaBan}</td>
                    <td>${sp.giaNhap}</td>
                    <td>
                        <a href="/san-pham/xoa/${sp.id}" class="btn btn-danger btn-custom">Delete</a>
                        <a href="/san-pham/ud/${sp.id}" class="btn btn-warning btn-custom">Update</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
