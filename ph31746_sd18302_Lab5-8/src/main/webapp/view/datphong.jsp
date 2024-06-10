<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý Đặt Phòng</h1>
<form action="/dat-phong/addDatPhong" method="post">
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
    <div class="mb-3">
        Trạng thái:
        <label for="" class="form-label">Hoạt động</label>
        <input type="radio" class="form-control" value="1" ${datPhong.trangThai} id="" name="trangThai" checked>
        <br>
        <label for="" class="form-label">Ngừng Hoạt động</label>
        <input type="radio" class="form-control" value="0" ${datPhong.trangThai} id="" name="trangThai">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Mã kh</th>
        <th>Tên</th>
        <th>ngayTao</th>
        <th>trangThai</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${phongs}" var="cs">
        <tr>
            <th>${cs.id}</th>
            <th>${cs.ma}</th>
            <th>${cs.khachHang.ma}</th>
            <th>${cs.ten}</th>
            <th>${cs.ngayTao}</th>
            <th>${cs.trangThai == 1 ? "Hoạt Động" : "Ngừng Hoạt Động"}</th>
            <th>
                <a href="/dat-phong/delete/${cs.id}">
                    <button>Remove</button>
                </a>
                <a href="/dat-phong/view-update/${cs.id}">
                    <button>Update</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
