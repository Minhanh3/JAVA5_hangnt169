<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Quản lý cơ sở UPDATE</h1>
<form:form modelAttribute="coSo" action="/co-so/update" method="post">
    <div class="container">
        <label for=""><b>Ma</b></label>
        <form:input path="ma" />

        <br>
        <label for=""><b>ten</b></label>
        <form:input path="ma" />
        <br>

        <label for=""><b>dienTich</b></label>
        <form:input path="ma" />
        <br>

        <label for=""><b>Loai</b></label>
        <form:select class="form-select" aria-label="Default select example" path="loai">
            <option value="1" ${cs.loai}>1</option>
            <option value="2" ${cs.loai}>2</option>
            <option value="3" ${cs.loai}>3</option>
        </form:select>

        <br>
        <label for=""><b>trangThai</b></label>
        <input type="radio" name="trangThai" value="true" ${cs.trangThai ? "checker" : ''} checked> Hoạt Động
        <input type="radio" name="trangThai" value="false" ${!cs.trangThai ? "checker" : ''}> Ngừng Hoạt Động
        <br>

        <button type="submit">Update</button>
    </div>
</form:form>
</body>
</html>