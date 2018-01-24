<%--
  Created by IntelliJ IDEA.
  User: 刘凤琴
  Date: 2018/1/23
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="addadver-form" method="post">
    <table>
        <tr>
            <td>名称</td>
            <td><input type="text" name="adname"></td>
        </tr>
        <tr>
            <td>详情</td>
            <td>
                <input type="file" id="adbubbon" >
                <div id="showImgDiv" style="width: 60px;height: 60px;border-style:solid;border-width:1px; border-color:black;">
                </div>
                <div id="showBarDiv" ></div>
                <input type="hidden" id="simgsrc" name="adimg">
            </td>
        </tr>
        <tr>
            <td>展示日期</td>
            <td><input type="text" id="sdate" name="addate"  onblur="checkdate()"></td>
        </tr>
        <tr>
            <td>链接地址</td>
            <td><input type="text" name="adhttp"></td>
        </tr>
    </table>
</form>
<script >
    //日历 插件
    $('#sdate').datetimepicker({
        format: 'yyyy-mm-dd',
        minView: "month",//设置只显示到月份
        autoclose: true,//选中自动关闭
    });
</script>
<script type="text/javascript">
    $(function(){
//文件域的id
        $("#adbubbon").uploadify({
            //前台请求后台的url 不可忽略的参数
            'uploader' :"<%=request.getContextPath()%>/upadloadImg",
            //插件自带 不可忽略的参数
            'swf' : '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
            //撤销按钮的图片路径
            'cancelImg' : '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
            //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
            'auto' : true,
            //可以同时选择多个文件 默认为true 不可忽略
            'multi' : false,
            //给上传按钮设置文字
            'buttonText' : '上传照片',
            //上传后队列是否消失
            'removeCompleted' : true,
            'removeTimeout' : 1,
            //上传文件的个数
            'uploadLimit' : 2,
            'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
            'fileSizeLimit' : '2MB',
            //给div的进度条加背景 不可忽略
            'queueID' : 'showBarDiv',
            // action中接收文件的全局变量名
            'fileObjName' : 'artImg',
            'onUploadSuccess' : function(file, data, response) {
//       将图片回显    data   接收到的是图片名称
                var str = '<img style="width:60px;height:60px;border-style:solid;border-width:1px; border-color:black;"src="<%=request.getContextPath()%>'+data+'">';
                $("#showImgDiv").html(str);
                $("#simgsrc").val(data);
            }

        });

    });

</script>
</body>
</html>
