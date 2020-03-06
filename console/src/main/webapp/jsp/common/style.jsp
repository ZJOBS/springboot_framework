<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/bootstrap.min.css"/>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/component/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>
<!-- page specific plugin styles -->
<!-- text fonts -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/fonts.googleapis.com.css"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/jquery-ui.min.css"/>

<!-- ace styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/ace.min.css"
      class="ace-main-stylesheet" id="main-ace-style"/>
<!--[if lte IE 9]>
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/ace-part2.min.css"
class="ace-main-stylesheet"/>
<![endif]-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/ace-skins.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/ace-rtl.min.css"/>

<!--[if lte IE 9]>
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/ace-ie.min.css"/>
<![endif]-->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/component/assets/css/dropzone.min.css"/>

<%--日期时间选择器--%>
<link href="${pageContext.request.contextPath}/component/datetimepicker/bootstrap-datetimepicker.min.css"
      rel="stylesheet">

<![endif]-->
<style type="text/css">
    /*去除ace样式中背景的灰色*/
    body {
        background-color: transparent;
    }

    .context {
        width: 98%;
        margin-left: auto;
        margin-right: auto;
    }

    /*#page_button {*/
    /*position: relative;*/
    /*top: 350px;*/
    /*}*/
</style>