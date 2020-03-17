package jiezhang.console.config;

import freemarker.template.TemplateException;
import jiezhang.base.config.BaseViewResolverConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

@Configuration
public class ViewResolverConfiguration extends BaseViewResolverConfiguration {

    @Override
    @Bean
    public ViewResolver getJspViewResolver() {
        return super.getJspViewResolver();
    }


    @Override
    @Bean(name = "freeMarkerViewResolver")
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        return super.getFreeMarkerViewResolver();
    }

}
