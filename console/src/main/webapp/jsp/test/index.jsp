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
    <jsp:include page="/jsp/common/style.jsp"/>
    <jsp:include page="/jsp/common/js.jsp"/>
    <script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script>
        /*是否可以变为调用数据字典生成此方法*/
        function formatState(data, type, full) {
            return data == 0 ? '禁用' : '启用';
        };

        function formatImage(data, type, full) {
            var URL = "http://omjgaayha.bkt.clouddn.com/" + data;
            return "<img src='" + URL + "' height='50' width='50'/>"
        };

        // var websocket = null;
        // //当前浏览前是否支持websocket
        // if ("WebSocket" in window) {
        //     var url = "ws://localhost:8080/console/user/";
        //     websocket = new WebSocket(url);
        // } else {
        //     alert("浏览器不支持websocket");
        // }
        //
        // websocket.onopen = function (event) {
        //     setMessage("打开连接");
        // }
        //
        // websocket.onclose = function (event) {
        //     setMessage("关闭连接");
        // }
        //
        // websocket.onmessage = function (event) {
        //     setMessage(event.data);
        // }
        //
        // websocket.onerror = function (event) {
        //     setMessage("连接异常");
        // }
        //
        // //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        //
        // window.onbeforeunload = function () {
        //     closeWebsocket();
        // }
        //
        // //关闭websocket
        // function closeWebsocket() {
        //     //3代表已经关闭
        //     if (3 != websocket.readyState) {
        //         websocket.close();
        //     } else {
        //         alert("websocket之前已经关闭");
        //     }
        // }
        //
        // //将消息显示在网页上
        // function setMessage(message) {
        //     console.log(message);
        // }


        var websocket = null;
        //当前浏览前是否支持websocket

        if ("WebSocket" in window) {
            var url = "ws://localhost:8080/console/websocket/server";
            websocket = new WebSocket(url);
        } else {
            alert("浏览器不支持websocket");
        }


        websocket.onopen = function (event) {
            setMessage("打开连接");
        }

        websocket.onclose = function (event) {
            setMessage("关闭连接");
        }
        websocket.onmessage = function (event) {
            setMessage(event.data);
        }
        websocket.onerror = function (event) {
            setMessage("连接异常");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            closeWebsocket();
        }

        //关闭websocket
        function closeWebsocket() {
            //3代表已经关闭
            if (3 != websocket.readyState) {
                websocket.close();
            } else {
                alert("websocket之前已经关闭");
            }
        }

        //将消息显示在网页上
        function setMessage(message) {
            console.log(message);
        }
    </script>
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
                    <%--已完成--%>
                    <zj:select name="country" code="COUNTRY" text="国籍"/>
                    <input type="submit">
                </form>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
</div><!-- /.main-container -->

</body>
</html>
