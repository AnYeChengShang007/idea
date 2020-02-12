<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function(){
           $("#btn").click(function(){
               alert("nihao");
           });
        });
    </script>
</head>
<body>
    <a href="user/findAll.action">点击这里</a>
    <button id="btn" type="button">单击</button>
</body>
</html>
