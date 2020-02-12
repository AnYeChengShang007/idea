<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1>成功</h1>
    <c:forEach items="${list}" var="user">
        ${user.username}
    </c:forEach>
</body>
</html>
