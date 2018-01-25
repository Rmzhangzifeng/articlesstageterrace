<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/23
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form id="Solicitarticless-insertform">
        标题：<input type="text" name="solicitarticlestitle"><br/>
        征文话题：<select name="gambitid" id="gambitidSelect"></select><br/>
        内容：<textarea name="contentStr"  cols="79" rows="5"></textarea><br/>
        封面：<input type="file" id="SolicitarticlessuUpload"/>
            <input type="hidden" id="solicitarticlescoverfile" name="solicitarticlescover">
            <div id="SolicitarticlessFileQueue"></div>
            <div id="SolicitarticlessShow"></div>
    </form>

<script>

        $(function (){
            $.ajax({
                url:"<%=request.getContextPath()%>/SolicitArticlesManCon/querygambitidSelections",
                type:"post",
                dataType:"json",
                success:function (gambitidList){
                    var tempStr = "<option value=''>====请选择话题类型===</option>";
                    for (var i = 0; i < gambitidList.length;i++){
                        tempStr+="<option value='"+gambitidList[i].articletopicid+"'>"+gambitidList[i].title+"</option>";
                    }
                    $("#gambitidSelect").html(tempStr);
                },
                error:function (){
                    alert("话题列表初始化失败！");
                }
            });
        })

    $("#SolicitarticlessuUpload").uploadify({
        //插件自带  不可忽略的参数
        'swf': '${pageContext.request.contextPath}/uploadify/uploadify.swf',
        //前台请求后台上传文件的url  不可忽略的参数
        'uploader': '<%=request.getContextPath()%>/SolicitArticlesManCon/uploadFileSolicitarticless',
        //给div的进度条加背景  参数为<div>id属性值  不可忽略
        'queueID': 'SolicitarticlessFileQueue',
        //上传文件文件名   和file文件域的name属性一致   和后台接受的属性名对应
        'fileObjName' : 'SolicitarticlessUploadFile',
        //给上传按钮设置文字
        'buttonText': '封面上传',
        //如果为true 为自动上传  在选择文件后, 为false 那么它就要我们自己手动点上传按钮
        'auto': true,
        //可以同时选择多个文件 默认为true  不可忽略
        'multi': true,
        //上传后队列是否消失
        'removeCompleted': true,
        //队列消失时间
        'removeTimeout' : 1,
        //最大上传文件数量
        'uploadLimit':  10,
        //制定可以文件上传
        'fileExt': '*.jpg;*.jpeg;*.gif;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf;*.txt',
        'onUploadSuccess' : function(file, data, response) {
            $("#solicitarticlescoverfile").val(data);
            var html = '<img  src='+data+' width="50" height="50">';
            $("#SolicitarticlessShow").html(html);
        }
    })
</script>
</body>
</html>
