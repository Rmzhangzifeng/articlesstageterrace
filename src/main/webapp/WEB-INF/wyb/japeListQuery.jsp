<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/23
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    笑话标题：${ja.wybjapename};<br>
    笑话上传人：${ja.username};<br>
    笑话上传时间：${ja.wybjapetime};<br>
    笑话内容：${ja.wybcontent};<br>
    <button type="button" class="btn btn-primary btn-default"><img src="<%=request.getContextPath()%>/img/66.jpg" style="width: 15px;height: 15px">${ja.wybgood}</button>
    <button type="button" class="btn btn-primary btn-default"><img src="<%=request.getContextPath()%>/img/77.jpg"style="width: 15px;height: 15px">${ja.wybfist}</button>
    <form id="discuss-form">
        <input type="hidden" name="japecid" value="${ja.wybid}">
        是否匿名：<input type="checkbox" name="japediscussstatus" value="0"><br>
        <textarea row="" cols="" name="japediscusscontent"></textarea>
    </form>
    <button type="button" class="btn btn-primary btn-default" onclick="fabiao()">发表</button>
</body>
<script>

    function fabiao(){
        $.ajax({
            url:"/addJapeDiscuss",
            type:"post",
            data:$("#discuss-form").serialize(),
            dataType:"json",
            async:false,
            success:function(data){
                if(data!=null){
                    BootstrapDialog.show({
                        title: 'Default Title',
                        message: $('<div>发表成功</div>'),
                    });
                    $("[name='japediscusscontent']").val("");
                    $("[name='japediscussstatus']").attr("checked",false);
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
</html>
