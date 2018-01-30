<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/30
  Time: 11:51
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
        <input type="hidden" id="user-id" value="${user.userid}">
        <c:forEach items="${list}" var="e">

            <input type="radio" id="checkrole" name="check" value="${e.roleid}" ${e.roleid==user.userroleid ?'checked':''}>${e.rolename}<br>

        </c:forEach>
    </div>
</div>
</body>
</html>
