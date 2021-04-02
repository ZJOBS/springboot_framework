package jiezhang.init;

import jiezhang.service.MenuService;
import jiezhang.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import zjobs.service.DictService;

/**
 * 随系统启动
 *
 * @author ZJOBS
 * @date 2015/2/22
 */
@Component
public class InitAuthorityListener implements CommandLineRunner
//        InitializingBean, ServletContextAware

{
    @Autowired
    private MenuService menuService;
    @Autowired
    private RedisService redisService;

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        menuService.updateRedisMenu();
//    }
//
//    @Override
//    public void setServletContext(ServletContext servletContext) {
//        System.out.println("setServletContext");
//    }

    @Override
    public void run(String... args) throws Exception {
        menuService.updateRedisMenu();
    }
}
