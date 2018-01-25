<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/23
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="ArticleDiscuss-updateform">
        <input type="hidden" name="discussid" value="${updiscussDate.discussid}">
        评论内容：<textarea name="discusscontent"  cols="79" rows="5">${updiscussDate.discusscontent}</textarea>
    </form>
</body>
</html>
