package jiezhang.init;

import jiezhang.service.MenuService;
import jiezhang.base.service.RedisService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

//import zjobs.service.DictService;

/**
 * 随系统启动
 *
 * @author ZJOBS
 * @date 2015/2/22
 */
@Component
public class InitAuthorityListener implements InitializingBean, ServletContextAware {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisService redisService;

    @Override
    public void afterPropertiesSet() throws Exception {
        menuService.updateRedisMenu();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("setServletContext");
    }
}
