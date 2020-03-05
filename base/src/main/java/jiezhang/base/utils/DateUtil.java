package jiezhang.base.utils;

import cn.hutool.core.util.StrUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 *
 * @author ZhangJie
 * @date 2015/6/12
 */
public class DateUtil {

    /**
     * 时间格式(yyyyMMdd)
     */
    public final static String DATE_PATTERN = "yyyyMMdd";

    public final static String DATETIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 时间格式(yyyy年MM月dd日)
     */
    public final static String DATE_CH_PATTERN = "yyyy年MM月dd日";


    /**
     * 时间格式(yyyy年MM月dd日 HH时mm分ss秒)
     */
    public final static String DATE_TIME_CH_PATTERN = "yyyy年MM月dd日 HH时mm分ss秒";


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
     * 获取距离当前日期多少天的日期
     *
     * @param format 日期格式
     * @param op     +1 加1  -1 减1
     * @return String
     */
    public static String get(String format, int op) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, op);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取日期
     *
     * @param format 日期格式
     * @return String
     * @throws ParseException
     */
    public static String formatDateStr(String format, String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        Date date = sdf.parse(dateStr);
        calendar.setTime(date);
        return sdf.format(calendar.getTime());
    }

    /**
     * 计算时间
     *
     * @param oprTime   操作时间 yyyy-MM-dd HH:ss:mm
     * @param spaceTime 间隔小时
     * @return
     * @throws Exception
     */
    public static String calcTime(String oprTime, int spaceTime) throws Exception {
        if (StrUtil.isNotBlank(oprTime)) {
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
            Calendar calendar = Calendar.getInstance();
            try {
                Date oprDate = sdf.parse(oprTime);
                calendar.setTime(oprDate);
                long cTime = calendar.getTimeInMillis();
                cTime = cTime + spaceTime * 60 * 60 * 1000;
                calendar.setTimeInMillis(cTime);
            } catch (ParseException exc) {
                exc.printStackTrace();
                throw new Exception("时间操作错误！");
            }
            return df.format(calendar.getTime());
        } else {
            throw new Exception("操作时间不能为空！");
        }
    }

    public static String getDateFormat(String sdate, String strFormatS, String strFormatE) {
        SimpleDateFormat sdf = new SimpleDateFormat(strFormatS);
        SimpleDateFormat format = new SimpleDateFormat(strFormatE);
        try {
            return (format.format(sdf.parse(sdate)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 推算距离date多少时间的一个日期，以前负数，将来正数,
     *
     * @param dateStr 指标日期
     * @param yy      年
     * @param mm      月
     * @param dd      日
     * @return 日期 yyyyMMdd
     */
    public static String calculation(String dateStr, int yy, int mm, int dd) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (ParseException e) {
            //保证传入参数dateStr为时间格式包含年月日 parse方法不会抛异常
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, yy);
        calendar.add(Calendar.MONTH, mm);
        calendar.add(Calendar.DAY_OF_YEAR, dd);
        return formatter.format(calendar.getTime());
    }

    /**
     * 获取今日
     *
     * @return
     */
    public static String getTodayDate() {
        return new SimpleDateFormat(DATE_PATTERN).format(new Date());
    }


    /**
     * 获取当前时间时分秒
     *
     * @return
     */
    public static String getTimeStamp() {
        return new SimpleDateFormat(DATETIME_PATTERN).format(new Date());
    }

}

