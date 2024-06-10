<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <li><a class="dropdown-item" href="#">Service 2</a></li>
            <li><a class="dropdown-item" href="#">Service 3</a></li>
        </ul>
    </div>
    <a href="#">Contact</a>
    <a href="#" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>
</div>

<div class="content ">
    <h1>Dong San Pham</h1>
    <div class="d-flex justify-content-between align-items-center mb-3 mt-5">
        <div class="input-group w-50">
            <input type="text" class="form-control" placeholder="Tìm kiếm sản phẩm...">
            <button class="btn btn-primary" type="button">Tìm kiếm</button>
        </div>
        <a href="#" class="btn btn-success">Thêm mới</a>
    </div>
    <div>
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <td class="text-center">ID</td>
                <td class="text-center">Mã</td>
                <td class="text-center">Tên</td>
                <td class="text-center">Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dongSp}" var="cs">
                <tr>
                    <th class="text-center">${cs.id}</th>
                    <th class="text-center">${cs.ma}</th>
                    <th class="text-center">${cs.ten}</th>
                    <th class="text-center">
                        <a href="/co-so/remove/${cs.id}">
                            <button class="btn btn-primary btn-sm">Remove</button>
                        </a>
                        <a href="/co-so/view-update/${cs.id}">
                            <button class="btn btn-primary btn-sm">Update</button>
                        </a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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