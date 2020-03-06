<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form">
    <zj:input name="roleId" text="编号" hide="hide"/>
    <zj:input name="name" text="角色名称"/>
    <zj:switch name="activating" text="激活"/>
    <zj:input name="description" text="描述"/>
</form>
</body>
</html>
