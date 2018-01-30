<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/30
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <script>

        $(function (){
            BootstrapDialog.show({
                title: '提示页面',
                message:"你不具备此权限",
                buttons: [{
                    label: '取消',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
        })

    </script>
</body>
</html>
