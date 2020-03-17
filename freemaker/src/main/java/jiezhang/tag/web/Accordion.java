package jiezhang.tag.web;

import com.alibaba.fastjson.JSONArray;
import jiezhang.base.constant.BaseConstants;
import jiezhang.base.constant.RedisConstants;
import jiezhang.entity.UAI;
import org.springframework.stereotype.Component;
import jiezhang.tag.base.AbstractWebUiTag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * 手风琴菜单
 *
 * @author jiezhang
 * @date 2017/6/13
 */
@Component
public class Accordion extends AbstractWebUiTag {

    @Override
    public String getStartTemplate() {
        return "accordion.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        try {
            UAI uai = (UAI) getRequest().getSession().getAttribute(BaseConstants.UAI);
            Object obj = redisService.get(RedisConstants.MENU, RedisConstants.ADMIN + uai.getAdminId());
            JSONArray jsonArray = JSONArray.parseArray(obj.toString());
            data.put("treeMenu", jsonArray);
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
