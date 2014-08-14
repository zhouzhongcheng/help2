<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath %>" />
    <title>发布商品</title>
</head>
<body>
    <h2>发布商品</h2>
    <form action="releaseGoodsAction" method="post">
        <table>
            <tr>
                <td>商品名：</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>分类Id：</td>
                <td><input type="text" name="goodsTypeId" /></td>
            </tr>
            <tr>
                <td>价格：</td>
                <td><input type="text" name="price" /></td>
            </tr>
            <tr>
                <td>学校Id：</td>
                <td><input type="text" name="schoolId" /></td>
            </tr>
            <tr>
                <td>描述：</td>
                <td><input type="text" name="description" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="发布" /></td>
                <td><input type="reset" value="重置" /></td>
            </tr>
        </table>
    </form>
    跳转至
    <a href="home">主界面</a>
</body>
</html>