package jiezhang.console.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Persion {
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
}
