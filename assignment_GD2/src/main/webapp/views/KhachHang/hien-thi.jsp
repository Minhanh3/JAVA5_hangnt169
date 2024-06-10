<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quản lý Khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container my-4">
    <h2 class="mb-4">Thêm Khách hàng</h2>
    <form action="/khach-hang/add" method="post" class="row g-3">
        <div class="col-md-4">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="col-md-4">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma">
        </div>
        <div class="col-md-4">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten">
        </div>
        <div class="col-md-4">
            <label for="tenDem" class="form-label">Tên đệm</label>
            <input type="text" class="form-control" id="tenDem" name="tenDem">
        </div>
        <div class="col-md-4">
            <label for="ho" class="form-label">Họ</label>
            <input type="text" class="form-control" id="ho" name="ho">
        </div>
        <div class="col-md-4">
            <label for="ngaySinh" class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" required>
        </div>
        <div class="col-md-4">
            <label for="sdt" class="form-label">SĐT</label>
            <input type="tel" class="form-control" id="sdt" name="sdt">
        </div>
        <div class="col-md-4">
            <label for="diaChi" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi">
        </div>
        <div class="col-md-4">
            <label for="thanhPho" class="form-label">Thành phố</label>
            <input type="text" class="form-control" id="thanhPho" name="thanhPho">
        </div>
        <div class="col-md-4">
            <label for="quocGia" class="form-label">Quốc gia</label>
            <input type="text" class="form-control" id="quocGia" name="quocGia">
        </div>
        <div class="col-md-4">
            <label for="matKhau" class="form-label">Mật khẩu</label>
            <input type="text" class="form-control" id="matKhau" name="matKhau">
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Thêm</button>
        </div>
    </form>

    <h2 class="mt-5">Danh sách Khách hàng</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Tên đệm</th>
            <th>Họ</th>
            <th>Ngày sinh</th>
            <th>SĐT</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Mật khẩu</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="pb">
            <tr>
                <td>${pb.id}</td>
                <td>${pb.ma}</td>
                <td>${pb.ten}</td>
                <td>${pb.tenDem}</td>
                <td>${pb.ho}</td>
                <td>${pb.ngaySinh}</td>
                <td>${pb.sdt}</td>
                <td>${pb.diaChi}</td>
                <td>${pb.thanhPho}</td>
                <td>${pb.quocGia}</td>
                <td>${pb.matKhau}</td>
                <td>
                    <a href="/khach-hang/delete/${pb.id}" class="btn btn-danger btn-sm">Xóa</a>
                    <a href="/khach-hang/ud/${pb.id}" class="btn btn-warning btn-sm">Cập nhật</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
