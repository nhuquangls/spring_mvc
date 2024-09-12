<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <label>
            <span>Username</span>
            <input type="text" name="username">
        </label><br>
        <label>
            <span>Password</span>
            <input type="text" name="password">
        </label>
        <button type="submit">submit</button>
    </form>
    <br>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>

</body>
</html>
