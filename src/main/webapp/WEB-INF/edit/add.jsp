<%--
  Created by IntelliJ IDEA.
  User: 快乐
  Date: 2018/1/22
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="edits-form">
    <center>
        <div class="alert alert-success" id="massegeedits"></div>
        <br><br>
        <h1>新增菜单</h1><br>
        菜单名：<input type="text" name="edittext"><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;属于：<input type="text" onclick="queryedits()" id="editstext">
        <input type="hidden" id="editsid" name="editpid"><br><br>
        <input type="button" value="新增" onclick="insertedits()" class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="reset" value="取消" class="btn btn-default">
    </center>
</form>


<script>
    function insertedits() {
        $.ajax({
            url:"/insertedits",
            type:"post",
            data:$("#edits-form").serialize(),
            dataType:"text",
            success:function (a) {
                if(a>0){
                    $("#massegeedits").html("新增成功")
                }
            }
        })
    }
    function queryedits() {
        BootstrapDialog.show({
            title: '菜单树',
            message: $('<div></div>').load('/editshow'),
            buttons: [{
                label: '确定',
                action: function(dialog) {
                    dialog.close();
                }
            }, {
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }
</script>
</body>
</html>
