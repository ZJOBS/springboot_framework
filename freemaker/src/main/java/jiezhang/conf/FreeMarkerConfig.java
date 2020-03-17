package jiezhang.conf;

import freemarker.template.TemplateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

@Configuration
public class FreeMarkerConfig {
    @Bean(name = "freeMarkerConfigurer")
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        //从freemarker 项目中获取.ftl
        configurer.setPreferFileSystemAccess(false);
        configurer.setTemplateLoaderPaths("classpath:/templates");
        configurer.setDefaultEncoding("UTF-8");
        return configurer;
    }
}
