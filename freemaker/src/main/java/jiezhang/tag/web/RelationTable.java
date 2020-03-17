package jiezhang.tag.web;


import jiezhang.tag.base.AbstractWebUiTag;
import javax.servlet.jsp.JspException;
import java.util.Map;

/**
 * @author jiezhang
 * @date 2017/7/12
 */
public class RelationTable extends AbstractWebUiTag {
    protected String caption;
    protected String queryUrl;
    protected String columnTitle;
    protected String columnName;
    protected String columnFormat;
    protected String relation;
    protected String width;
    /**
     * 一页显示几行
     */
    protected String rowList;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getRowList() {
        return rowList;
    }

    public void setRowList(String rowList) {
        this.rowList = rowList;
    }

    @Override
    public String getStartTemplate() {
        return "relationtable.ftl";
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data = super.getData();
        data.put("queryUrl", queryUrl);
        data.put("caption", caption);
        String[] columnTitles = columnTitle.split(",");
        data.put("columnTitle", columnTitles);
        data.put("columnName", columnName);
        data.put("columnFormat", columnFormat);
        data.put("relation", relation);
        data.put("width", width);
        return data;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
