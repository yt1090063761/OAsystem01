<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>用户列表</title>
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
<script>



</script>

<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        <c:forEach items="${ulist}" var="ulist">
        <tr class="TableDetail1 template">
            <td>${ulist.loginname}&nbsp;</td>
            <td>${ulist.name}&nbsp;</td>
            <td>${ulist.dept.name}&nbsp;</td>
            <td>${ulist.role.name}&nbsp;</td>
            <td><a onClick="return delConfirm()" href="list.jsp">删除</a>
                <a href="saveUI.jsp">修改</a>
                <a href="#" onClick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</a>
                <a href="user_setPrivilegeUI">设置权限</a>
            </td>
        </c:forEach>

        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="user_saveUI"><img src="../style/images/createNew.png" /></a>
        </div>
    </div>
</div>

</body>
</html>
