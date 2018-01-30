<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/23
  Time: 11:07
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
            话题标题：${group.picgrouptitle}<br>
            <c:forEach items="${photo}" var="e">
                图片上传人：${e.picuplodperson};<br>
                图片简介：${e.piccontent};<br>
                图片上传时间：${e.picuplodtime};<br>
                <img src='<%=request.getContextPath()%>${e.picphotourl}' style='width:60px;height:60px'><br>
                <form id="reviem-form${group.picorganizeid}">
                    <input type="hidden" name="picphotosid" value="${group.picorganizeid}">
                    <input type="hidden" name="pictopicszid" value="${e.picphotoid}">
                    是否匿名：<input type="checkbox" name="picstatus" value="0"><br>
                    <textarea row="" cols="" name="picreviewcontent"></textarea>
                </form>
                <button type="button" class="btn btn-primary btn-default" onclick="pic(${group.picorganizeid})">发表</button><br>
            </c:forEach>
        </div>
    </div>
</div>
<script>

    function pic(id){
        $.ajax({
            url:"<%=request.getContextPath()%>/addPhotoreviem",
            type:"post",
            data:$("#reviem-form"+id+"").serialize(),
            dataType:"json",
            async:false,
            success:function(data){
                if(data!=null){
                    BootstrapDialog.show({
                        title: 'Default Title',
                        message: $('<div>发表成功</div>'),
                    });
                    $("[name='picreviewcontent']").val("");
                    $("[name='picstatus']").attr("checked",false);
                }else{
                    BootstrapDialog.show({
                        title: 'Default Title',
                        message: $('<div>发表失败</div>'),
                    });
                }
            },
            error:function(){
                alert("查询出错");
            }
        });
    }

</script>

</body>
</html>
