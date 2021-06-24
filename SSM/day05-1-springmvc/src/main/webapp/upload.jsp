<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 0015
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/uploadOne" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="userName" ><br>
    年龄：<input type="text" name="age"><br>
    头像：<input type="file" name="headImg"><br>
    <input type="submit" value="提交">
</form>

<form action="/uploadMany" method="post" enctype="multipart/form-data">
    姓名：<input type="text" name="userName" ><br>
    年龄：<input type="text" name="age"><br>
    简历：<br>
    简历1：<input type="file" name="resumes">简历2：<input type="file" name="resumes"><br>
    <input type="submit" value="提交"><br>
    <%--头像：<input type="file" name="headImg"><br>--%>
</form>

</body>
</html>
