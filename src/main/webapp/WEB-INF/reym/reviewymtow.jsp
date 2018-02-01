<%--
  Created by IntelliJ IDEA.
  User: wangxk
  Date: 2018/1/21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <input type="button" class="btn btn-primary btn-sm" value="批量审核信息" onclick="upStaffAllPicthemeYM()">
            <c:if test="${u.temporaryid == 0}">

                <input type='button' value='临时指派' onclick='upda()'/>

            </c:if>
            <table class="table" id="review-pictheme" border="1"></table>
        </div>
    </div>
</div>

<script>
    $("#review-pictheme").bootstrapTable({
        url:"<%=request.getContextPath()%>/queryPictheme",
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
                rows:this.pageSize, //每页条数
                picroles:${roles2.roleid}
            }
        },
        columns: [ {
            checkbox:true,
        },{
            field: 'picgrouptitle',
            title: '审核标题',
            width: 50
        },{
            field: 'picgroupreview',
            title: '审核状态',
            width: 50,
            formatter:function(value,row,index){
                return value == 1 ? "待审核":"已审核";
            }
        },{
            field: '',
            title: '操作',
            width: 50,
            formatter:function(value,row,index){
                return row.picgroupreview == 4 ? "审核已通过":"<input type='button' value='查看' onclick='queryById(\""+row.picid+"\")'/><input type='button' value='审核' onclick='upStafftow(\""+row.picthemeid+"\",\""+row.picgroupreview+"\")'/><input type='button' value='驳回' onclick='addXinXi(\""+row.picgrouptitle+"\",\""+row.picname+"\")'/>";
            }
        } ]
    })

    function upStafftow(id,status) {
        alert(1);
        $.ajax({
            url:"<%=request.getContextPath() %>/updatePicthemeYm",
            type:"post",
            data:{"picthemeid":id,"picgroupreview":status},
            dataType:"text",
            async:false,
            success:function (Flag){
                if(Flag == 1){
                    $("#review-pictheme").bootstrapTable("refresh");
                }
            },
            error:function (){
                alert("Connection error - 修改状态失败");
            }
        });
    }
    
    function upStaffAllPicthemeYM() {
        var selectRows = $("#review-pictheme").bootstrapTable("getSelections");
        if (selectRows.length < 1) {
            $.messager.alert("提示消息", "请选择要审核的记录！", 'info');
            return;
        }

        //定义变量值
        var strIds = "";
        //拼接字符串，这里也可以使用数组，作用一样
        for (var i = 0; i < selectRows.length; i++) {
            strIds += selectRows[i].picthemeid + ",";
        }
        //循环切割
        strIds = strIds.substr(0, strIds.length - 1);
        alert(strIds)
        $.post('<%=request.getContextPath()%>/upStaffAllPicthemeYM?picthemeids=' + strIds+'&picgroupreview='+${roles2.roleid}, function (jsonObj) {
            if (jsonObj > 0) {
                $("#review-pictheme").bootstrapTable("refresh");
            } else {

                alert('审核失败，请联系管理员！');
            }
        }, "JSON");
    }
    function queryById(id){
        var mark=2;
        BootstrapDialog.show({
            title: '查看页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getPhotoQueryById?picid='+id+'&mark='+mark),
            buttons: [{
                label: '取消',
                action: function(dialog) {
                    dialog.close();
                }
            }]
        });
    }
    function addXinXi(title,name){
        BootstrapDialog.show({
            title: '驳回页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/getMessager?picgrouptitle='+title+'&picname='+name),
            buttons: [{
                label: '驳回',
                action: function(dialog) {

                    $.ajax({
                        url:"<%=request.getContextPath()%>/addMessager",
                        type:"post",
                        data:$("#messager-form").serialize(),
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data>0){
                                BootstrapDialog.show({
                                    title: 'Default Title',
                                    message: $('<div>驳回成功</div>'),
                                });
                                $("#review-pictheme").bootstrapTable("refresh");
                                dialog.close();
                            }else{
                                BootstrapDialog.show({
                                    title: 'Default Title',
                                    message: $('<div>驳回失败</div>'),
                                });
                            }
                        },
                        error:function(){
                            alert("查询出错");
                        }
                    });

                }
            }]
        });
    }
    function upda(){
        BootstrapDialog.show({
            title: '指派页面',
            message: $('<div></div>').load('<%=request.getContextPath()%>/messager/queryUser'),
            buttons: [{
                label: '确定',
                action: function(dialog) {
                    if($("#checkuser:checked").val()!=null){
                        $.ajax({
                            url:"<%=request.getContextPath()%>/messager/updateUser",
                            type:"post",
                            data:{"userid":$("#checkuser:checked").val()},
                            dataType:"json",
                            async:false,
                            success:function(data){
                                if(data>0){
                                    BootstrapDialog.show({
                                        title: 'Default Title',
                                        message: $('<div>指派成功</div>'),
                                    });
                                    dialog.close();
                                }else{
                                    BootstrapDialog.show({
                                        title: 'Default Title',
                                        message: $('<div>指派失败</div>'),
                                    });
                                }
                            },
                            error:function(){
                                alert("查询出错");
                            }
                        });
                    }else{
                        alert("请选择")
                    }


                }
            }]
        });
    }
</script>
</body>
</html>
