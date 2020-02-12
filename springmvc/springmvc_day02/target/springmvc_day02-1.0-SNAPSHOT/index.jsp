<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    contentType:"application/json;chartset=utf-8",
                    data:'{"username":"张三","sex":"男"}',
                    dataType:"json",
                    url:"user/testAjax",
                    type:"POST",
                    success:function(data){
                       alert(data);
                       alert(data.id);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <form method="post" action="user/testModelAndView">
        姓名:<input type="text" name="username"/><br>
        年龄:<input type="text" name="sex"/><br>
        <input type="submit" value="submit"/>
    </form>
    <br>
    <button id="btn">testAjax</button>
    <br/>
    <form method="post" enctype="multipart/form-data" action="user/testFileUpload">
        <input type="file" name="file"/>
        <input type="submit" value="测试传统文件上传"/>
    </form>
    <br/>
    <form method="post" enctype="multipart/form-data" action="user/testFileUpload2">
        <input type="file" name="file"/>
        <input type="submit" value="springmvc方式上传"/>
    </form>
    <form method="post" enctype="multipart/form-data" action="user/testFileUpload3">
        <input type="file" name="file"/>
        <input type="submit" value="springmvc跨服务器方式上传"/>
    </form>
    <a href="user/testSysException">testSysception</a><br/>
    <a href="user/testInterceptor">testInterceptor</a>
</body>
</html>
