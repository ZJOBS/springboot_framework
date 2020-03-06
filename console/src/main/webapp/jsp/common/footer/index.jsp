<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<div class="footer">
    <div class="footer-inner">
        <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">管理台</span>
							Application &copy; 2017-2100
						</span>
            &nbsp; &nbsp;
            <span class="action-buttons">
                    <a href="#">
                        <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                    </a>
                    <a href="#">
                        <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                    </a>
                    <a href="#">
                        <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                    </a>
                </span>
        </div>
    </div>
</div>


<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${contextPath}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>

<!-- page specific plugin scripts -->
<script src="${pageContext.request.contextPath}/component/assets/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/jquery.dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/buttons.colVis.min.js"></script>
<script src="${pageContext.request.contextPath}/component/assets/js/dataTables.select.min.js"></script>
<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/component/assets/js/ace-elements.min.js"></script>
</html>