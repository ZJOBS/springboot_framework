package jiezhang.console.config;

import jiezhang.base.config.BaseViewResolverConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class ViewResolverConfiguration extends BaseViewResolverConfiguration {

    @Override
    @Bean
    public ViewResolver getJspViewResolver() {
        return super.getJspViewResolver();
    }

    @Override
    @Bean
    public FreeMarkerViewResolver getFreeMarkerViewResolver() {
        return super.getFreeMarkerViewResolver();
    }
}
