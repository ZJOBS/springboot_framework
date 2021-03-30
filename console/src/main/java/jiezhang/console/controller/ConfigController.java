package jiezhang.console.controller;

import jiezhang.entity.db.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 测试springcloud参数建立的对象，无业务意义
 *
 * @param
 * @author ZhangJie
 * @description
 * @date 4:25 下午 2021/3/29
 * @return
 */
@Controller
@RequestMapping("config")
@RefreshScope
public class ConfigController {
    @Value(value = "${useLocalCache}")
    private String useLocalCache;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public String get() {
        return useLocalCache;
    }

    @RequestMapping(value = "/mongodbInsert", method = GET)
    @ResponseBody
    public String mongodbInsert() {
        Log log = new Log();
        log.setLogId("1L");
        log.setIp("22");
        mongoTemplate.save(log);
        return useLocalCache;
    }

}
