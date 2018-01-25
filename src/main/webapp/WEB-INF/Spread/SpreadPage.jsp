<%--
  Created by IntelliJ IDEA.
  User: 刘凤琴
  Date: 2018/1/22
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button class="btn btn-warning" type="button" onclick="update(0)">推广</button>
<button class="btn btn-warning" type="button" onclick="update(1)">下架</button>
<table id="SpreadTable"></table>
<script>
    $(function () {
        querSpread();
    })

    function querSpread() {
        $('#SpreadTable').bootstrapTable({
            url: '<%=request.getContextPath()%>/SolicitArticlesManCon/querySolicitarticlessList',
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
            pageSize: 5,//每页条数
            pageList: [5, 10, 20, 25, 30],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
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
                checkbox: true,
            }, {
                field: 'solicitarticlestitle',
                title: '标题',
                width: 100,
            }, {
                field: 'soliusername',
                title: '提交人',
                width: 100,
            }, {
                field: 'solicitarticlestime',
                title: '提交时间',
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
            }, {
                field: 'spreadstatus',
                title: '是否推广',
                width: 100,
                formatter: function (value, rows, index) {
                    if (value == 0) {
                        return "是";
                    } else {
                        return "否";
                    }
                }
            },], //列
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
            onClickRow: function (row) {

            },
        });
    }

    //修改
    function update(idd) {
        //获取选中的框格
        var mid = $("#SpreadTable").bootstrapTable("getSelections");
        console.info(mid)
        var m = "";
        for (var i = 0; i < mid.length; i++) {
            m += "," + mid[i].solicitarticlesid;
        }
        //对id进行截取
        var id = m.substr(1);
        if(id.length>0){
            $.ajax({
                url: '<%=request.getContextPath()%>/updateSpread',
                type: "post",
                data: {"ids":id,"idd":idd},
                dataType: "text",
                success: function (m) {
                    if (m > 0) {
                        alert("修改成功！")
                        //刷新数据表格
                        $("#SpreadTable").bootstrapTable("refresh");
                    }
                }, error: function () {
                    alert("失败！")
                }
            })
        }else {
            alert("请至少选择一项......")
        }

    }
</script>
</body>
</html>
