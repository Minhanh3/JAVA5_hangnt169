<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<form>

</form>
<table style="width: 50%; margin: auto; margin-top: 50px" class="table table-striped-columns">
    <thead>
        <tr style="text-align: center">
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
<%--            <th></th>--%>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="cate">
            <tr style="text-align: center">
                <td>${cate.id}</td>
                <td>${cate.categoryCode}</td>
                <td>${cate.categoryName}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>