<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Register</h1>
    <form action="/reg" method="post">
        <label>Username:</label>
        <input type="text" name="username" required>
        <br><br>
        <label>Password:</label>
        <input type="password" name="password" required>
        <br><br>
        <input type="submit" value="register">
    </form>
    &nbsp;&nbsp;
    <a href="/index">Back to home page</a>
    &nbsp;&nbsp;
    <a href="/login">Log in</a>
</body>
</html>
