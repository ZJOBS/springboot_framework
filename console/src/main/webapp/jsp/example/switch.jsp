<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>Product</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <jsp:include page="/WEB-INF/common/style.jsp"/>
    <jsp:include page="/WEB-INF/common/js.jsp"/>
</head>

<body class="no-skin">

<div class="main-container ace-save-state">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="clearfix">
                    <div class="pull-right tableTools-container"></div>
                </div>
                <form class="form-horizontal" role="form" enctype="multipart/form-data" action="test.do">
                    <zj:switch name="activating" text="激活"/>
                </form>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->


</body>
</html>
