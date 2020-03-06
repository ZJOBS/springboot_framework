package jiezhang.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 默认控制层
 *
 * @author jiezhang
 */
@Controller
public class DefaultController {
    /**
     * 欢迎页
     *
     * @return
     */
    @RequestMapping("/")
    public String view() {
        return "index";
    }
}
