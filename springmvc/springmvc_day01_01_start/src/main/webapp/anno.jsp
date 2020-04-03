<%--
  Created by IntelliJ IDEA.
  User: liguoliang
  Date: 2019/9/23
  Time: 11:09 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 常用的注解 --%>
<a href="anno/testRequestParam?name=哈哈">RequestParam</a><br/><br/>

<form action="anno/testRequestBody" method="post">
    用户姓名: <input type="text" name="uname"/><br/>
    用户年龄: <input type="number" name="age"/><br/>
    <input type="submit" value="提交"/>
</form><br/>

<%-- 常用的注解 --%>
<a href="anno/testPathVariable/10">testPathVariable</a><br/>


<a href="anno/testRequestHeader">testRequestHeader</a><br/>


<a href="anno/testCookieValue">testCookieValue</a><br/>

<form action="anno/testModelAttribute" method="post">
    用户姓名: <input type="text" name="uname"/><br/>
    用户年龄: <input type="number" name="age"/><br/>
    <input type="submit" value="提交"/>
</form><br/>



<a href="anno/testSessionAttributes">testSessionAttributes</a><br/>


<a href="anno/getSessionAttributes">getSessionAttributes</a><br/>

<a href="anno/delSessionAttributes">delSessionAttributes</a><br/>




</body>
</html>
