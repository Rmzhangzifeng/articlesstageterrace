<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/22
  Time: 14:24
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
            <form id="photo-form">
                <table>
                    <tr>
                        <td>上传图片</td>
                        <td><input type="file" id="upload" name="artImg">
                        <div id="show"></div><input type="hidden" id="picphoto-url" name="picphotourl"></td>
                    </tr>
                    <tr>
                        <td>图片简介</td>
                        <td>
                                <textarea name="piccontent"></textarea>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script>

    $("#upload").uploadify({
        //插件自带  不可忽略的参数
        'swf': '${pageContext.request.contextPath}/uploadify/uploadify.swf',
        //前台请求后台上传文件的url  不可忽略的参数
        'uploader': '<%=request.getContextPath()%>/uploadPhotoFile',
        //给div的进度条加背景  参数为<div>id属性值  不可忽略
        'queueID': 'fileQueue',
        //上传文件文件名   和file文件域的name属性一致   和后台接受的属性名对应
        'fileObjName' : 'artImg',
        //给上传按钮设置文字
        'buttonText': '上传',
        //如果为true 为自动上传  在选择文件后, 为false 那么它就要我们自己手动点上传按钮
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': false,
        //上传后队列是否消失
        'removeCompleted': true,
        //队列消失时间
        'removeTimeout' : 1,
        //最大上传文件数量
        'uploadLimit':  10,
        //制定可以文件上传
        'fileExt': '*.jpg;*.jpeg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf;*.txt',
        'onUploadSuccess' : function(file, data, response) {
            var html = '<img  src='+data+' width="100" height="100">';
            $("#show").append(html);
            $("#show-ids").append(html);
            $("#picphoto-url").val(data);

        }
    })

</script>

</body>
</html>
