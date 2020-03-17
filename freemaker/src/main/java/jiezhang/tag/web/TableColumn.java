package jiezhang.tag.web;

import jiezhang.tag.base.AbstractWebUiTag;

import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * 表
 *
 * @author ZhangJie
 */
public class TableColumn extends AbstractWebUiTag {
    protected String caption;
    protected String search;
    protected String addUrl;
    protected String queryUrl;
    protected String editUrl;
    protected String deleteUrl;
    protected String columnTitle;
    protected String columnName;
    protected String columnFormat;
    protected String defaultOperation;
    protected String customOperation;
    protected String key;
    protected String formId;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
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

    public String getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(String columnFormat) {
        this.columnFormat = columnFormat;
    }

    public String getDefaultOperation() {
        return defaultOperation;
    }

    public void setDefaultOperation(String defaultOperation) {
        this.defaultOperation = defaultOperation;
    }

    public String getCustomOperation() {
        return customOperation;
    }

    public void setCustomOperation(String customOperation) {
        this.customOperation = customOperation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    @Override
    public String getStartTemplate() {
        return "tablecolumn.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("key", key);
        data.put("search", search);
        data.put("addUrl", addUrl);
        data.put("queryUrl", queryUrl);
        data.put("editUrl", editUrl);
        data.put("deleteUrl", deleteUrl);
        data.put("caption", caption);
        String[] columnTitles = columnTitle.split(",");
        data.put("columnTitle", columnTitles);
        data.put("columnLength", columnTitles.length - 1);
        data.put("columnName", columnName);
        data.put("columnFormat", columnFormat);
        data.put("defaultOperation", defaultOperation);
        data.put("customOperation", customOperation);
        data.put("formId", formId);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
