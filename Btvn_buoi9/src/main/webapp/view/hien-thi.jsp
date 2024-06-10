<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý lopHocRepository</h1>

<form action="/add" method="post">
    <div class="container">
        <label><b>id</b></label>
        <input type="text" placeholder="Enter id" name="id" >
        <br>
        <label><b>name</b></label>
        <input type="text" placeholder="Enter name" name="name" >
        <br>
        <label><b>dia Diem Lop Hoc</b></label>
        <input type="text" placeholder="Enter diaDiemLopHoc" name="diaDiemLopHoc" >
        <br>
        <button type="submit">add</button>
    </div>
</form>
<table>
    <thead>
    <tr>
        <th>ID lớp</th>
        <%--        <th>Mã Lớp</th>--%>
        <th>Tên lớp</th>
        <th>Địa điểm lớp học</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="cs">
        <tr>
            <th>${cs.id}</th>
            <th>${cs.name}</th>
            <th>${cs.diaDiemLopHoc}</th>
            <th>
                <a href="/lop-hoc/delete/${cs.id}">
                    <button>Remove</button>
                </a>
                <a href="/lop-hoc/view-update/${cs.id}">
                    <button>Update</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>