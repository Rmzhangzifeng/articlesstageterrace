<%--
  Created by IntelliJ IDEA.
  User: 快乐
  Date: 2018/1/22
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="tree-edits"> </div>
<script>
    //获取数据
    function getTree(){
        var tree_data = "";
        $.ajax({
            url:"/queryeditsybq",
            type:"post",
            dataType:"json",
            async:false,
            success:function(data){
                tree_data = data;
            },
            error:function(){
                alert("查询出错");
            }
        });
        return tree_data;
    }
    $('#tree-edits').treeview(
        {
            data:getTree(),
            onNodeSelected:function(event,node){
                $("#editstext").val(node.text);
                $("#editsid").val(node.id)
            }
        })
</script>
</body>
</html>
