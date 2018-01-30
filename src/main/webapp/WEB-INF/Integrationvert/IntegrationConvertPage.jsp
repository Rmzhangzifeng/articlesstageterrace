<%--
  Created by IntelliJ IDEA.
  User: minded
  Date: 2018/1/30
  Time: 10:27
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
            <input type="button" class="btn btn-primary btn-sm" value="新增商品" onclick="insertIntegrationShop()"/>
            <input type="button" class="btn btn-success btn-sm" value="删除商品" onclick="delIntegrationShop()">
        </div>
    </div>
</div>
        <table id="Integration_table"></table>

    <script >

        $(function (){
            queryIntegration_table();
        })

        function queryIntegration_table() {
            $('#Integration_table').bootstrapTable({
                url: '<%=request.getContextPath()%>/Integrationvert/queryNowShops',
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
                    field:'',
                    title:'',
                }, {
                    field: 'shopid',
                    title: '商品ID',
                    width: 100,
                }, {
                    field: 'shopname',
                    title: '商品名称',
                    width: 100,
                }, {
                    field: 'shopimg',
                    title: '商品图解',
                    width: 100,
                    formatter:function (value,rows,index) {
                        var tempVal = "<img src='<%=request.getContextPath()%>"+value+"' width='100px' height='40px'/>";
                        return tempVal;
                    }
                }, {
                    field: 'needintegra',
                    title: '所需积分',
                    width: 100
                }, {
                    field: 'shopcount',
                    title: '库存',
                    width: 100,
                }, {
                    field: '',
                    title: '操作',
                    width: 100,
                    formatter:function (value,rows,index) {
                        return "<input type='button' value='修改库存' onclick='updateShopCount("+rows.shopcount+","+rows.shopid+")'/>";
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
                    $('#Integration_table').bootstrapTable('removeAll');
                },
                onClickRow: function (row) {

                },
            });
        }

        function updateShopCount(shopCountValue,shopid){
            BootstrapDialog.show({
                title:'',
                message:"<input type='text' value='"+shopCountValue+"' id='upShopCountValue'/>",
                type: BootstrapDialog.TYPE_DEFAULT,
                closable:false,
                cssClass:'dialog_mar',
                buttons:[{
                    label: '修改',
                    action: function(dialogRef){
                        $.ajax({
                            url:"<%=request.getContextPath()%>/Integrationvert/updateShopCountValue",
                            type:"post",
                            data:{"shopid":shopid,"shopcount":$("#upShopCountValue").val()},
                            dataType:"text",
                            success:function (updateFalg){
                                if(updateFalg>0){
                                    dialogRef.close();
                                    $('#Integration_table').bootstrapTable('refresh');
                                }
                            },
                            error:function (){
                                alert("程序出点小问题，请联系管理员！！！");
                            }
                        });

                    }
                }, {
                    label: '关闭',
                    action: function(dialogRef){
                        dialogRef.close();
                    }
                }]
            })
        }

        /*新增*/
        function insertIntegrationShop(){
            BootstrapDialog.show({
                title: '新增商品',
                message: $('<div></div>').load('<%=request.getContextPath()%>/ANDY_jspPage/insertIntegrationShopPage.jsp'),
                buttons: [{
                    label: '添加',
                    action: function(dialog) {
                        $.ajax({
                            url:"<%=request.getContextPath()%>/Integrationvert/insertIntegrationvertShop",
                            type:"post",
                            data: $("#insertIntegrationShop-form").serialize(),
                            dataType:"text",
                            async: false,
                            success:function (InserFlag){
                                if(InserFlag > 0){
                                    Lobibox.alert('success', {
                                        msg: "insert successful！"
                                    });
                                    dialog.close();
                                    $("#Integration_table").bootstrapTable('refresh');
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
        function delIntegrationShop(){
            Lobibox.confirm({
                msg: "Are you sure you want to delete them?",
                callback: function ($this, type, ev) {
                    if (type === 'yes') {
                        var b = $("#Integration_table").bootstrapTable('getSelections');
                        var idstr="";
                        for (var i = 0; i < b.length; i++) {
                            idstr+=","+b[i].shopid;
                        }
                        var id = idstr.substr(1);
                        $.ajax({
                            url:"<%=request.getContextPath()%>/Integrationvert/deleteIntegrationvertShop",
                            type:"post",
                            data:{'idStr':id},
                            dataType:"text",
                            async:false,
                            success:function (data){
                                if(data>0){
                                    Lobibox.alert('success', {
                                        msg: "delete successful！"
                                    });
                                    $("#Integration_table").bootstrapTable('refresh');
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
