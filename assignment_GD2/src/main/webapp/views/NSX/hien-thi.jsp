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
    <form action="/NSX/add" method="post" class="mb-4">
        <div class="mb-3">
            <label for="id" class="form-label">ID</label>
            <input type="text" class="form-control" id="id" name="id" disabled>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Ten</label>
            <input type="text" class="form-control" id="ten" name="ten">
        </div>
        <div class="mb-3">
            <label for="ma" class="form-label">Ma</label>
            <input type="text" class="form-control" id="ma" name="ma">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>

    <h2 class="mb-4">Entries List</h2>
    <table class="table table-hover table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Ten</th>
            <th>Ma</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nsx">
            <tr>
                <td>${nsx.id}</td>
                <td>${nsx.ten}</td>
                <td>${nsx.ma}</td>
                <td>
                    <a href="/NSX/delete/${nsx.id}" class="btn btn-danger btn-sm me-2">Delete</a>
                    <a href="/NSX/update/${nsx.id}" class="btn btn-warning btn-sm">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
