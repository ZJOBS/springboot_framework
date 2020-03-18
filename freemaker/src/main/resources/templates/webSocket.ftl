<script type="text/javascript">
    var websocket = null;
    //当前浏览前是否支持websocket

    var isPrint = ${isPrint};
    if ("WebSocket" in window) {
        var url = '${url}';
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
        if (isPrint) {
            console.log(message);
        }
    }
</script>