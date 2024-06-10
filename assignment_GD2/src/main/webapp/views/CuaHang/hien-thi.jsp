<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Add New Entry</h2>
    <form action="/cua-hang/add" method="post" class="mb-4">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Ten</label>
            <input type="text" class="form-control" id="ten" name="ten">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Ma</label>
            <input type="text" class="form-control" id="ma" name="ma">
        </div>
        <div class="mb-3">
            <label for="diaChi" class="form-label">Dia chi</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi">
        </div>
        <div class="mb-3">
            <label for="thanhPho" class="form-label">Thanh pho</label>
            <input type="text" class="form-control" id="thanhPho" name="thanhPho">
        </div>
        <div class="mb-3">
            <label for="quocGia" class="form-label">Quoc gia</label>
            <input type="text" class="form-control" id="quocGia" name="quocGia">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>

    <h2 class="mb-4">Entries List</h2>
    <table class="table table-hover table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>Dia chi</th>
            <th>Thanh pho</th>
            <th>Quoc gia</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="chang">
            <tr>
                <td>${chang.id}</td>
                <td>${chang.ma}</td>
                <td>${chang.ten}</td>
                <td>${chang.diaChi}</td>
                <td>${chang.thanhPho}</td>
                <td>${chang.quocGia}</td>
                <td>
                    <a href="/cua-hang/delete/${chang.id}" class="btn btn-danger btn-sm me-2">Delete</a>
                    <a href="/cua-hang/ud/${chang.id}" class="btn btn-warning btn-sm">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
