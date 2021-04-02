package jiezhang.constant;

import java.time.format.DateTimeFormatter;

/**
 * 日期格式化
 *
 * @param
 * @author ZhangJie
 * @description
 * @date 11:26 上午 2020/6/8
 * @return
 */
public enum DatePattern {

    /**
     * yyyy-MM-dd
     */
    DATE_NORM_FORMAT(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
    PURE_DATE_FORMAT(DateTimeFormatter.ofPattern("yyyyMMdd")),
    DATETIME_NORM_FORMAT(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),

    DATE_CH_FORMAT(DateTimeFormatter.ofPattern("yyyy年MM月dd日")),
    DATE_TIME_CH_FORMAT(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")),
    ;
    /**
     * 日期格式化对象
     */
    private DateTimeFormatter dateTimeFormatter;

    /**
     * 构造器
     *
     * @param dateTimeFormatter
     */
    DatePattern(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }
}
