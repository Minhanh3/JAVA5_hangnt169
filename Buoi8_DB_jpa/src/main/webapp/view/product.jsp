<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý Product</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>product Code</th>
        <th>product Name</th>
        <th>price</th>
        <th>description</th>
        <th>category Code</th>
        <th>category Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="cs">
        <tr>
            <th>${cs.id}</th>
            <th>${cs.productCode}</th>
            <th>${cs.productName}</th>
            <th>${cs.price}</th>
            <th>${cs.description}</th>
            <th>${cs.category.categoryCode}</th>
            <th>${cs.category.categoryName}</th>
            <th>
                <a href="/product/remove/${cs.id}">
                    <button>Remove</button>
                </a>
                <a href="/product/edit/${cs.id}">
                    <button>Update</button>
                </a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>