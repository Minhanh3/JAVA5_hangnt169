<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form action="/ket-qua" method="post">
        <div>
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname">
            <span style="color: red;">${unameError}</span>
        </div>
        <div>
            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw">
            <span  style="color: red;">${pswError}</span>
            <div>
                <button type="submit">Login</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
