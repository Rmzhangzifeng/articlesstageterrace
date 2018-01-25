<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/23
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <input type="button" class="btn btn-primary btn-sm" value="修改" onclick="updateArticleDiscuss()"/>
                <input type="button" class="btn btn-success btn-sm" value="删除" onclick="delArticleDiscuss()">
            </div>
        </div>
    </div>

    <table id="ArticleDiscussTable"></table>

    <script>

        $(function (){
            queryArticleDiscuss();
        })

        function queryArticleDiscuss() {
            $('#ArticleDiscussTable').bootstrapTable({
                url: '<%=request.getContextPath()%>/SolicitArticlesManCon/queryArticleDiscussList',
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
                    field: 'disusername',
                    title: '评论人',
                    width: 100,
                }, {
                    field: 'discusscontent',
                    title: '评论内容',
                    width: 100,
                }, {
                    field: 'discusstime',
                    title: '评论时间',
                    width: 100
                }, {
                    field: 'disEssayname',
                    title: '评论征文名',
                    width: 100
                }], //列
                silent: true,  //刷新事件必须设置
                formatLoadingMessage: function () {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches: function () {  //没有匹配的结果
                    return '无符合条件的记录';
                },
                onLoadError: function (data) {
                    $('#ArticleDiscussTable').bootstrapTable('removeAll');
                },
                onClickRow: function (row) {

                },
            });
        }


        /*修改评论信息*/
        function updateArticleDiscuss(){
            var b = $("#ArticleDiscussTable").bootstrapTable('getSelections');
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
                    title:"修改评论内容",
                    message: $('<div></div>').load('<%=request.getContextPath()%>/SolicitArticlesManCon/toUpdateArticleDiscuss?discussid='+b[0].discussid+"&discusscontent="+b[0].discusscontent),
                    buttons: [{
                        label: '修改',
                        action: function(dialog) {
                            $.ajax({
                                url:"<%=request.getContextPath()%>/SolicitArticlesManCon/updateArticleDiscuss",
                                type:"post",
                                data: $("#ArticleDiscuss-updateform").serialize(),
                                dataType:"text",
                                async: false,
                                success:function (UpdateFlag){
                                    if(UpdateFlag > 0){
                                        Lobibox.alert('success', {
                                            msg: "update successful！"
                                        });
                                        dialog.close();
                                        $("#ArticleDiscussTable").bootstrapTable('refresh');
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
        /*删除评论信息*/
        function delArticleDiscuss() {
            Lobibox.confirm({
                msg: "Are you sure you want to delete them?",
                callback: function ($this, type, ev) {
                    if (type === 'yes') {
                        var b = $("#ArticleDiscussTable").bootstrapTable('getSelections');
                        var idstr="";
                        for (var i = 0; i < b.length; i++) {
                            idstr+=","+b[i].discussid;
                        }
                        var id = idstr.substr(1);
                        $.ajax({
                            url:"<%=request.getContextPath()%>/SolicitArticlesManCon/deleteArticleDiscuss",
                            type:"post",
                            data:{'idStr':id},
                            dataType:"text",
                            async:false,
                            success:function (data){
                                if(data>0){
                                    Lobibox.alert('success', {
                                        msg: "delete successful！"
                                    });
                                    $("#ArticleDiscussTable").bootstrapTable('refresh');
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
