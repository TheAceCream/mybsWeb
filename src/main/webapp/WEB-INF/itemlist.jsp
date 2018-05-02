<%--
  Created by IntelliJ IDEA.
  User: AceCream
  Date: 2018/4/22
  Time: 下午2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品列表</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/datepicker3.css" rel="stylesheet">
    <link href="../css/bootstrap-table.css" rel="stylesheet">
    <link href="../css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="../js/html5shiv.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>电子设备</span>商城</a>
            <ul class="user-menu">
                <li class="dropdown pull-right">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> ${sessionScope.manager.username} <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/managers/managerLogout.do"><span class="glyphicon glyphicon-log-out"></span> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.container-fluid -->
</nav>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li><a href="/home.do"><span class="glyphicon glyphicon-pencil"></span> 首页</a></li>
        <li class="active"><a href="/tempItemList.do"><span class="glyphicon glyphicon-dashboard"></span> 商品管理</a></li>
        <li><a href="/tempOrderList.do"><span class="glyphicon glyphicon-th"></span> 订单管理</a></li>
        <li><a href="/tempUserList.do"><span class="glyphicon glyphicon-stats"></span> 用户管理</a></li>
        <li class="parent ">
            <ul class="children collapse" id="sub-item-1">
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 1
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 2
                    </a>
                </li>
                <li>
                    <a class="" href="#">
                        <span class="glyphicon glyphicon-share-alt"></span> Sub Item 3
                    </a>
                </li>
            </ul>
        </li>
        <li role="presentation" class="divider"></li>
        <li><a href="/managers/managerLogout.do"><span class="glyphicon glyphicon-user"></span> LogOut</a></li>
    </ul>
</div><!--/.sidebar-->

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">控制板</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">商品列表</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/addItemPage.do" class="btn btn-danger">添加商品</a></div>
                <div class="panel-body">
                    <table data-toggle="table" data-url="tables/data2.json" id="itemTable" >
                        <thead>
                        <tr>
                            <th data-field="id">操作</th>
                            <th data-field="name">商品名称</th>
                            <th data-field="title">商品标题</th>
                            <th data-field="price">商品单价</th>
                            <th data-field="store">商品库存</th>
                            <th data-field="sale">商品销售量</th>
                            <th data-field="sort">商品种类</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div><!--/.row-->


</div><!--/.main-->

<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/chart.min.js"></script>
<script src="../js/chart-data.js"></script>
<script src="../js/easypiechart.js"></script>
<script src="../js/easypiechart-data.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
<script src="../js/bootstrap-table.js"></script>
<script>
    $.ajax({
        method: "POST",
        url: "/item/getItemList.do",
        contentType: 'application/json',
        data:JSON.stringify({

        }),
        success: function( data ) {
            var table = document.getElementById("itemTable");
            for (var i = 0; i < data.data.length; i++) {
                var tr = table.insertRow(table.rows.length);
                var obj = data.data[i];
                for (var p in obj) {
                    if (p==='sort'||p==='img'||p==='pager'||p==='note'){

                    }else if(p==='id'){
                        var op = obj[p];
                        var temp = "修改";
                        var td = tr.insertCell(tr.cells.length);
                        td.innerHTML = "<a href='/item/getItemDetailByMa.do?itemId="+ op +"' class='btn btn-primary'>"+temp+"</a>";
                    }else {
                        var op = obj[p];
                        var td = tr.insertCell(tr.cells.length);
                        td.innerHTML = op;
                    }

                }
            }
        }
    });

</script>
<script>
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>
