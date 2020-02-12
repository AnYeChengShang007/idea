
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/product/findAll">查询所有商品信息</a>
    <jsp:forward page="/pages/main.jsp"></jsp:forward>
</body>
</html>
