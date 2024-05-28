<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <div>
        <form action="/giang-vien/searchName" method="get">
            Tên: <input name="ten"/> <br>
<%--            Tuổi : <br>--%>
<%--            Min <input name="tuoi"/> <br>--%>
<%--            Max <input name="tuoi"/> <br>--%>
            <button type="submit">Search</button>
        </form>
    </div>
    <div>
        <form action="/giang-vien/add" method="post">
            Ma giang vien: <input type="text" name="maGV" value="${gv.maGV}" />
            <br/>
            Tên: <input type="text" name="ten" value="${gv.ten}"/>
            <br/>
            Tuổi: <input type="text" name="tuoi" value="${gv.tuoi}"/>
            <br/>
            Quê quán: <input type="text" name="queQuan" value="${gv.queQuan}"/>
            <br/>
            <button type="submit">Add</button>
        </form>
    </div>
    <br/>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma giang vien</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="gv" varStatus="i">
        <tr>
            <th>${i.index + 1}</th>
            <th>${gv.maGV}</th>
            <th>${gv.ten}</th>
            <th>${gv.tuoi}</th>
            <th>${gv.queQuan}</th>
            <th colspan="2">
                <a href="/giang-vien/delete/${gv.maGV}">Delete</a>
                <a href="/giang-vien/detail/${gv.maGV}">Detail</a>
                <a href="/sinh-vien/view-update/${gv.maGV}">Update</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
