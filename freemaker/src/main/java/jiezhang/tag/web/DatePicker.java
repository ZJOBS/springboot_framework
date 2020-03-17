package jiezhang.tag.web;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jiezhang.tag.base.FormTag;

import java.util.Map;

/**
 * 日期选择器
 *
 * @author jiezhang
 */
public class DatePicker extends FormTag {
    /**
     * 默认选中时间
     */
    private String initialDate;

    /**
     * 不可选中时间
     */
    private String disabledDate;
    /**
     * 最早可选择时间
     */
    private String startDate;
    /**
     * 最晚可选择时间
     */
    private String endDate;


    /**
     * 时间格式
     */
    private String format;

    /**
     * 最开始选择的日期
     */
    private String startView;

    /**
     * 最小的时间
     */
    private String minView;

    /**
     * 最大的时间
     */
    private String maxView;

    /**
     * 是否展现今日按钮
     */
    private String todayBtn;

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(String disabledDate) {
        this.disabledDate = disabledDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTodayBtn() {
        return todayBtn;
    }

    public void setTodayBtn(String todayBtn) {
        this.todayBtn = todayBtn;
    }

    public String getStartView() {
        return startView;
    }

    public void setStartView(String startView) {
        this.startView = startView;
    }

    public String getMinView() {
        return minView;
    }

    public void setMinView(String minView) {
        this.minView = minView;
    }

    public String getMaxView() {
        return maxView;
    }

    public void setMaxView(String maxView) {
        this.maxView = maxView;
    }

    @Override
    public String getStartTemplate() {
        return "datepicker.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        try {
            data.put("format", format);
            if (StrUtil.isNotBlank(todayBtn)) {
                data.put("todayBtn", todayBtn);
            }
            if (StrUtil.isNotBlank(minView)) {
                data.put("minView", minView);
            }
            if (StrUtil.isNotBlank(maxView)) {
                data.put("maxView", maxView);
            }
            if (StrUtil.isNotBlank(startView)) {
                data.put("startView", startView);
            }
            //不能选中的日期，从redis中取
            if (StrUtil.isNotBlank(disabledDate)) {
                JSONObject disabledJson = JSONObject.parseObject(redisService.get("DISABLED_DATE", disabledDate).toString());
                JSONArray array = disabledJson.getJSONArray("value");
                data.put("disabledDate", array);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
