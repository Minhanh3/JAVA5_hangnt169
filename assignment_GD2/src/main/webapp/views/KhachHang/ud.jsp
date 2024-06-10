<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cập nhật Khách Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
    <h2 class="mb-4">Cập nhật Khách Hàng</h2>
    <form action="/khach-hang/ud/${id}" method="post" class="row g-3">
        <div class="col-md-6">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${pb.id}">
        </div>
        <div class="col-md-6">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${pb.ma}">
        </div>
        <div class="col-md-6">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${pb.ten}">
        </div>
        <div class="col-md-6">
            <label for="tenDem" class="form-label">Tên đệm</label>
            <input type="text" class="form-control" id="tenDem" name="tenDem" value="${pb.tenDem}">
        </div>
        <div class="col-md-6">
            <label for="ho" class="form-label">Họ</label>
            <input type="text" class="form-control" id="ho" name="ho" value="${pb.ho}">
        </div>
        <div class="col-md-6">
            <label for="ngaySinh" class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="${pb.ngaySinh}">
        </div>
        <div class="col-md-6">
            <label for="sdt" class="form-label">Số Điện Thoại</label>
            <input type="tel" class="form-control" id="sdt" name="sdt" value="${pb.sdt}">
        </div>
        <div class="col-md-6">
            <label for="diaChi" class="form-label">Địa Chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" value="${pb.diaChi}">
        </div>
        <div class="col-md-6">
            <label for="thanhPho" class="form-label">Thành Phố</label>
            <input type="text" class="form-control" id="thanhPho" name="thanhPho" value="${pb.thanhPho}">
        </div>
        <div class="col-md-6">
            <label for="quocGia" class="form-label">Quốc Gia</label>
            <input type="text" class="form-control" id="quocGia" name="quocGia" value="${pb.quocGia}">
        </div>
        <div class="col-md-6">
            <label for="matKhau" class="form-label">Mật Khẩu</label>
            <input type="password" class="form-control" id="matKhau" name="matKhau" value="${pb.matKhau}">
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Cập Nhật</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
