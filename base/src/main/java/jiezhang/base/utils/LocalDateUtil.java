package jiezhang.base.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 *
 * @author ZhangJie
 * @date 2015/6/12
 */
public class LocalDateUtil {
    /**
     * 时间格式去除特殊字符
     *
     * @param sDate
     * @return
     */
    public static String matchSEDate(String sDate) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(sDate);
        return m.replaceAll("").replaceAll(" ", "");
    }


    /**
     * 两个日期相差时间,date1小，date2大为正数；date1大，date2小为负数
     *
     * @param date1      日期1
     * @param date2      日期2
     * @param chronoUnit 单位，年、月、日
     * @return java.lang.Long
     * @author ZhangJie
     * @description
     * @date 11:12 上午 2020/6/8
     */
    public static Long between(LocalDate date1, LocalDate date2, ChronoUnit chronoUnit) {
        return date2.until(date1, chronoUnit);
    }

    /**
     * 获取今天23:59:59的时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getMaxTimeOfToday() {
        return getMaxDateTime(LocalDateTime.now());
    }

    /**
     * 获取某天23:59:59的时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getMaxDateTime(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MAX);
    }

    /**
     * 获取今天00:00:00的时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getMinDateTimeOfToday() {
        return getMinDateTime(LocalDateTime.now());
    }

    /**
     * 获取某天00:00:00的时间
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getMinDateTime(LocalDateTime localDateTime) {
        return localDateTime.with(LocalTime.MIN);
    }


    /**
     * 获取该日期属于年度第几周
     *
     * @param date
     * @return
     */
    public static int getWeekSeqOfYear(LocalDate date) {
        WeekFields weekFields = WeekFields.of(DayOfWeek.MONDAY, 7);
        return date.get(weekFields.weekOfWeekBasedYear());
    }
}

