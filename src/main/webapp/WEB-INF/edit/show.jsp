<%--
  Created by IntelliJ IDEA.
  User: 快乐
  Date: 2018/1/21
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table" id="edit-table" border="1" width="400" height="300"></table>
<script>
    function search(){
        $("#edit-table").bootstrapTable("refresh",{'pageNumber':1});
    }
    $(function(){
        $("#edit-table").bootstrapTable({
            url:"/queryedittable",
            striped: true,//隔行变色
            showColumns:true,//是否显示 内容列下拉框
            showPaginationSwitch:true,//是否显示 数据条数选择框
            minimumCountColumns:1,//最小留下一个
            showRefresh:true,//显示刷新按钮
            showToggle:true,//显示切换视图
//         search:true,//是否显示搜索框
//       searchOnEnterKey:true,//设置为 true时，按回车触发搜索方法，否则自动触发搜索方法
            pagination:true,//开启分页
            paginationLoop:true,//开启分页无限循环
            pageNumber:1,//当前页数
            pageSize:10,//每页条数
            pageList:[1,2,3,4],//如果设置了分页，设置可供选择的页面数据条数。设置为All 则显示所有记录。
            sidePagination:"server",//
            method:'post',//发送请求的方式
            contentType:"application/x-www-form-urlencoded",//必须的否则条件查询时会乱码
            queryParams:function(){
                var name= $("#empName").val();
                var sex = $("#sex").val();
//                alert(name+","+sex);
//                return 的数据 是传递到  action类中的参数
                return {
                    page:this.pageNumber,//当前页
                    rows:this.pageSize //每页条数
                }
            },
            columns: [
                {
                    checkbox:true,
                },{
                    field: 'editpid',
                    title: '',
                    idField:true,
                    width: 90,
                    formatter: function(value,row,index){
                        if(row.editpid==20){
                            return "一级菜单";
                        }else{
                            if(row.editpid==0){
                                return "菜单";
                            }else{
                                return"二级菜单";
                            }

                        }

                    }
                },{
                    field: 'edittext',
                    title: '菜单名',
                    idField:true,
                    width: 90
                }]
        })
    })

</script>
</body>
</html>
