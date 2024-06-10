<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý Category</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Mã Category</th>
        <th>Tên</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="cs">
        <tr>
            <th>${cs.id}</th>
            <th>${cs.categoryCode}</th>
            <th>${cs.categoryName}</th>
            <th>
                <a href="/co-so/remove/${cs.id}">
                    <button>Remove</button>
                </a>
                <a href="/co-so/view-update/${cs.id}">
                    <button>Update</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>