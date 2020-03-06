<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form class="form-horizontal" role="form" enctype="multipart/form-data">
    <zj:input name="productId" text="单据编号" hide="hide"/>
    <zj:input name="name" text="单据名称"/>
    <zj:input name="type" text="类别" />
    <zj:switch name="state" text="状态"/>
</form>
</body>
</html>
