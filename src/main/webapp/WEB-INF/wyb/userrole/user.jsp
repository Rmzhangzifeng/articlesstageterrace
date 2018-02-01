<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/31
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        指派成员：
        <br><c:forEach items="${list}" var="e">

            <input type="radio" id="checkuser" name="check" value="${e.userid}">${e.username}<br>

        </c:forEach>
    </div>
</div>
</body>
</html>
