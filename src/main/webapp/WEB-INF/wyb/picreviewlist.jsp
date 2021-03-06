<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/1/24
  Time: 15:10
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

            <input type="hidden" value="${pic}" id="review">
            <table id="pic-review" class="table"></table>

<script>

    $(function (){
        $('#pic-review').bootstrapTable({
            url: '<%=request.getContextPath()%>/queryPicReview',
            striped: true,//隔行变色
            showColumns:true,//是否显示 内容列下拉框
            showPaginationSwitch:true,//是否显示 分页工具栏
            minimumCountColumns:1,//最小留下一个
            pagination:true,//开启分页
            paginationLoop:true,//开启分页无限循环
            pageNumber:1,//当前页数
            pageSize:9,//每页条数
            pageList:[9,12,15],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            sidePagination:"server",//
            method:'post',//发送请求的方式
            contentType:"application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
            queryParams:function(params){
                var id=$("#review").val();
                return {
                    picphotosid:id,
                    page:this.pageNumber,
                    rows:this.pageSize,
                }
            },
            columns: [{
                field: 'picreviewcontent',
                title: '评论内容',
                width: 100
            },{
                field: 'picwybdate',
                title: '评论时间',
                width: 100
            },{
                field: 'username',
                title: '评论人',
                width: 100,
                formatter:function(value,row,index){
                    if(row.picstatus==0){
                        return "匿名";
                    }else{
                        return value;
                    }
                }
            }], //列
        });

    })
</script>
</body>
</html>
