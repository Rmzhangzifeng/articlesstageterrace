<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/23
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="EssayTheme-updateform">
            <input type="hidden" value="${upessay.articletopicid}" name="articletopicid"/>
        标题：<input type="text" name="title" value="${upessay.title}"><br/><br/>
        内容：<textarea cols="78" rows="4" name="themecontent">${upessay.themecontent}</textarea><br/><br/>
    </form>

</body>
</html>
