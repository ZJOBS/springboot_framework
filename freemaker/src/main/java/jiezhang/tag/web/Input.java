package jiezhang.tag.web;


import jiezhang.tag.base.FormTag;

import java.util.Map;

/**
 * 输入框
 *
 * @author jiezhang
 */
public class Input extends FormTag {

    private String hide;

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("hide", hide);
        return data;
    }

    @Override
    public String getStartTemplate() {
        return "input.ftl";
    }
}
