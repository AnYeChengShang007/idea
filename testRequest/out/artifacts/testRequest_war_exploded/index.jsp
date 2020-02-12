<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>index</title>
    </head>
    <body>
        <a href="servlet">请求连接点击</a>
        <form action="servlet" method="post">
            <input name="username" type="text"/>用户名<br/>
            <input name="password" type="password"/>密码<br/>
            爱好:
            <input type="checkbox" name="hobby" value="study"/>study<br/>
            <input type="checkbox" name="hobby" value="game"/>game<br/>
            <input type="submit" value="提交">
        </form>
    </body>
</html>
