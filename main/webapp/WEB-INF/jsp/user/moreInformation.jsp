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
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%=basePath %>" />
    	<title>修改资料</title>
        <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
        <script type="text/javascript" src="js/tools.js"></script>
        <script type="text/javascript" src="js/user/moreInformation.js"></script>
    </head>
    <body>
        <div id="menuPanel">
            <ul>
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
    
        <div id="userPanel">
            <form action="moreInformationAction" method="post">
                <table>
                    <tr>
                        <td>绑定手机</td>
                        <td>
                            <c:if test="${user.telephone == null}">
                                尚未绑定&nbsp&nbsp<a href="bindingTelephone">绑定</a>
                            </c:if>
                            <c:if test="${user.telephone != null}">
                                ${user.telephone } &nbsp&nbsp<a href="unbindingTelephone">解除绑定</a>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>绑定邮箱</td>
                        <td>
                            <c:if test="${user.email == null}">
                                尚未绑定&nbsp&nbsp<a href="bindingEmail">绑定</a>
                            </c:if>
                            <c:if test="${user.email != null}">
                                ${user.email } &nbsp&nbsp<a href="unbindingEmail">解除绑定</a>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期</td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>联系地址</td>
                        <td><input type="text" name="address"/></td>
                    </tr>
                    <tr>
                        <td>邮编</td>
                        <td><input type="text" name="zip"/></td>
                    </tr>
                    <tr>
                        <td>其它联系方式</td>
                        <td><input type="text" name="contactInformation"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>