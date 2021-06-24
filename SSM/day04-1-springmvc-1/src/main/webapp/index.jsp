<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 0013
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--测试发送数组--%>
<form action="/acc/array" method="get">
    小名：<br>
    杨幂：<input type="checkbox" name="names" value="杨幂"><br>
    柳岩：<input type="checkbox" name="names" value="柳岩"><br>
    刘亦菲<input type="checkbox" name="names" value="刘亦菲"><br>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
