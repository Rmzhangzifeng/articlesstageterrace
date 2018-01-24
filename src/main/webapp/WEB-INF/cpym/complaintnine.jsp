<%--
  Created by IntelliJ IDEA.
  User: wangxk
  Date: 2018/1/23
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table" id="cpym-complaintss" border="1"></table>
        </div>
    </div>
</div>
<script>

    $("#cpym-complaintss").bootstrapTable({
        url:"<%=request.getContextPath()%>/queryComplaintss",
        /*  striped: true,//隔行变色
         showColumns:true,//是否显示 内容列下拉框 */
        showPaginationSwitch:true,//是否显示 分页工具栏
        /*  minimumCountColumns:1,//最小留下一个 */
        showRefresh:true,//显示刷新按钮
        /*   showToggle:true,//显示切换视图 */
        /*  search:true,//是否显示搜索框
            searchOnEnterKey:true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法*/
        pagination:true,//开启分页
        paginationLoop:true,//开启分页无限循环
        pageNumber:1,//当前页数
        pageSize:9,//每页条数
        pageList:[3,6,9],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
        sidePagination:"server",//
        method:'post',//发送请求的方式
        contentType:"application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
        queryParams:function(){
            return {
                page:this.pageNumber,//当前页
                rows:this.pageSize //每页条数
            }
        },
        columns: [ {
            field: 'usermid',
            title: '投诉人ID',
            width: 50
        },{
            field: 'complaintcontent',
            title: '投诉内容',
            width: 50
        },{
            field: 'complainttime',
            title: '投诉时间',
            width: 50
        },{
            field: 'complainthuifu',
            title: '回复内容',
            width: 50
        }]
    })
</script>
</body>
</html>
