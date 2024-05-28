<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form:form action="/ket-qua" method="post" modelAttribute="dangKyRequest">
    <div>
        <label><b>Ma sinh vien:</b></label>
        <form:input path="mssv"/>
        <form:errors path="mssv"/> <br>

        Họ và tên:
        <form:input path="hoVaTen"/>
        <form:errors path="hoVaTen"/> <br>

        Tuổi:
        <form:input path="tuoi"/>
        <form:errors path="tuoi"/> <br>

        Giói tính :
        <form:radiobutton path="gioiTinh" value="Nam" label="Nam"/>
        <form:radiobutton path="gioiTinh" value="Nữ" label="Nữ"/>
        <form:errors path="gioiTinh"/> <br>

        Kỳ học :
        <form:select path="kyHoc">
            <form:option value="1" label="1"/>
            <form:option value="2" label="2"/>
            <form:option value="3" label="3"/>
            <form:option value="4" label="4"/>
            <form:option value="5" label="5"/>
            <form:option value="6" label="6"/>
            <form:option value="7" label="7"/>
            <%--        <form:options items = "${listPosition}" />--%>
        </form:select>
        <form:errors path="kyHoc"/> <br>

        Ngành học:
        <form:input path="nganhHoc"/>
        <form:errors path="nganhHoc"/> <br>

        Quê quán:
        <form:input path="queQuan"/>
        <form:errors path="queQuan"/> <br>

        Mật khẩu:
        <form:input path="matKhau"/>
        <form:errors path="matKhau"/> <br>

        Xác nhận mật khẩu:
        <form:input path="cfMatKhau"/>
        <form:errors path="cfMatKhau"/> <br>

        <form:button type="submit">Đăng ký</form:button>
    </div>
</form:form>

</body>
</html>