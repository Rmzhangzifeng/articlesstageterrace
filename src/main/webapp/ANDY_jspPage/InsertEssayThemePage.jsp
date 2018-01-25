<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/23
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <form id="EssayTheme-addform">
            标题：<input type="text" name="title"><br/><br/>
            内容：<textarea cols="78" rows="4" name="themecontent"></textarea><br/><br/>
            结束时间：<input type="text" name="endTimeStr" id="EssayThemeendTimeStr">
        </form>

<script>
    var date = new Date();
    $("#EssayThemeendTimeStr").datetimepicker({
        startDate: date,
        format: 'yyyy-mm-dd'
    });
</script>
</body>
</html>
