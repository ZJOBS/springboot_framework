package jiezhang.console.controller;

import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {



    @RequestMapping("/test")
    public String test() {
        return "test/index";
    }

}
