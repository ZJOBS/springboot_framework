package jiezhang.tag.web;


import jiezhang.tag.base.AbstractWebUiTag;

import java.util.Map;

/**
 * 向导
 *
 * @author jiezhang
 */
public class Wizard extends AbstractWebUiTag {
    private String urls;

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    @Override
    public String getStartTemplate() {
        return "wizard.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();

        return data;
    }
}
