package jiezhang.config;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


public abstract class BaseViewResolverConfiguration {

    /**
     * @return org.springframework.web.servlet.ViewResolver
     * @author ZhangJie
     * @description 配置支持JSP
     * @date 1:14 下午 2020/3/17
     */
    public ViewResolver getJspViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setOrder(1);
        return internalResourceViewResolver;

    }

    /**
     * @param
     * @return org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver
     * @author ZhangJie
     * @description 配置支持 FREEMARKER
     * @date 1:15 下午 2020/3/17
     */
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setRequestContextAttribute("request");
        freeMarkerViewResolver.setOrder(0);
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        return freeMarkerViewResolver;
    }

}
