<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý cơ sở</h1>
<form action="/co-so/search" method="get">
    <label for="">Tìm kiếm</label>
    <label for="">Mã/Tên cơ sở</label> <input type="text" name="ma">
    <button type="submit">Tìm Kiếm</button>
</form>

<form action="/co-so/add" method="post">
    <div class="container">
        <label for=""><b>Ma</b></label>
        <input type="text" placeholder="Enter Username" name="ma">
        <br>
        <label for=""><b>ten</b></label>
        <input type="text" placeholder="Enter Password" name="ten">
        <br>

        <label for=""><b>dienTich</b></label>
        <input type="number" name="dienTich">
        <br>

        <label for=""><b>Loai</b></label>
        <select class="form-select" aria-label="Default select example" name="loai">
            <option value="1" ${cs.loai}>1</option>
            <option value="2" ${cs.loai}>2</option>
            <option value="3" ${cs.loai}>3</option>
        </select>

        <br>
        <label for=""><b>trangThai</b></label>
        <input type="radio" name="trangThai" value="true" checked> Hoạt Động
        <input type="radio" name="trangThai" value="false"> Ngừng Hoạt Động
        <br>

        <button type="submit">ADD CƠ SỞ</button>
    </div>
</form>

<table>
    <thead>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Trang Thai</th>
        <th>Dien Tich</th>
        <th>Loai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="cs">
        <tr>
            <th>${cs.ma}</th>
            <th>${cs.ten}</th>
            <th>${cs.trangThai}</th>
            <th>${cs.dienTich}</th>
            <th>${cs.loai}</th>
            <th>
                <a href="/co-so/remove/${cs.ma}">
                    <button>Remove</button>
                </a>
                <a href="/co-so/view-update/${cs.ma}">
                    <button>Update</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>