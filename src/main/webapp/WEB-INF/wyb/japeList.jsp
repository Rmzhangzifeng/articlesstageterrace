<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/21
  Time: 18:59
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
            <input type="hidden" id="editid" value="">
            <c:forEach items="${tr}" var="e">
                <a href="javascript:queryJape(${e.editid})">${e.edittext} |</a>
            </c:forEach>
            <div style="display: none" id="japeadd-id">
                <br><button type="button" class="btn btn-primary btn-default" onclick="dialogAddJape()">添加笑话</button>
            </div>
            <table id="jape-table" class="table"></table>
    </div>
</div>
<script>
    $(function (){
        $('#jape-table').bootstrapTable({
            url: '/queryJapepage',

            striped: true,//隔行变色
            showColumns: true,//是否显示 内容列下拉框
            showPaginationSwitch: true,//是否显示 分页工具栏
            minimumCountColumns: 1,//最小留下一个
            showRefresh: true,//显示刷新按钮
            showToggle: true,//显示切换视图
            pagination: true,//开启分页
            paginationLoop: true,//开启分页无限循环


            pageNumber: 1,//当前页数

            pageSize: 9,//每页条数

            pageList: [9, 12, 15],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。

            sidePagination: "server",//

            method: 'post',//发送请求的方式

            contentType: "application/x-www-form-urlencoded",//必须的否则条件查询时会乱码

            queryParams: function (params) {

                var id=$("#editid").val();

                return {
                    id: id,
                    page: this.pageNumber,
                    rows: this.pageSize,
                }
            },

            columns: [{
                field: 'wybjapename',
                title: '标题',
                width: 100,

            }, {
                field: 'wybjapetime',
                title: '发表时间',
                width: 100
            }, {
                field: 'wybcontent',
                title: '内容',
                width: 100,
                formatter:function(value,row,index){
                    var a=value.substring(0,8);
                    return ""+a+"....<a href='javascript:queryJapeByContent("+row.wybid+")'>详细</a>"
                }
            }, {
                field: 'username',
                title: '上传人',
                width: 100
            },{
                field: 'wybfist',
                title: '差评数',
                width: 100,
                formatter:function(value,row,index){
                    return '<button type="button" class="btn btn-primary btn-default" onclick="updateWyb('+1+','+row.wybfist+','+row.wybgood+','+row.wybid+')"><img src="<%=request.getContextPath()%>/img/66.jpg" style="width: 15px;height: 15px">'+value+'</button>';
                }
        },{
                field: 'wybgood',
                title: '好评数',
                width: 100,
                formatter:function(value,row,index){
                    return '<button type="button" class="btn btn-primary btn-default" onclick="updateWyb('+2+','+row.wybgood+','+row.wybfist+','+row.wybid+')"><img src="<%=request.getContextPath()%>/img/77.jpg" style="width: 15px;height: 15px">'+value+'</button>';
                }
            },{
                field: '操作',
                title: '操作',
                width: 100,
                formatter:function(value,row,index){
                    return '<button type="button" class="btn btn-primary btn-default" onclick="deleteJape('+row.wybid+')">删除</button><button type="button" class="btn btn-primary btn-default" onclick="UpdaJape('+row.wybid+')">修改</button><button type="button" class="btn btn-primary btn-default" onclick="queryDis('+row.wybid+')">评论查询</button>';
                }
            }], //列
            silent: true,  //刷新事件必须设置
            formatLoadingMessage: function () {
                return "请稍等，正在加载中...";
            },
            formatNoMatches: function () {  //没有匹配的结果
                return '无符合条件的记录';
            },

        });
    })

    function queryJape(id) {
        $("#editid").val(id)
        if(id!=32){
            $("#japeadd-id").attr("style","")
        }
        $("#jape-table").bootstrapTable("refresh",{'pageNumber':1});
    }

    function updateWyb(mark,wyblike,wyb,wybid){
            wyblike
            $.ajax({
                url:"/updateWyb",
                type:"post",
                data:{"mark":mark,"wyblike":wyblike,"wybid":wybid,"wyblikes":wyb},
                dataType:"json",
                async:false,
                success:function(data){
                    if(data!=null){
                        queryJape($("#editid").val())
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
    function UpdaJape(id){
        BootstrapDialog.show({
            title: '修改页面',
            message: $('<div></div>').load('/getUpdateJape?wybid='+id),
            buttons: [{
                label: '修改',
                action: function(dialog) {
                    $.ajax({
                        url:"/updateJape",
                        type:"post",
                        data:$("#jape-upda").serialize(),
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data!=null){
                                queryJape($("#editid").val())
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
            },{
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }
    function deleteJape(id){
        $.ajax({
            url:"/deleteJape",
            type:"post",
            data:{"wybid":id},
            dataType:"json",
            async:false,
            success:function(data){
                if(data!=null){
                    queryJape($("#editid").val())
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

    function queryJapeByContent(id){
        BootstrapDialog.show({
            title: '查看页面',
            message: $('<div></div>').load('/getPicJape?wybid='+id),
            buttons: [{
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }
    function dialogAddJape(){
        BootstrapDialog.show({
            title: '新增页面',
            message: $('<div></div>').load('/getaddJape?typeid='+$("#editid").val()),
            buttons: [{
                label: '保存',
                action: function(dialog) {
                    $.ajax({
                        url:"/AddJape",
                        type:"post",
                        data:$("#jape-form").serialize(),
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data!=null){
                                queryJape($("#editid").val())
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
            },{
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }

    function queryDis(id){
        BootstrapDialog.show({
            title: '查看页面',
            message: $('<div></div>').load('/getDiscuess?wybid='+id),
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
