<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/18
  Time: 16:52
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
        <div class="col-md-12 column">
           <form id="group-form">
                <table>
                    <tr>
                        <td>话题名称</td>
                        <td><input type="text" name="picgrouptitle"><input type="hidden" name="typeid" id="type-id"></td>
                    </tr>
                    <tr>
                        <td><button type="button" class="btn btn-primary btn-default" onclick="tianjia()">添加图片</button></td>
                        <td><div id="show-ids"></div><input type="hidden" id="group-ids" name="picid"><input type="hidden" id="picphoto-id" value="${po}"></td>
                    </tr>
                </table>
           </form>
        </div>
    </div>
</div>
<script>
    var ids="";
    function tianjia(){
        BootstrapDialog.show({
            title: 'Default Title',
            message: $('<div></div>').load('/getPicPhotos'),
            buttons: [{
                label: '保存',
                action: function(dialog) {

                    $.ajax({
                        url:"/AddPicPhoto",
                        type:"post",
                        data:$("#photo-form").serialize(),
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data!=null){
                               ids  += ","+data;
                                var ids1=ids.substr(1);
                                $("#group-ids").val(ids1);
                                dialog.close();
                            }else{
                                BootstrapDialog.show({
                                    title: 'Default Title',
                                    message: $('<div>上传失败</div>'),
                                });
                            }
                        },
                        error:function(){
                            alert("查询出错");
                        }
                    });
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
