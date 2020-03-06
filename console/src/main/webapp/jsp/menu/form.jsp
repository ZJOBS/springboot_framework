    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
        <html>
        <body>
        <form class="form-horizontal" role="form">
        <zj:input name="menuId" text="编号" hide="hide"/>
        <zj:input name="parentId" text="父编号"/>
        <zj:input name="name" text="名称"/>
        <zj:input name="url" text="URL"/>
        <zj:input name="image" text="image"/>
        <zj:switch name="activating" text="启用"/>
        <zj:switch name="leaf" text="子节点"/>
        </form>
        </body>
        </html>
