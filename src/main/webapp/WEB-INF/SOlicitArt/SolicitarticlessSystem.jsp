<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/21
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>征文管理</title>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <input type="button" class="btn btn-info btn-sm" value="添加" onclick="addSolicitarticless()"/>
                <input type="button" class="btn btn-primary btn-sm" value="修改" onclick="updateSolicitarticless()"/>
                <input type="button" class="btn btn-success btn-sm" value="删除" onclick="delSolicitarticless()">
            </div>
        </div>
    </div>
    <table id="SolicitarticlessTable"></table>

    <script>

        $(function (){
            querSolicitarticless();
        })

        function querSolicitarticless() {
            $('#SolicitarticlessTable').bootstrapTable({
                url: '<%=request.getContextPath()%>/SolicitArticlesManCon/querySolicitarticlessList',
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
                    title:''
                }, {
                    field: 'solicitarticlestitle',
                    title: '标题',
                    width: 100,
                }, {
                    field: 'contentStr',
                    title: '内容',
                    width: 100,
                }, {
                    field: 'solicusername',
                    title: '提交人',
                    width: 100,
                }, {
                    field: 'solicitarticlestime',
                    title: '提交时间',
                    width: 100
                }, {
                    field: 'gambitnameStr',
                    title: '征文话题',
                    width: 100
                }, {
                    field: 'greatnumber',
                    title: '点赞数',
                    width: 100
                }, {
                    field: 'solicitarticlescover',
                    title: '封面',
                    width: 100,
                    formatter:function (value,rows,index){
                        var imgStr = "<img src='<%=request.getContextPath()%>"+value+"' width='70px' height='40px'/>";
                          return imgStr;
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
                    $('#SolicitarticlessTable').bootstrapTable('removeAll');
                },
                onClickRow: function (row) {},
            });
        }

        /*添加*/
        function addSolicitarticless(){
            BootstrapDialog.show({
                title: '添加话题标题',
                message: $('<div></div>').load('<%=request.getContextPath()%>/ANDY_jspPage/InsertSolicitarticlessPage.jsp'),
                buttons: [{
                    label: '添加',
                    action: function(dialog) {
                        $.ajax({
                            url:"<%=request.getContextPath()%>/SolicitArticlesManCon/InsertSolicitarticless",
                            type:"post",
                            data: $("#Solicitarticless-insertform").serialize(),
                            dataType:"text",
                            async: false,
                            success:function (InsertFlag){
                                if(InsertFlag > 0){
                                    Lobibox.alert('success', {
                                        msg: "insert successful！"
                                    });
                                    dialog.close();
                                    $("#SolicitarticlessTable").bootstrapTable('refresh');
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
        /*删除*/
        function delSolicitarticless(){
            Lobibox.confirm({
                msg: "Are you sure you want to delete them?",
                callback: function ($this, type, ev) {
                    if (type === 'yes') {
                        var b = $("#SolicitarticlessTable").bootstrapTable('getSelections');
                        var idstr="";
                        for (var i = 0; i < b.length; i++) {
                            idstr+=","+b[i].solicitarticlesid;
                        }
                        var id = idstr.substr(1);
                        $.ajax({
                            url:"<%=request.getContextPath()%>/SolicitArticlesManCon/deleteSolicitarticless",
                            type:"post",
                            data:{'idStr':id},
                            dataType:"text",
                            async:false,
                            success:function (data){
                                if(data>0){
                                    Lobibox.alert('success', {
                                        msg: "delete successful！"
                                    });
                                    $("#SolicitarticlessTable").bootstrapTable('refresh');
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

        /*修改*/
        function updateSolicitarticless(){
            var b = $("#SolicitarticlessTable").bootstrapTable('getSelections');
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
                    title:"修改征文信息",
                    message: $('<div></div>').load('<%=request.getContextPath()%>/SolicitArticlesManCon/toUpdateSolicitarticlessPage?solicitarticlesid='+b[0].solicitarticlesid+"&solicitarticlestitle="+b[0].solicitarticlestitle+"&contentStr="+b[0].contentStr+"&solicitarticlescover="+b[0].solicitarticlescover),
                    buttons: [{
                        label: '修改',
                        action: function(dialog) {
                            $.ajax({
                                url:"<%=request.getContextPath()%>/SolicitArticlesManCon/updateSolicitarticless",
                                type:"post",
                                data: $("#Solicitarticless-updateform").serialize(),
                                dataType:"text",
                                async: false,
                                success:function (UpdateFlag){
                                    if(UpdateFlag > 0){
                                        Lobibox.alert('success', {
                                            msg: "update successful！"
                                        });
                                        dialog.close();
                                        $("#SolicitarticlessTable").bootstrapTable('refresh');
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
    </script>
</body>
</html>
