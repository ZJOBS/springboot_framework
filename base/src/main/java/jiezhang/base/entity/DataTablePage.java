package jiezhang.base.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页封装对象
 *
 * @param <T> 泛型T
 * @author ZhangJie
 * @date 2018/02/09
 */
@Data
public class DataTablePage<T> {
    /**
     * 页面发来的参数，同步返回就行
     */
    private int sEcho;
    /**
     * 开始
     */
    int iDisplayStart;

    /**
     * 长度
     */
    int iDisplayLength;
    /**
     * 请求参数
     */
    private Map<String, Object> params = new HashMap<String, Object>();

    //返回参数
    /**
     * 记录总数
     */
    private int iTotalRecords;
    /**
     * 显示记录数
     */
    private int iTotalDisplayRecords;

    int recordsFiltered = 0;
    /**
     * 表的总记录数 必要
     */
    int recordsTotal = 0;

    /**
     * 返回记录
     */
    private List<T> aaData;


}
