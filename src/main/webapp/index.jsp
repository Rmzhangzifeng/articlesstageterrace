<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>AdminLTE | Dashboard</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- bootstrap 3.0.2 -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
    <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <!-- fullCalendar -->
    <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />


    <link href="js/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Bootstrap 核心css -->
    <link href="js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap TreeView css -->
    <link href="js/bootstrap-treeview/dist/bootstrap-treeview.min.css" rel="stylesheet">

    <!-- Bootstrap addTabs css -->
    <link href="js/bootStrap-addTabs/bootstrap.addtabs.css" rel="stylesheet">

    <!-- Bootstrap table css -->
    <link href="js/bootstrap-table/dist/bootstrap-table.css" rel="stylesheet">
    <!-- bootstrap-datetimepicker css -->
    <link href="js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.css" rel="stylesheet">

    <!-- bootstrap-dialog css -->
    <link href="js/bootstrap-dialog/dist/css/bootstrap-dialog.css" rel="stylesheet">
    <!-- bootstrap-fileinput css -->
    <link href="js/bootstrap-fileinput/css/fileinput.css" rel="stylesheet">

</head>
<body class="skin-blue">
<!-- header logo: style can be found in header.less -->
<header class="header">
    <a  class="logo">
        AdminWYB
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>
        <div class="navbar-right">

        </div>

    </nav>

</header>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                </div>
                <div class="pull-left info">
                    <p>Hello,王哥</p>

                    <a href="#"> <i class="fa fa-circle text-success"></i>Online</a>
                </div>
            </div>
            <!-- search form -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search..."/>
                    <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <div id="tree"> </div>
        </section>

        <!-- /.sidebar -->
    </aside>
    <aside class="right-side">

        <ul id="myTab" class="nav nav-tabs">
            <li >
                <a href="#" data-toggle="tab"> 首页</a>
            </li>
        </ul>
        <div class="tab-content">
    </div>
    </aside>

</div>
</body>



<!-- jQuery 2.0.2 -->
<script src="js/jquery.min.js"></script>
<!-- jQuery UI 1.10.3 -->
<script src="js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- Morris.js charts -->
<script src="js/raphael-min.js"></script>
<script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
<!-- Sparkline -->
<script src="js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- jvectormap -->
<script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
<script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
<!-- fullCalendar -->
<script src="js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
<!-- jQuery Knob Chart -->
<script src="js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
<!-- daterangepicker -->
<script src="js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
<!-- iCheck -->
<script src="js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

<!-- AdminLTE App -->
<script src="js/AdminLTE/app.js" type="text/javascript"></script>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="js/AdminLTE/dashboard.js" type="text/javascript"></script>

<!--jQuery核心js  -->
<script src="js/jquery.min.js"></script>
<!-- bootstrap 核心js文件 -->
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<!-- bootStrap TreeView -->
<script src="js/bootstrap-treeview/dist/bootstrap-treeview.min.js"></script>
<!-- bootStrap addTabs -->
<script src="js/bootStrap-addTabs/bootstrap.addtabs.js"></script>
<!-- bootStrap table -->
<script src="js/bootstrap-table/dist/bootstrap-table.js"></script>
<!-- bootStrap table 语言包中文-->
<script src="js/bootstrap-table/dist/locale/bootstrap-table-zh-CN.js"></script>
<!-- bootstrap-datetimepicker -->
<script src="js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script src="js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- bootstrap-dialog -->
<script src="js/bootstrap-dialog/dist/js/bootstrap-dialog.js"></script>
<!-- bootstrap-fileinput -->
<script src="js/bootstrap-fileinput/js/fileinput.js"></script>
<script src="js/bootstrap-fileinput/js/locales/zh.js"></script>
<script>

    //获取数据
    function getTreeData(){
        var tree_data = "";
        $.ajax({
            url:"/queryTree",
            type:"post",
            dataType:"json",
            async:false,
            success:function(data){
                tree_data = data;
            },
            error:function(){
                alert("查询出错");
            }
        });
        return tree_data;
    }


    $('#tree').treeview(
        {
            data:getTreeData(),
            onNodeSelected:function(event,node){
                //alert(node.href);
                if(node.href!=null && node.href!=""){
                    $.ajax({
                        url:node.href+"?id="+node.id,
                        type:"post",
                        success:function(data){
                            $.addtabs.add({
                                id:node.id,
                                title:node.text,
                                content:data,
                            })
                        }
                    })

                }

            }
        })

</script>
</body>
</html>

