<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="zj" uri="http://www.zjobs.cn/jsp/jstl" %>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <jsp:include page="/jsp/common/index.jsp"></jsp:include>
    <style type="text/css">
        @media screen and (max-width: 1366px) {
            html {
                width: 1366px;
            }
        }

        @media screen and (max-width: 1024px) {
            html {
                width: 1024px;
            }
        }

        #left, #right {
            display: inline-block;
        }

        #left {
            position: relative;
            left: 30px;
            top: 20px;
            width: 15%;
        }

        #right {
            position: relative;
            vertical-align: top;
            left: 50px;
            top: 20px;
            width: 80%;
            height: 600px;
        }

        iframe {
            width: 100%;
            height: 700px; /*看看有没有方法全拼大小*/

        }

        html {
            position: absolute;
            top: 0px;
            left: 0px;
            right: 0px;
            bottom: 0px;
        }

        #body {
            height: 100%;
            position: absolute;
        }

        #menu {
            height: 100%;
            width: 25%;
            position: absolute;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $('#sidebar a').click(function () {
                var data_url = $(this).attr('data-url');
                if (data_url) {
                    $('iframe').attr('src', data_url);
                }
            });
        });
        //用于手风琴菜单
    </script>
    <title>HOME</title>
</head>
<body class="no-skin">
<jsp:include page="/jsp/common/header/index.jsp"></jsp:include>
<div class="main-container ace-save-state" id="main-container">
    <jsp:include page="/jsp/common/menu/index.jsp"></jsp:include>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-activating" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>

                    <li>
                        <a href="#">Tables</a>
                    </li>
                    <li class="active">Simple &amp; Dynamic</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <iframe src="" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no"
                    allowtransparency="true" style="background-color:transparent;"></iframe>
        </div>
    </div>
</div>
<jsp:include page="/jsp/common/footer/index.jsp"></jsp:include>
<%--<jsp:include page="/WEB-INF/common/menu/login.jsp"></jsp:include>--%>
</body>
</html>