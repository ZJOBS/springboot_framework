<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!-- inline styles related to this page -->
<!-- ace settings handler -->
<script src="${pageContext.request.contextPath}/component/assets/js/ace-extra.min.js"></script>
<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
<!--[if lte IE 8]>
<script src="${pageContext.request.contextPath}/component/assets/js/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/respond.min.js"></script>
<![endif]-->


<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/component/assets/js/dropzone.min.js"></script>

<script src="${pageContext.request.contextPath}/component/common.js"></script>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>


<%---原底部引入文件--------------------------%>
<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${pageContext.request.contextPath}/component/assets/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/component/jquery.form.js"></script>

<!-- <![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/component/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${pageContext.request.contextPath}/component/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->


<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js"></script>

<%--<script src="${pageContext.request.contextPath}/component/assets/js/jquery.dataTables.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/component/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.colVis.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/component/assets/js/dataTables.select.min.js"></script>--%>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/component/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/jquery.ui.touch-punch.min.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/component/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/ace.min.js"></script>

<%--日期时间讯择期--%>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/component/datetimepicker/bootstrap-datetimepicker.min.js"
        charset="UTF-8"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/component/datetimepicker/bootstrap-datetimepicker.zh-CN.js"
        charset="UTF-8"></script>

<%--编辑工具--%>
<script src="${pageContext.request.contextPath}/component/assets/js/bootstrap-wysiwyg.min.js"></script>

<script src="${pageContext.request.contextPath}/component/Util.js"></script>
<script src="${pageContext.request.contextPath}/component/Main.js"></script>

<script type="text/javascript">
    /**
     * 工具对象
     */
    var util = $.createUtil();

    /**
     * 主控对象，需要改名，叫Main不好
     */
    var main = $.createMain();
</script>