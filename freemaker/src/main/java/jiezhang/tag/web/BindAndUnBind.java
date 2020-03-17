package jiezhang.tag.web;


import org.springframework.stereotype.Component;
import jiezhang.tag.base.AbstractWebUiTag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * 一对多，绑定与解绑模板
 *
 * @author jiezhang
 * @date 2017/6/13
 */
@Component
public class BindAndUnBind extends AbstractWebUiTag {


    /**
     * 源表ID
     */
    private String sourceTableId;
    /**
     * 点击唤醒位置
     */
    private String awakenPosition;


    /**
     * keyName
     */
    private String keyName;

    /**
     * relationName
     */
    private String relationName;

    /**
     * 左边部分请求URL
     */
    private String leftQueryUrl;
    /**
     * 取消绑定请求URL
     */
    private String deleteUrl;
    /**
     * 右边部分请求URL
     */
    private String rightQueryUrl;
    /**
     * 添加绑定请求URL
     */
    private String addUrl;

    /**
     * Title
     */
    protected String columnTitle;
    /**
     * 名称
     */
    protected String columnName;

    public String getSourceTableId() {
        return sourceTableId;
    }

    public void setSourceTableId(String sourceTableId) {
        this.sourceTableId = sourceTableId;
    }

    public String getAwakenPosition() {
        return awakenPosition;
    }

    public void setAwakenPosition(String awakenPosition) {
        this.awakenPosition = awakenPosition;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getLeftQueryUrl() {
        return leftQueryUrl;
    }

    public void setLeftQueryUrl(String leftQueryUrl) {
        this.leftQueryUrl = leftQueryUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getRightQueryUrl() {
        return rightQueryUrl;
    }

    public void setRightQueryUrl(String rightQueryUrl) {
        this.rightQueryUrl = rightQueryUrl;
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("sourceTableId", sourceTableId);
        data.put("awakenPosition", awakenPosition);
        data.put("keyName", keyName);
        data.put("relationName", relationName);
        data.put("leftQueryUrl", leftQueryUrl);
        data.put("deleteUrl", deleteUrl);
        data.put("rightQueryUrl", rightQueryUrl);
        data.put("addUrl", addUrl);
        String[] columnTitles = columnTitle.split(",");
        data.put("columnTitle", columnTitles);
        data.put("columnName", columnName);
        data.put("columnLength", columnTitles.length - 1);
        data.put("columnName", columnName);
        return data;
    }

    @Override
    public String getStartTemplate() {
        return "bindAndUnbind.ftl";
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
