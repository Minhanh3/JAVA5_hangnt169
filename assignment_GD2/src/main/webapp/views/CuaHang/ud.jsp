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
    <h2 class="mb-4">Update New Entry</h2>
    <form action="/cua-hang/ud/${ch.id}" method="post" class="mb-4">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${ch.id}" disabled>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Ten</label>
            <input type="text" class="form-control" id="ten" name="ten" value="${ch.ten}" >
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Ma</label>
            <input type="text" class="form-control" id="ma" name="ma" value="${ch.ma}">
        </div>
        <div class="mb-3">
            <label for="diaChi" class="form-label">Dia chi</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" value="${ch.diaChi}">
        </div>
        <div class="mb-3">
            <label for="thanhPho" class="form-label">Thanh pho</label>
            <input type="text" class="form-control" id="thanhPho" name="thanhPho" value="${ch.thanhPho}">
        </div>
        <div class="mb-3">
            <label for="quocGia" class="form-label">Quoc gia</label>
            <input type="text" class="form-control" id="quocGia" name="quocGia" value="${ch.quocGia}">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
