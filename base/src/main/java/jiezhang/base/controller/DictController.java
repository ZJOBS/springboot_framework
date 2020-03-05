package jiezhang.base.controller;

import jiezhang.base.entity.DataTablePage;
import jiezhang.base.entity.db.Dict;
import jiezhang.base.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangJie on 2016/3/17.
 */
@SuppressWarnings("rawtypes")
@Controller
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @RequestMapping(value = "dictIndex")
    public String dict() {
        return "dict/index";
    }

    @RequestMapping(value = "queryDict")
    @ResponseBody
    public DataTablePage<Dict> pageQueryDict(Dict dict) {
        DataTablePage<Dict> page = null;
        try {
            page = dictService.queryPage(dict.toMap(), createDataTablePage(dict));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }


    @RequestMapping(value = "addDict")
    @ResponseBody
    public int addDict(Dict dict) {
        int flag = 0;
        try {
            flag = dictService.createEntity(dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "deleteDict")
    @ResponseBody
    public int deleteDict(Dict dict) {
        int flag = 0;
        try {
            flag = dictService.removeEntity(dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "updateDict")
    @ResponseBody
    public int updateDict(Dict dict) {
        int flag = 0;
        try {
            flag = dictService.modifyEntity(dict);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


//    @RequestMapping(value = "updateOrDeleteDict")
//    @ResponseBody
//    public int updateOrDeleteDict(@RequestParam("oper") Oper oper, Dict dict) {
//        int flag = 0;
//        try {
//            switch (oper) {
//                case add:
//                    flag = dictService.createEntity(dict);
//                    break;
//                case del:
//                    flag = dictService.removeEntity(dict);
//                    break;
//                case edit:
//                    flag = dictService.modifyEntity(dict);
//                    break;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return flag;
//
//
//    }
}
