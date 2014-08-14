<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link href="css/global.css" rel="stylesheet">
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath %>" />
    <title>登录</title>
</head>
<body>
    <div class="container frame">
        <div class="row">
            <div class="col-xs-6">
                <h2 class="text-center">登录</h2>
                <form class="form-horizontal" action="loginAction" method="post">
                    <div class="form-group">
                        <label class="control-label col-xs-3 ">用户名</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="userName" placeholder="UserName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3">密码</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="password" placeholder="Password"/>
                        </div>
                    </div>
                    <div class="form-group">                            
                        <div class="control-label col-xs-3 col-xs-offset-3">
                            <p class="text-left">
                                <input class="btn btn-info" type="submit" value="登录" />
                            </p>
                        </div>
                        <div class="control-label col-xs-6">
                            <p class="text-left">
                                <a class="btn btn-success" href="register">没有账号，点击注册</a>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>