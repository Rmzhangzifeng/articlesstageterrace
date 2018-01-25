<%--
  Created by IntelliJ IDEA.
  User: 刘凤琴
  Date: 2018/1/22
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button class="btn btn-success" type="button" onclick="add()">新增</button>
<button class="btn btn-defalut" type="button" onclick="deel()">删除</button>
<table class="table" id="adtable" border="1"></table>
<script type="text/javascript">
    function search() {
        $("#adtable").bootstrapTable("refresh", {'pageNumber': 1});
    }

    $(function () {
        $("#adtable").bootstrapTable({
            url: "<%=request.getContextPath()%>/queryAdPage",
            striped: true,//隔行变色
            showColumns: true,//是否显示 内容列下拉框
            showPaginationSwitch: true,//是否显示 数据条数选择框
            minimumCountColumns: 1,//最小留下一个
            showRefresh: true,//显示刷新按钮
            showToggle: true,//显示切换视图
            search: true,//是否显示搜索框
            searchOnEnterKey: true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
            pagination: true,//开启分页
            paginationLoop: true,//开启分页无限循环
            pageNumber: 1,//当前页数
            pageSize: 5,//每页条数
            pageList: [5, 10, 15, 20],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            sidePagination: "server",//
            method: 'post',//发送请求的方式
            contentType: "application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
            queryParams: function () {
                var name = $("#empName").val();
                var sex = $("#sex").val();
                //                 alert(name+","+sex);
                //                 return 的数据 是传递到  action类中的参数
                return {
                    page: this.pageNumber,//当前页
                    rows: this.pageSize //每页条数
                }
            },
            columns: [
                {
                    checkbox: true,
                }, {
                    field: 'adid',
                    title: '编号',
                    idField: true,
                    width: 100
                }, {
                    field: 'adname',
                    title: '名称',
                    width: 100
                }, {
                    field: ' ',
                    title: '详情',
                    width: 100,
                    formatter: function (value, row, index) {
                        var showimg = "<img src='<%=request.getContextPath()%>"+row.adimg+"' width='60px' width='60px'>"
                        return showimg;
                    }
                }, {
                    field: 'adshowdate',
                    title: '展示日期',
                    width: 100

                }, {
                    field: 'adstataus',
                    title: '状态',
                    width: 100,
                    formatter: function (value, row, index) {
                        if (value == 0) {
                            return "<font color='#a9a9a9'>已过期</font>";
                        } else if (value == 1) {
                            return "<font color='#8fbc8f'>待展示</font>";
                        } else if (value == 2) {
                            return "<font color='#dc143c'>展示中</font>";
                        }
                    }
                }]
        })
    })
    var datecheck=true;
    function checkdate(){
        $.ajax({
            url: '<%=request.getContextPath()%>/datecheck',
            type: "post",
            data: $("#addadver-form").serialize(),
            dataType: "text",
            success: function (m) {
                if (m >= 4) {
                    alert("当前日期广告位已满！")
                    datecheck=false;
                }else{
                    datecheck=true;
                }
            }, error: function () {
                alert("失败！")
            }
        })
    }
    //新增
    function add() {
        BootstrapDialog.show({
            title: '新增',
            message: $('<div></div>').load('<%=request.getContextPath()%>/toaddadver'),
            buttons: [{
                label: '保存',
                action: function (dialog) {
                    if(datecheck){
                        $.ajax({
                            url: '<%=request.getContextPath()%>/addad',
                            type: "post",
                            data: $("#addadver-form").serialize(),
                            dataType: "text",
                            success: function (m) {
                                if (m > 0) {
                                    alert("新增成功！")
                                    dialog.close();
                                    $("#adtable").bootstrapTable("refresh");
                                }
                            }, error: function () {
                                alert("失败！")
                            }
                        })
                    }else{
                        alert("请更换日期。。。。")
                    }

                }
            }, {
                label: '取消',
                action: function (dialog) {
                    dialog.close();
                }
            }]
        });

    }

    //删除
    function deel() {
        //获取选中的框格
        var mid = $("#adtable").bootstrapTable("getSelections");
        var m = "";
        for (var i = 0; i < mid.length; i++) {
            m += "," + mid[i].adid;
        }
        //对id进行截取
        var id = m.substr(1);

        var ads = true;
        for (var i = 0; i < mid.length; i++) {
            if (mid[i].adstataus != 0) {
                ads = false;
            }
        }
        if (id.length > 0) {
            if (ads) {
                $.ajax({
                    url: '<%=request.getContextPath()%>/delad',
                    type: "post",
                    data: {"ids": id},
                    dataType: "text",
                    success: function (m) {
                        if (m > 0) {
                            alert("删除成功！")
                            //刷新数据表格
                            $("#adtable").bootstrapTable("refresh");
                        }
                    }, error: function () {
                        alert("失败！")
                    }
                })
            } else {
                alert("抱歉，您只能删除已过期广告。。。")
            }

        } else {
            alert("请至少选择一项......")
        }
    }


</script>
</body>
</html>
