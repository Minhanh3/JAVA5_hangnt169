<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <form action="/giang-vien/search" method="get">
        Tên: <input name="ten"/>
        <button type="submit">Search</button>
    </form>
    <br/>
    <button><a href="/giang-vien/hien-thi">Trang list</a></button>
    <button><a href="">Add Giang Vien</a></button>
    <button><a href="/giang-vien/giang-vien-nu">Giang Vien nữ</a></button>
    <tr>
        <th>Id</th>
        <th>Ma</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="gv" varStatus="i">
        <tr>
            <th>${gv.id}</th>
            <th>${gv.ma}</th>
            <th>${gv.tuoi}</th>
            <th>${gv.ten}</th>
            <th>${gv.gioiTinh ? "Nam" : "Nữ"}</th>
            <th>${gv.diaChi}</th>
            <th colspan="2">
                <a href="/giang-vien/remove/${gv.id}">Delete</a>
                <a href="/giang-vien/detail">Detail</a>
                <a href="/giang-vien/view-update">Update</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
