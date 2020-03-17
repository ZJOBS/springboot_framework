package jiezhang.tag.base;

import java.util.Map;

/**
 * 表单标签抽象类
 *
 * @author jiezhang
 */
public abstract class FormTag extends AbstractWebUiTag {
    private String text;
    private String name;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("name", name);
        data.put("text", text);
        return data;
    }
}
