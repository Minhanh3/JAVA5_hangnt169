<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý Đặt Phòng</h1>
<form action="/dat-phong/update/${datPhong.id}" method="post">
    <div class="mb-3">
        <label for="" class="form-label">Mã</label>
        <input type="text" class="form-control" value="${datPhong.ma}" name="ma" aria-describedby="emailHelp">
    </div>
    <div>
        <%--        <select class="form-select" aria-label="Default select example">--%>
        <%--            <option selected>Open this select menu</option>--%>
        <%--            <c:forEach items="${phongs.khachHang.ma}">--%>
        <%--                <option value="1">One</option>--%>
        <%--            </c:forEach>--%>
        <%--        </select>--%>
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Ngày Tạo</label>
        <input type="date" class="form-control" value="${datPhong.ngayTao}" id="" name="ngayTao">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Tên phòng đăt</label>
        <input type="text" class="form-control" value="${datPhong.ten}" name="ten">
    </div>
    <div class="mb-3">
        <label for="" class="form-label">Ghi chú</label>
        <input type="text" class="form-control" value="${datPhong.ghiChu}" name="ghiChu">
    </div>
    Trạng thái
    <div class="mb-3">
        <input type="radio" class="form-control" value="1" ${datPhong.trangThai == 1 ? "checked" : ""} id="" name="trangThai">
        <label for="" class="form-label">Hoạt động</label>
        <input type="radio" class="form-control" value="0" ${datPhong.trangThai == 0 ? "checked" : ""} id="" name="trangThai">
        <label for="" class="form-label">Ngừng Hoạt động</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>