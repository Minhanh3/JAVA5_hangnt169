<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .modal-content {
            width: 300px;
        }

        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            background-color: #343a40;
            padding: 20px;
        }

        .sidebar a {
            display: block;
            color: #fff;
            text-decoration: none;
            padding: 10px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #474c50;
        }

        .content {
            margin-left: 200px;
            padding: 20px;
        }
        .sidebar .dropdown-menu {
            background-color: #474c50;
            border: none;
            margin-left: 20px;
        }

        .sidebar .dropdown-item {
            color: #fff;
            padding: 10px 20px;
            transition: background-color 0.3s;
        }
        .sidebar .dropdown-item:hover {
            background-color: #343a40;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <a href="/" class="active">Home</a>
    <a href="/nhan-vien/hien-thi">Trang Nhân Viên</a>
    <div class="dropdown">
        <a class="dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
            Quản lý Sản Phẩm
        </a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/san-pham/hien-thi">Sản Phẩm</a></li>
            <li><a class="dropdown-item" href="/mau-sac/hien-thi">Màu Sắc</a></li>
            <li><a class="dropdown-item" href="/dong-sp/hien-thi">Dong San Pham</a></li>
            <li><a class="dropdown-item" href="/nsx/hien-thi">Nhà Sản Xuất</a></li>
        </ul>
    </div>
    <a href="#">Contact</a>
    <a href="#" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>
</div>

<div class="content">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-10">
                <form action="/san-pham/addSanPham" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <h2>Thông tin sản phẩm</h2>
                            <div class="mb-3">
                                <label for="ma" class="form-label">Mã sản phẩm</label>
                                <input type="text" class="form-control" id="ma" name="ma" required>
                            </div>
                            <div class="mb-3">
                                <label for="ten" class="form-label">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="ten" name="ten" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h2>Chi tiết sản phẩm</h2>
                            <div class="mb-3">
                                <label for="idNsx" class="form-label">Nhà sản xuất</label>
                                <select class="form-select" id="idNsx" name="idNsx" required>
                                    <option value="">Chọn nhà sản xuất</option>
                                    <c:forEach items="${dsNsx}" var="nsx">
                                        <option value="${nsx.id}">${nsx.ten}</option>
                                    </c:forEach>
                                    <!-- Các tùy chọn nhà sản xuất -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="idMauSac" class="form-label">Màu sắc</label>
                                <select class="form-select" id="idMauSac" name="idMauSac" required>
                                    <option value="">Chọn màu sắc</option>
                                    <c:forEach items="${dsMauSac}" var="mauSac">
                                        <option value="${mauSac.id}">${mauSac.ten}</option>
                                    </c:forEach>
                                    <!-- Các tùy chọn màu sắc -->
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="idDongSp" class="form-label">Dòng sản phẩm</label>
                                <select class="form-select" id="idDongSp" name="idDongSp" required>
                                    <option value="">Chọn dòng sản phẩm</option>
                                    <c:forEach items="${dsDongSp}" var="dongSp">
                                        <option value="${dongSp.id}">${dongSp.ten}</option>
                                    </c:forEach>
                                    <!-- Các tùy chọn dòng sản phẩm -->
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="namBh" class="form-label">Năm bảo hành</label>
                                <input type="number" class="form-control" id="namBh" name="namBh" required>
                            </div>
                            <div class="mb-3">
                                <label for="moTa" class="form-label">Mô tả</label>
                                <textarea class="form-control" id="moTa" name="moTa" rows="3"></textarea>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mb-3">
                                <label for="soLuongTon" class="form-label">Số lượng tồn</label>
                                <input type="number" class="form-control" id="soLuongTon" name="soLuongTon" required>
                            </div>
                            <div class="mb-3">
                                <label for="giaNhap" class="form-label">Giá nhập</label>
                                <input type="number" class="form-control" id="giaNhap" name="giaNhap" required>
                            </div>
                            <div class="mb-3">
                                <label for="giaBan" class="form-label">Giá bán</label>
                                <input type="number" class="form-control" id="giaBan" name="giaBan" required>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </form>
            </div>
        </div>
    </div>
    <footer class="bg-dark text-light py-3">
        <div class="container">
            <p>&copy; 2023 My Website</p>
        </div>
    </footer>
</div>
<!-- Modal dialog đăng nhập -->
<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Login</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>
    <!-- Không thay đổi phần này -->
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>