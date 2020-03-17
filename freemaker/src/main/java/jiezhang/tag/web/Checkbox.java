package jiezhang.tag.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jiezhang.tag.base.FormTag;
import jiezhang.base.constant.RedisConstants;

import javax.servlet.jsp.JspException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 封装checkbox标签
 *
 * @author jiezhang
 */
public class Checkbox extends FormTag {


    /**
     * 数据字典中的名称
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getStartTemplate() {
        return "checkbox.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        try {
            //form表单名称
            JSONObject selectJson = JSONObject.parseObject(redisService.get(RedisConstants.DICT, code).toString());
            //整个checkbox的名称
            data.put("label", selectJson.get("name"));
            List<Map<String, String>> list = new LinkedList<Map<String, String>>();
            JSONArray array = selectJson.getJSONArray("value");
            data.put("options", array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
