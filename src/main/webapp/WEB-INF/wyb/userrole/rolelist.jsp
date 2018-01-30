<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/30
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <table id="role-table" class="table"></table>
    </div>
</div>

<script>
    $(function (){
        $('#role-table').bootstrapTable({
            url: '/Role/queryUser',
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
                return {
                    page:this.pageNumber,
                    rows:this.pageSize,
                }
            },
            columns: [{
                field: 'userid',
                title: '用户编号',
                width: 50
            },{
                field: 'username',
                title: '用户名称',
                width: 50
            },{
                field: 'userpass',
                title: '用户密码',
                width: 50
            },{
                field: 'userid',
                title: '操作',
                width: 100,
                formatter:function(value,row,index){
                  return "<button type=\"button\" class=\"btn btn-default\" onclick='roleFeipei("+row.userid+")'>角色分配</button>";
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
    function roleFeipei(id){
        BootstrapDialog.show({
            title: '分配页面',
            message:$('<div></div>').load('/Role/getRoleUser?userid='+id),
            buttons: [{
                label: '保存',
                action: function(dialog) {
                    $.ajax({
                        url:"/Role/updateRole",
                        type:"post",
                        data:{"userid":$("#user-id").val(),"userroleid":$("#checkrole:checked").val()},
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data>0){
                                alert("分配成功")
                                dialog.close();
                            }else{
                                BootstrapDialog.show({
                                    title: 'Default Title',
                                    message: $('<div>分配失败</div>'),
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
</script>
</body>
</html>
