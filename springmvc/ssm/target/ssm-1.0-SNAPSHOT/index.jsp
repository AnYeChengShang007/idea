<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <a href="account/findAll">testFindAll</a>
    <form action="account/insert" method="post">
        name :<input type="text" name="username" />
        money:<input type="text" name="money"/>
        <input type="submit"/>
    </form>
 </body>
</html>
