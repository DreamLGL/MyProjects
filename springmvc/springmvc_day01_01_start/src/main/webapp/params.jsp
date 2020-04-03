<%--
  Created by IntelliJ IDEA.
  User: liguoliang
  Date: 2019/9/22
  Time: 9:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 请求参数绑定 --%>
<%--<a href="param/testParam?username=张三&password=123">请求参数绑定</a>--%>
<%--<form action="param/saveAccount" method="post">
    姓名: <input type="text" name="username"/><br/>
    密码: <input type="password" name="password"/><br/>
    金额: <input type="number" name="money"/><br/>
    用户姓名: <input type="text" name="user.uname"/><br/>
    用户年龄: <input type="number" name="user.age"/><br/>
    <input type="submit" value="提交"/>
</form>--%>

<%-- 把数据封装Account类中,类中存在list和map的集合 --%>
<%--<form action="param/saveAccount" method="post">
    姓名: <input type="text" name="username"/><br/>
    密码: <input type="password" name="password"/><br/>
    金额: <input type="number" name="money"/><br/>

    用户姓名: <input type="text" name="list[0].uname"/><br/>
    用户年龄: <input type="number" name="list[0].age"/><br/>

    用户姓名: <input type="text" name="map['one'].uname"/><br/>
    用户年龄: <input type="number" name="map['one'].age"/><br/>
    <input type="submit" value="提交"/>
</form>--%>

<%--<form action="param/saveUser" method="post">
    用户姓名: <input type="text" name="uname"/><br/>
    用户年龄: <input type="number" name="age"/><br/>
    用户生日: <input type="text" name="date"/><br/>
    <input type="submit" value="提交"/>
</form>--%>

<a href="param/testServlet">Servlet原生API</a>

</body>
</html>
