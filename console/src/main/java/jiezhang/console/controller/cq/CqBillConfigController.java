package jiezhang.console.controller.cq;

import jiezhang.base.controller.BaseController;
import jiezhang.base.entity.DataTablePage;
import jiezhang.console.entity.db.CqBillConfig;
import jiezhang.console.service.CqBillConfigService;
import jiezhang.entity.db.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CqBillConfigController extends BaseController<CqBillConfig, CqBillConfigService> {


    @RequestMapping(value = "cqBillConfig/index")
    public String cqBillConfig() {
        return "cqBillConfig/index";
    }

    @RequestMapping(value = "queryCqBillConfig")
    @ResponseBody
    @Override
    public DataTablePage<CqBillConfig> pageQuery(CqBillConfig cqBillConfig) {
        return super.pageQuery(cqBillConfig);
    }

    @RequestMapping(value = "addCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "添加字典")
    @Override
    public int add(CqBillConfig cqBillConfig) {
        return super.add(cqBillConfig);
    }


    @RequestMapping(value = "deleteCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "删除字段")
    @Override
    public int delete(CqBillConfig cqBillConfig) {
        return super.delete(cqBillConfig);
    }


    @RequestMapping(value = "updateCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "修改字典")
    @Override
    public int update(CqBillConfig cqBillConfig) {
        return super.update(cqBillConfig);
    }

}
