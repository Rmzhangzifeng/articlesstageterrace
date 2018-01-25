<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/22
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <c:forEach items="${list}" var="e">

            <a href="javascript:addurl(${e.picphotoid})"><img src='<%=request.getContextPath()%>${e.picphotourl}' style='width:60px;height:60px'> </a>

        </c:forEach>
        <form id="update-form">
          <input type="hidden" name="picorganizeid" value="${id}">
          <input type="hidden" name="piccover" id="piccover-id">
        </form>
    <script>

        function addurl(id){

            $("[name='piccover']").val(id)
        }

    </script>

</body>
</html>
