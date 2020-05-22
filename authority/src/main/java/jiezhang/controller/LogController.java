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
public class LogController extends BaseController<Log, LogService> {


    @RequestMapping(value = "logIndex")
    public String log() {
        return "log/index";
    }

    @RequestMapping(value = "queryLog")
    @ResponseBody
    public DataTablePage<Log> pageQueryLog(Log log) {
        return super.pageQuery(log);
    }
}
