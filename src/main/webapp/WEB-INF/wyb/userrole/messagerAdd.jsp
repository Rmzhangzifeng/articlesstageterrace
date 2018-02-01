<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/31
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <form id="messager-form">

            <input type="hidden" name="messagertitle" value="${p.picgrouptitle}">
            <input type="hidden" name="messagerecipientuser" value="${p.picname}">
            评论：<textarea name="messagecontent"></textarea>


        </form>
    </div>
</div>
</body>
</html>
