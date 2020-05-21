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
public class CqBillConfigController extends BaseController {

    @Autowired
    private CqBillConfigService cqBillConfigService;

    @RequestMapping(value = "cqBillConfig/index")
    public String cqBillConfig() {
        return "cqBillConfig/index";
    }

    @RequestMapping(value = "queryCqBillConfig")
    @ResponseBody
    public DataTablePage<CqBillConfig> pageQuerycqBillConfig(CqBillConfig cqBillConfig) {
        DataTablePage<CqBillConfig> page = null;
        try {
            page = cqBillConfigService.queryPage(cqBillConfig.toMap(), createDataTablePage(cqBillConfig));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping(value = "addCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "添加字典")
    public int addCqBillConfig(CqBillConfig CqBillConfig) {
        int flag = 0;
        try {
            flag = cqBillConfigService.createEntity(CqBillConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "删除字段")
    public int deleteCqBillConfig(CqBillConfig CqBillConfig) {
        int flag = 0;
        try {
            flag = cqBillConfigService.removeEntity(CqBillConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateCqBillConfig")
    @ResponseBody
    @SystemLog(module = "长琴票据识别字段模块", methods = "修改字典")
    public int updateCqBillConfig(CqBillConfig CqBillConfig) {
        int flag = 0;
        try {
            flag = cqBillConfigService.modifyEntity(CqBillConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
