<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <%--<script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>--%>
	<%--<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>--%>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">

        <c:forEach items="${roleList}" var="role">
            <tr class="TableDetail1 template">
                <td>${role.name}&nbsp;</td>
                <%--<input type="hidden" value="${role.name}">--%>
                <td>${role.description}&nbsp;</td>-
                <td><a onClick="return delConfirm()" href="Role_Delete?role.rid=${role.rid}">删除</a>
                    <a href="Role_UpdateUI?role.rid=${role.rid}">修改</a>
                    <a href="Role_setPrivilegeUI?role.rid=${role.rid}">设置权限</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="Role_saveUI"><img src="../style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>
