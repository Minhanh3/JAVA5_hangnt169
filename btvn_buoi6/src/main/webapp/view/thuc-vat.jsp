<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/thuc-vat/search" method="get">
        Tên: <input name="ten"/> <br>
        Tuổi : <br>
<%--        Min <input name="tuoi"/> <br>--%>
<%--        Max <input name="tuoi"/> <br>--%>
        <button type="submit">Search</button>
    </form>
</div>
<div>
    <form action="/thuc-vat/add" method="post">
        ID: <input type="text" name="id" value="${tv.id != null ? tv.id : ''}"/>
        <br/>
        Loai cay: <input type="text" name="loaiCay" value="${tv.loaiCay != null ? tv.loaiCay : ''}"/>
        <br/>
        Tên: <input type="text" name="ten" value="${tv.ten != null ? tv.ten : ''}"/>
        <br/>
        Số tuổi: <input type="text" name="tuoi" value="${tv.tuoi != null ? tv.tuoi : ''}"/>
        <br/>
        Khu vực: <input type="text" name="khuVuc" value="${tv.khuVuc != null ? tv.khuVuc : ''}"/>
        <br/>
        Giới tính:
        <input type="radio" name="gioiTinh" value="true" ${tv.gioiTinh} checked/> Nam
        <input type="radio" name="gioiTinh" value="false" ${tv.gioiTinh}/> Nữ
        <br/>
        <button type="submit">Add</button>
    </form>
</div>

<br/>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>loai Cay</th>
        <th>ten</th>
        <th>tuoi</th>
        <th>gioi Tinh</th>
        <th>khu Vuc</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="tv" varStatus="i">
        <tr>
            <th>${tv.id}</th>
            <th>${tv.loaiCay}</th>
            <th>${tv.ten}</th>
            <th>${tv.tuoi}</th>
            <th>${tv.gioiTinh ? "Nam" : "Nữ"}</th>
            <th>${tv.khuVuc}</th>
            <th colspan="2">
                <a href="/thuc-vat/view-update/${tv.id}">
                    <button>Update</button>
                </a>
                <a href="/thuc-vat/remove/${tv.id}">
                    <button>Delete</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
