package jiezhang.base.controller;

import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;
import jiezhang.base.entity.db.UserAccount;
import jiezhang.base.service.BaseService;
import jiezhang.base.service.QiNiuService;
import jiezhang.base.service.SequenceService;
import jiezhang.base.utils.DataConversionUtil;
import jiezhang.base.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class BaseController<T extends BaseEntity, D extends BaseService<T, Exception>> {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    @Autowired
    protected D service;

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    protected SequenceService sequenceService;

    @Autowired
    protected QiNiuService qiNiuService;

    @ModelAttribute
    protected void setReqAndResAndSes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    protected Map<String, Object> getParametersMap(String parameters) {
        return JsonUtil.jsonToMap(parameters);
    }


    protected DataTablePage<T> createDataTablePage(T parameter) {
        DataTablePage<T> page = new DataTablePage<T>();
        int sEcho = Integer.valueOf(getParameterInt("sEcho", 1));
        int iDisplayStart = Integer.valueOf(getParameterInt("iDisplayStart", 1));
        int iDisplayLength = Integer.valueOf(getParameterInt("iDisplayLength", 10));

        //排序参数
        //排序的列号
        String order = getParameterString("iSortCol_0");
        //排序的顺序asc or desc
        String orderDir = getParameterString("sSortDir_0");
        //排序的列。注意，我认为页面上的列的名字要和表中列的名字一致，否则，会导致SQL拼接错误
        String orderColumn = getParameterString("mDataProp_" + order);
        orderColumn = DataConversionUtil.underline(orderColumn);
        //加入排序数据
        Map<String, Object> pmp = parameter.toMap();
        pmp.put("orderColumn", orderColumn);
        pmp.put("orderDir", orderDir);

        page.setSEcho(sEcho);
        page.setIDisplayStart(iDisplayStart);
        page.setIDisplayLength(iDisplayLength);
        page.setParams(pmp);
        return page;
    }


    protected int getParameterInt(String name) {
        return getParameterInt(name, 0);
    }

    protected int getParameterInt(String name, int defaultValue) {
        String parameter = getRequest().getParameter(name);
        return parameter == null || "".equals(parameter) ? defaultValue
                : Integer.valueOf(parameter);
    }

    protected String getParameterString(String name) {
        return getParameterString(name, "");
    }

    protected String getParameterString(String name, String defaultValue) {
        String parameter = getRequest().getParameter(name);
        return parameter == null ? defaultValue : parameter;
    }

    protected UserAccount getUser() {
        return (UserAccount) getSession().getAttribute("user");
    }

//    protected Long getUserId() {
//        UserAccount u = getUser();
//        return u == null ? 0 : u.getId();
//    }

//    protected String getUserName() {
//        UserAccount u = getUser();
//        return u == null ? "" : u.getName();
//    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected HttpSession getSession() {
        return session;
    }

    protected void setSession(HttpSession session) {
        this.session = session;
    }


    protected DataTablePage<T> pageQuery(T entity) {
        DataTablePage<T> page = null;
        try {
            page = service.queryPage(entity.toMap(), createDataTablePage(entity));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


    protected int add(T entity) {
        int flag = 0;
        try {
            flag = service.createEntity(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected int delete(T dict) {
        int flag = 0;
        try {
            flag = service.removeEntity(dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    protected int update(T dict) {
        int flag = 0;
        try {
            flag = service.modifyEntity(dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
