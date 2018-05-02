<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>电子设备商城后台管理系统</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/datepicker3.css" rel="stylesheet">
    <link href="../css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="../js/html5shiv.js"></script>
    <script src="../js/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">管理员登录</div>
            <div class="panel-body">
                <form id="indexform" role="form" method="post" action="/managerHome.do">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" id="managerName" placeholder="username" name="username" type="username" autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control"  id="managerPsw" placeholder="Password" name="password" type="password" value="">
                        </div>
                        <button id="managerLog" class="btn btn-primary">登录</button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="../js/jquery-1.11.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/chart.min.js"></script>
<script src="../js/chart-data.js"></script>
<script src="../js/easypiechart.js"></script>
<script src="../js/easypiechart-data.js"></script>
<script src="../js/bootstrap-datepicker.js"></script>
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
<script>
    $("#managerLog").click(function () {
        $.ajax({
            method: "POST",
            url: "/managers/getManager.do",
            contentType: 'application/json',
            data:JSON.stringify({
                username:$('#managerName').val(),
                password:$('#managerPsw').val()
            }),
            success: function( data ) {

                if (data.code==0){
                    //跳转到主界面
                   $('#indexform').submit();
                }else if (data.code==100){
                    alert(data.msg)
                }

            }
        });

    })

</script>

</body>

</html>