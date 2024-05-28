<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="">Add Student</a></button>
    <thead>
    <tr>
        <th>ID</th>
        <th>Ma</th>
        <th>Tên</th>
        <th>Tên Đệm</th>
        <th>Họ</th>
        <th>Giới tính</th>
        <th>ngay Sinh</th>
        <th>dia Chi</th>
        <th>sdt</th>
        <th>mat Khau</th>
        <th>trang Thai</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nhanVien}" var="nv">
        <th>${nv.id}</th>
        <th>${nv.ma}</th>
        <th>${nv.ten}</th>
        <th>${nv.tenDem}</th>
        <th>${nv.ho}</th>
        <th>${nv.gioiTinh}</th>
        <th>${nv.ngaySinh}</th>
        <th>${nv.diaChi}</th>
        <th>${nv.sdt}</th>
        <th>${nv.matKhau}</th>
        <th>${nv.trangThai}</th>
        <th colspan="2">Action</th>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
