package jiezhang.controller;


import jiezhang.base.entity.DataTablePage;
import jiezhang.entity.db.Log;
import jiezhang.service.LogService;
import jiezhang.base.controller.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志控制层
 *
 * @author jiezhang
 */
@Controller
public class LogController extends BaseController {

    @Autowired
    private LogService logService;


    @RequestMapping(value = "logIndex")
    public String log() {
        return "log/index";
    }

    @RequestMapping(value = "queryLog")
    @ResponseBody
    public DataTablePage<Log> pageQueryLog(Log log) {
        DataTablePage<Log> page = null;
        try {
            page = logService.queryPage(log.toMap(), createDataTablePage(log));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }
}
