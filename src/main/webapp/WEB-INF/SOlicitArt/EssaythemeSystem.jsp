<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/21
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>征文话题管理</title>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <input type="button" class="btn btn-info btn-sm" value="添加" onclick="addEssayTheme()"/>
            <input type="button" class="btn btn-primary btn-sm" value="修改" onclick="updateEssayTheme()"/>
            <input type="button" class="btn btn-success btn-sm" value="删除" onclick="delEssayTheme()">
        </div>
    </div>
</div>

        <table id="essayThemeTable"></table>
<script>

        $(function (){
            queryEssayTheme();
        })

    function queryEssayTheme() {
        $('#essayThemeTable').bootstrapTable({
            url: '<%=request.getContextPath()%>/SolicitArticlesManCon/queryEssayThemeList',
            striped: true,//隔行变色
            showColumns: false,//是否显示 内容列下拉框
            showPaginationSwitch: false,//是否显示 分页工具栏
            minimumCountColumns: 1,//最小留下一个
            showRefresh: false,//显示刷新按钮
            showToggle: false,//显示切换视图
            search: true,//是否显示搜索框
            searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
            pagination: true,//开启分页
            paginationLoop: true,//开启分页无限循环
            pageNumber: 1,//当前页数
            pageSize: 20,//每页条数
            pageList: [20, 25, 30],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            sidePagination: "server",//
            method: 'post',//发送请求的方式
            contentType: "application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
            queryParams: function (params) {
                return {
                    page: this.pageNumber,
                    rows: this.pageSize,
                }
            },
            columns: [{
                checkbox:true,
                title: '',
            }, {
                field: 'title',
                title: '标题',
                width: 100,
            }, {
                field: 'themecontent',
                title: '内容',
                width: 100,
                formatter:function (value,rows,index){
                    var contentStr;
                    if(value.length >10){
                         contentStr = value.substring(0,10)+"...   <a href='javascript:lookContent(\""+value+"\")'>查看</a>";
                    }else {
                        contentStr = value;
                    }
                    return contentStr;
                }
            }, {
                field: 'themestarttime',
                title: '开始时间',
                width: 100
            }, {
                field: 'themeendtime',
                title: '结束时间',
                width: 100
            }, {
                field: 'themeendreview',
                title: '审核状态',
                width: 100,
                formatter:function (value,rows,index){
                    if(value == 1){
                        return "<font color='red'>审核中</font>";
                    }else if(value == 2){
                        return "<font color='#006400'>审核通过</font>";
                    }
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
                $('#essayThemeTable').bootstrapTable('removeAll');
            },
            onClickRow: function (row) {

            },
        });
    }

    function lookContent(content){
        BootstrapDialog.show({
            title:'话题内容',
            message:content,
            type: BootstrapDialog.TYPE_DEFAULT,
            closable:false,
            cssClass:'dialog_mar',
            buttons:[{
                label: '关闭',
                action: function(dialogRef){
                    dialogRef.close();
                }
            }]
        })
    }

    /*添加本期话题*/
    function addEssayTheme(){
        BootstrapDialog.show({
            title: '添加话题标题',
            message: $('<div></div>').load('<%=request.getContextPath()%>/ANDY_jspPage/InsertEssayThemePage.jsp'),
            buttons: [{
                label: '添加',
                action: function(dialog) {
                    $.ajax({
                        url:"<%=request.getContextPath()%>/SolicitArticlesManCon/insertEssayTheme",
                        type:"post",
                        data: $("#EssayTheme-addform").serialize(),
                        dataType:"text",
                        async: false,
                        success:function (InserFlag){
                                if(InserFlag > 0){
                                    Lobibox.alert('success', {
                                        msg: "insert successful！"
                                    });
                                    dialog.close();
                                    $("#essayThemeTable").bootstrapTable('refresh');
                                }
                        },
                         error:function (){
                             alert("程序出点小问题，请联系管理员！！！");
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

    /*修改*/
    function updateEssayTheme(){
        var b = $("#essayThemeTable").bootstrapTable('getSelections');
        if(b.length > 1 || b.length == 0){
            BootstrapDialog.show({
                message: "每次有且只能修改一条",
                buttons: [{
                    label: '确定',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            });
        }else if(b.length > 0 && b.length < 2){
            console.info(b[0])
            BootstrapDialog.show({
                title:"修改话题标题",
                message: $('<div></div>').load('<%=request.getContextPath()%>/SolicitArticlesManCon/toUpdateEssayThemePage?articletopicid='+b[0].articletopicid+"&title="+b[0].title+"&themecontent="+b[0].themecontent),
                buttons: [{
                    label: '修改',
                    action: function(dialog) {
                        $.ajax({
                            url:"<%=request.getContextPath()%>/SolicitArticlesManCon/updateEssayTheme",
                            type:"post",
                            data: $("#EssayTheme-updateform").serialize(),
                            dataType:"text",
                            async: false,
                            success:function (UpdateFlag){
                                if(UpdateFlag > 0){
                                    Lobibox.alert('success', {
                                        msg: "update successful！"
                                    });
                                    dialog.close();
                                    $("#essayThemeTable").bootstrapTable('refresh');
                                }
                            },
                            error:function (){
                                alert("程序出点小问题，请联系管理员！！！");
                            }
                        });
                    }
                },{
                    label: '取消',
                    action: function(dialog) {
                        dialog.close();
                    }
                }]
            })
        }
    }

    /*删除*/
    function delEssayTheme(){
        Lobibox.confirm({
            msg: "Are you sure you want to delete them?",
            callback: function ($this, type, ev) {
                if (type === 'yes') {
                    var b = $("#essayThemeTable").bootstrapTable('getSelections');
                    var idstr="";
                    for (var i = 0; i < b.length; i++) {
                        idstr+=","+b[i].articletopicid;
                    }
                    var id = idstr.substr(1);
                    $.ajax({
                        url:"<%=request.getContextPath()%>/SolicitArticlesManCon/deleteEssayTheme",
                        type:"post",
                        data:{'idStr':id},
                        dataType:"text",
                        async:false,
                        success:function (data){
                            if(data>0){
                                Lobibox.alert('success', {
                                    msg: "delete successful！"
                                });
                                $("#essayThemeTable").bootstrapTable('refresh');
                                dialog.close();
                            }
                        },
                        error:function (){
                            alert("程序出点小问题，请联系管理员！！！");
                        }
                    });
                } else if (type === 'no') {

                }
            }
        });
    }
</script>

</body>
</html>
