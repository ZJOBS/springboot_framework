package jiezhang.console.controller;

import cn.hutool.core.map.MapUtil;
import com.baidu.aip.nlp.AipNlp;
import com.rabbitmq.client.Channel;
import jiezhang.base.entity.Result;
import jiezhang.base.mq.AmqpMessageSender;
import org.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * 默认控制层(包含一堆测试代码)
 *
 * @author jiezhang
 */
@Controller
public class DefaultController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private AmqpMessageSender amqpMessageSender;


    /**
     * 欢迎页
     *
     * @return
     */
    @RequestMapping("/")
    public String view() {
        return "index";
    }

    //设置APPID/AK/SK
    public static final String APP_ID = "18599117";
    public static final String API_KEY = "Exh1lfyE07hwqDhMU6rRzG5v";
    public static final String SECRET_KEY = "pGEC7qeEkPoCGrR6mRGvt0LEGF0TW8X6";

    @RequestMapping("/baidu/nlp")
    @ResponseBody
    public String show() {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String text = "1、收1亿足年双国股 2、代友询价收年内到期授信城商 3、代友出年内国股小票，城商票 欢迎小窗，好友位备需";
        JSONObject res = client.lexer(text, null);
        System.out.println(res);
        return res.toString();
    }

    /**
     * 已实现通过监听redis实现订阅与发布功能
     *
     * @param
     * @return jiezhang.base.entity.Result
     * @author ZhangJie
     * @description
     * @date 9:16 下午 2020/3/18
     */
    @RequestMapping("sendMessage")
    @ResponseBody
    public Result sendMessage() {
        redisTemplate.convertAndSend("TOPIC", "收到订阅消息");
        return Result.ofSuccess();
    }


    @RequestMapping("sendMQ")
    @ResponseBody
    public Result sendMQ() {
        amqpMessageSender.sendMessage("bb", "cc", MapUtil.of("message", "消息"));
        return Result.ofSuccess();
    }
}
