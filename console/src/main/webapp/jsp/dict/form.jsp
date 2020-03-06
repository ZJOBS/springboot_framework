<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form">
    <zj:input name="dictId" text="编号" hide="hide"/>
    <zj:input name="parentId" text="父编号"/>
    <zj:input name="code" text="编码"/>
    <zj:input name="name" text="名称"/>
    <zj:input name="value" text="值"/>
    <zj:switch name="activating" text="激活"/>
</form>
</body>
</html>
