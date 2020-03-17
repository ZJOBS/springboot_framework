package jiezhang.console.controller;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        String text = "收本月托收银票，票限制少，芜湖扬子农商行 邵文浩 。";
        JSONObject res = client.lexer(text, null);
        return res.toString();
    }
}
