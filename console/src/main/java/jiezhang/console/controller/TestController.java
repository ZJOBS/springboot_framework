package jiezhang.console.controller;

import jiezhang.console.entity.Persion;
import jiezhang.console.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
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
}
