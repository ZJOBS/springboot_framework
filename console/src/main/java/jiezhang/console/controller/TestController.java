package jiezhang.console.controller;

import jiezhang.console.entity.Persion;
import jiezhang.base.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class TestController {

    @Value("${image_server}")
    private String val;

    @RequestMapping("/")
    @ResponseBody
    public Result test() {
        Persion persion = new Persion();
        persion.setName("张");
        persion.setAge(11);
        persion.setDate(new Date());
        int i = 1 / 0;
        return Result.ofSuccess(persion);
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "jsp张杰");
        return "index";
    }

    @RequestMapping("/show")
    public String show(Model model) {
        model.addAttribute("name", "ftl张杰");
        return "show";
    }
}