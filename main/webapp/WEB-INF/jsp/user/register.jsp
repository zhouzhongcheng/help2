<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
        <script type="text/javascript" src="js/tools.js"></script>
        <script type="text/javascript" src="js/user/register.js"></script>
        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <link href="css/global.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>" />
        <title>注册</title>   
    </head>
    <body>
        <div class="container frame">
            <div class="row">
                <div class="col-xs-8">
                    <h2 class="text-center">
                        注册
                    </h2>
                    <form class="form-horizontal" action="registerAction" method="post">
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">用户名</label>
                            <div class="col-xs-6">
                                <input class="form-control" type="text" name="userName" placeholder="UserName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3">密码</label>
                            <div class="col-xs-6">
                                <input class="form-control" type="text" name="password" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3">真实姓名</label>
                            <div class="col-xs-6">
                                <input class="form-control" type="text" name="realName" placeholder="RealName"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3">性别</label>
                            <div class="col-xs-6">
                                <label class="radio-inline">
                                    <input type="radio" name="sex" value="0" checked="checked" />男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="sex" value="1" />女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3">学校</label>
                            <div class="col-xs-9">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <select class="form-control" id="schoolLocationSelect" >
                                            <option value="-1">请选择</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="schoolSelect" name="schoolId">
                                            <option value="-1">请选择</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="control-label col-xs-3 col-xs-offset-3">
                                <p class="text-left">
                                    <input class="btn btn-info" type="submit" value="注册" />
                                </p>
                            </div>
                            <div class="control-label col-xs-6">
                                <p class="text-left">
                                    <a class="btn btn-success" href="login">已有账号，直接登录</a>
                                </p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>