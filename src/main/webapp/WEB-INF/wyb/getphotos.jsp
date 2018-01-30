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
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle!important;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
            <input type="hidden" id="edit-id">
            <c:forEach items="${edit}" var="e">

               <a href="javascript:queryType(${e.editid})">${e.edittext} |</a>

            </c:forEach>

            <div style="display: none" id="button-id">
                <br><button type="button" class="btn btn-primary btn-default" onclick="dialogAdd()"><font color="#8b0000">添加话题</font></button>
            </div>
            <table id="reportTable" class="table"></table>
    </div>
</div>
<script>

    $(function (){
        $('#reportTable').bootstrapTable({
            url: '<%=request.getContextPath()%>/queryPic',
            striped: true,//隔行变色
            showPaginationSwitch:true,//是否显示 分页工具栏
            showRefresh:false,//显示刷新按钮
            pagination:true,//开启分页
            paginationLoop:true,//开启分页无限循环
            pageNumber:1,//当前页数
            pageSize:9,//每页条数
            pageList:[9,12,15],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            sidePagination:"server",//
            method:'post',//发送请求的方式
            contentType:"application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
            queryParams:function(params){
                var id= $("#edit-id").val();
                return {
                    id:id,
                    page:this.pageNumber,
                    rows:this.pageSize,
                }
            },
            columns: [{
                field: 'picgrouptitle',
                title: '话题标题',
                width: 50
            },{
                field: 'picphotourl',
                title: '封面',
                width: 100,
                formatter:function(value,row,index){
                    return "<a href='javascript:queryByIdPhoto(\""+row.picid+"\")'><img src='<%=request.getContextPath()%>"+row.picphotourl+"' style='width:60px;height:60px'></a>";
                }
            },{
                field: 'picname',
                title: '录入人',
                width: 50
            },{
                field: 'piccontent',
                title: '图片简介',
                width: 100
            },{
                field: 'picgroupreview',
                title: '图片状态',
                width: 100,
                formatter:function(value,row,index){
                    if(value==1){
                        return "未审核";
                    }else if(value==2){
                        return "审核通过";
                    }
                }
            },{
                field: 'piclike',
                title: '点赞数',
                width: 50,
                formatter:function(value,row,index){
                    return "<button type=\"button\" class=\"btn btn-default\" onclick='piclike("+row.picorganizeid+","+row.piclike+","+this.pageNumber+")'>"+row.piclike+"</button>";
                }
            },{
                field: 'picgrouptitle',
                title: '操作',
                width: 100,
                 formatter:function(value,row,index){
                     return '<button type="button" class="btn btn-primary btn-default" onclick="delePic('+row.picorganizeid+',\''+row.picid+'\')"><font color="#8b0000">删除话题</font></button><button type="button" class="btn btn-primary btn-default" onclick="editGroup(\''+row.picid+'\','+row.picorganizeid+')"><font color="#8b0000">设置封面</font></button><button type="button" class="btn btn-primary btn-default" onclick="querypicreview('+row.picorganizeid+')"><font color="#8b0000">评论查询</font></button>';
                 }
            }], //列
            silent: true,  //刷新事件必须设置
            formatLoadingMessage: function () {
                return "请稍等，正在加载中...";
            },
            formatNoMatches: function () {  //没有匹配的结果
                return '无符合条件的记录';
            },
            onLoadError: function (data) {
                $('#reportTable').bootstrapTable('removeAll');
            },
        });

    })

    function queryType(id){
        $("#edit-id").val(id)
        if(id>0){
            $("#button-id").attr("style","");
        }
        $('#reportTable').bootstrapTable("refresh",{'pageNumber':1});
    }
    function piclike(id,like,number){
        $.ajax({
            url:"<%=request.getContextPath()%>/updatePicGroupByLike",
            type:"post",
            data:{"picorganizeid":id,"piclike":like},
            dataType:"json",
            async:false,
            success:function(data){
                if(data>0){
                    queryType($("#edit-id").val())
                }else{
                    BootstrapDialog.show({
                        title: 'Default Title',
                        message: $('<div>创建失败</div>'),
                    });
                }
            },
            error:function(){
                alert("查询出错");
            }
        });
    }
    function dialogAdd(){

        BootstrapDialog.show({
            title: '新增页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getPicPhoto'),
            buttons: [{
                label: '保存',
                action: function(dialog) {
                    $("#type-id").val($("#edit-id").val())
                    $.ajax({
                        url:"/AddPicGroup",
                        type:"post",
                        data:$("#group-form").serialize(),
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data>0){
                                queryType($("#edit-id").val())
                                dialog.close();
                            }else{
                                BootstrapDialog.show({
                                    title: 'Default Title',
                                    message: $('<div>创建失败</div>'),
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
    function editGroup(id,id1){
        BootstrapDialog.show({
            title: '修改页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getPicPhotoById?picid='+id+'&picorganizeid='+id1),
            buttons: [{
                label: '保存',
                action: function(dialog) {
                    if($("#piccover-id").val()!=null&&$("#piccover-id").val()!=""){
                        $.ajax({
                            url:"<%=request.getContextPath()%>/UpdateGroupById",
                            type:"post",
                            data:$("#update-form").serialize(),
                            dataType:"json",
                            async:false,
                            success:function(data){
                                if(data>0){
                                    queryType($("#edit-id").val())
                                    dialog.close();
                                }else{
                                    BootstrapDialog.show({
                                        title: 'Default Title',
                                        message: $('<div>创建失败</div>'),
                                    });
                                }
                            },
                            error:function(){
                                alert("查询出错");
                            }
                        });
                    }else{
                        BootstrapDialog.show({
                            title: 'Default Title',
                            message: $('<div>请具体选择</div>'),
                        });

                    }
                }
            }, {
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });

    }
    function delePic(id,ids){
        $.ajax({
            url:"<%=request.getContextPath()%>/deletePicGroup",
            type:"post",
            data:{"picorganizeid":id,"picid":ids},
            dataType:"json",
            async:false,
            success:function(data){
                if(data>0){
                    queryType($("#edit-id").val())
                    dialog.close();

                }else{
                    BootstrapDialog.show({
                        title: 'Default Title',
                        message: $('<div>创建失败</div>'),
                    });
                }
            },
            error:function(){
                alert("查询出错");
            }
        });
    }
    function queryByIdPhoto(id){
        BootstrapDialog.show({
            title: '查看页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getPhotoQueryById?picid='+id),
            buttons: [{
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });

    }
    function querypicreview(id){
        BootstrapDialog.show({
            title: '查看页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getqueryPicreview?picorganizeid='+id),
            width:350,
            height:200,
            buttons: [{
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
