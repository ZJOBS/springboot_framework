package jiezhang.tag.base;

import cn.hutool.core.util.StrUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jiezhang.base.context.SpringContext;
import jiezhang.base.service.RedisService;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象基础tag对象包含参数
 *
 * @author ZhangJie
 */
public abstract class AbstractWebUiTag extends BaseTag {
    /**
     * ID
     */
    protected String id;

    protected RedisService redisService;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }


    public RedisService getRedisService() {
        return redisService;
    }

    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * 获取传入值
     *
     * @return
     */
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>(2);
        data.put("contextPath", getRequest().getContextPath());
        if (StrUtil.isNotBlank(getId())) {
            data.put("id", getId());
        }
        return data;
    }


    @Override
    public int doStartTag() throws JspException {
        try {
            redisService = SpringContext.getBean("redisServiceImpl");
            String templateName = getStartTemplate();
            if (templateName != null) {
                String result = process(templateName, getData());
                output(result);
                getOut().flush();
            } else {
                output("<" + getTagName() + ">");
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }

        return EVAL_BODY_INCLUDE;
    }

    protected Template getTemplate(String templateName) {
        FreeMarkerConfigurer freeMarkerConfigurer = SpringContext.getBean("freeMarkerConfigurer");
        Configuration cfg = freeMarkerConfigurer.getConfiguration();
        Template temp = null;
        try {
            temp = cfg.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    protected String process(Template temp, Object data) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        try {
            temp.process(data, writer);
        } finally {
            writer.close();
        }
        return writer.getBuffer().toString();
    }

    protected String process(String templateName, Object data) throws TemplateException, IOException {
        StringWriter writer = new StringWriter();
        try {
            getTemplate(templateName).process(data, writer);
        } finally {
            writer.close();
        }
        return writer.getBuffer().toString();
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            String templateName = getEndTemplate();
            if (templateName != null) {
                String result = process(templateName, getData());
                output(result);
                getOut().flush();
            } else {
                output("</" + getTagName() + ">");

            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    public abstract String getStartTemplate();

    public String getEndTemplate() {
        return null;
    }

    public String getTagName() {
        return getClass().getSimpleName().toLowerCase();
    }

}
