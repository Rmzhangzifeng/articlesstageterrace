<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/23
  Time: 14:43
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
        <div class="col-md-12 column">
            <form id="jape-form">
                <input type="hidden" name="wybtypeid" value="${typeid}">
                <table>
                    <tr>
                        <td>标题</td>
                        <td><input type="text" name="wybjapename"></td>
                    </tr>
                    <tr>
                        <td>内容</td>
                        <td>
                            <textarea name="wybcontent"></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

</body>
</html>
