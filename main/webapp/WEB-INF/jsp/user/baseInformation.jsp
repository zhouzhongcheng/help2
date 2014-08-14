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
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <link href="css/global.css" rel="stylesheet">
    
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>" />
    	<title>修改资料</title>
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/tools.js"></script>
        <script type="text/javascript" src="js/user/baseInformation.js"></script>
    </head>
    <body>
        <div class="container  frame">
            <div class="row">
                <div class="col-xs-3" id="menuPanel">
                    <ul class="nav nav-tabs nav-stacked">
                        <li>
                            <a href="baseInformation">基本资料</a>
                        </li>
                        <li>
                            <a href="moreInformation">详细资料</a>
                        </li>
                        <li>
                            <a href="baseInformation">设置头像</a>
                        </li>
                        <li>
                            <a href="baseInformation">修改密码</a>
                        </li>
                    </ul>
                </div>
                
                <div class="col-xs-6" id="informationPanel">
                    <form class="form-horizontal" action="baseInformationAction" method="post">
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">真实姓名</label>
                            <div class="col-xs-9">
                                <input class="form-control" type="text" name="realName" value="${user.realName }"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">性别</label>
                            <div class="col-xs-9">
                                <c:if test="${user.sex == 0 }">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" value="0" checked="checked" />男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" value="1" />女
                                    </label>
                                </c:if>
                                <c:if test="${user.sex == 1 }">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" value="0" />男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" value="1" checked="checked" />女
                                    </label>
                                </c:if>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-xs-3">学校</label>
                            <div class="col-xs-9">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <select class="form-control" id="schoolLocationSelect" >
                                            <c:if test="${schoolLocation == null }">
                                                <option value="-1">请选择</option>
                                            </c:if>
                                            <c:if test="${schoolLocation != null }">
                                                <option value="${schoolLocation.id }">${schoolLocation.name }</option>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="schoolSelect" name="schoolId">
                                            <c:if test="${school == null }">
                                                <option value="-1">请选择</option>
                                            </c:if>
                                            <c:if test="${school != null }">
                                                <option value="${school.id }">${school.name }</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="control-label col-xs-3">地区</label>
                            <div class="col-xs-9">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <select class="form-control" id="provinceSelect" name="provinceId">
                                            <c:if test="${province == null }">
                                                <option value="-1">请选择</option>
                                            </c:if>
                                            <c:if test="${province != null }">
                                                <option value="${province.id }">${province.name }</option>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="citySelect" name="cityId">
                                            <c:if test="${city == null }">
                                                <option value="-1">请选择</option>
                                            </c:if>
                                            <c:if test="${city != null }">
                                                <option value="${city.id }">${city.name }</option>
                                            </c:if>
                                        </select>
                                    </div>
                                    <div class="col-xs-4">
                                        <select class="form-control" id="areaSelect" name="areaId">
                                            <c:if test="${area == null }">
                                                <option value="-1">请选择</option>
                                            </c:if>
                                            <c:if test="${area != null }">
                                                <option value="${area.id }">${area.name }</option>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                            
                            
                        </div>
                        <table>
                            
                            <tr>
                                <td><input type="submit" value="保存" /></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="userPanel">
            
        </div>
    </body>
</html>