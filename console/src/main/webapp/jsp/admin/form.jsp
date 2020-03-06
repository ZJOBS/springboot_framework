<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">

    <zj:input name="adminId" text="管理员ID" hide="hide"/>
    <zj:input name="name" text="姓名"/>
    <zj:switch name="activating" text="激活"/>
    <zj:file name="file" text="头像"/>
    <zj:input name="description" text="描述"/>
</form>
</body>
</html>
