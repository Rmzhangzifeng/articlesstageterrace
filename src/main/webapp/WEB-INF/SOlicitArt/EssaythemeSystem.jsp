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

        <table id="essayThemeTable"></table>


<script>

    $(function (){
        queryEssayTheme();
    })

    function queryEssayTheme() {
        $('#essayThemeTable').bootstrapTable({
            url: '/queryEssayThemeList',
            striped: true,//隔行变色
            showColumns: true,//是否显示 内容列下拉框
            showPaginationSwitch: true,//是否显示 分页工具栏
            minimumCountColumns: 1,//最小留下一个
            showRefresh: true,//显示刷新按钮
            showToggle: true,//显示切换视图
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
                field: 'title',
                title: '标题',
                width: 100,
            }, {
                field: 'themecontent',
                title: '内容',
                width: 100,
                formatter:function (value,rows,index){
                    var contentStr = value.substring(0,10)+"...   <a href='javascript:lookContent(\""+value+"\")'>查看</a>";
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
                        return "审核中";
                    }else if(value == 2){
                        return "审核通过";
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


</script>

</body>
</html>
