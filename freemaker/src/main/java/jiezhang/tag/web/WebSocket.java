package jiezhang.tag.web;

import jiezhang.tag.base.AbstractWebUiTag;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebSocket extends AbstractWebUiTag {
    /**
     * 是否打印websocket状态
     */
    private String isPrint;

    /**
     * websocket地址
     */
    private String url;

    public String getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(String isPrint) {
        this.isPrint = isPrint;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getStartTemplate() {
        return "webSocket.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("isPrint", isPrint);
        data.put("url", url);
        return data;
    }
}
