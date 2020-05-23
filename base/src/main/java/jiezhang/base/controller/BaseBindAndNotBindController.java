package jiezhang.base.controller;

import jiezhang.base.entity.BaseEntity;
import jiezhang.base.entity.DataTablePage;
import jiezhang.base.entity.db.Dict;
import jiezhang.base.entity.db.UserAccount;
import jiezhang.base.service.*;
import jiezhang.base.utils.DataConversionUtil;
import jiezhang.base.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ZhangJie by  on 2016/2/14.
 */
public class BaseBindAndNotBindController<M extends BaseEntity, T extends BaseEntity, F extends BaseEntity, E extends Exception, D extends BaseBindAndNotBindService<M, T, F, E>> {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Autowired
    private D bindAndNotBindService;


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


    protected DataTablePage<F> createDataTablePage(M parameter) {
        DataTablePage<F> page = new DataTablePage<F>();
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
        orderColumn = DataConversionUtil.underline(orderColumn).toString();
        //加入排序数据
        Map<String, Object> pmp = parameter.toMap();
        pmp.put("orderColumn", orderColumn);
        pmp.put("orderDir", orderDir);

        page.setsEcho(sEcho);
        page.setiDisplayStart(iDisplayStart);
        page.setiDisplayLength(iDisplayLength);
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


    protected DataTablePage<F> queryBindDataTablePage(M m) {
        DataTablePage<F> page = null;
        try {
            page = bindAndNotBindService.queryBindDataTablePage(m.toMap(), createDataTablePage(m));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


    protected DataTablePage<F> queryNotBindDataTablePage(M m) {
        DataTablePage<F> page = null;
        try {
            page = bindAndNotBindService.queryNotBindDataTablePage(m.toMap(), createDataTablePage(m));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }
}
