package jiezhang.base.controller;

import jiezhang.base.entity.DataTablePage;
import jiezhang.base.entity.db.Dict;
import jiezhang.base.service.DictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangJie on 2016/3/17.
 */
@Controller
public class DictController extends BaseController<Dict, DictService> {


    @RequestMapping(value = "dictIndex")
    public String dict() {
        return "dict/index";
    }

    @RequestMapping(value = "queryDict")
    @ResponseBody
    @Override
    public DataTablePage<Dict> pageQuery(Dict dict) {
        return super.pageQuery(dict);
    }


    @RequestMapping(value = "addDict")
    @ResponseBody
    @Override
    public int add(Dict dict) {
        return super.add(dict);
    }


    @RequestMapping(value = "deleteDict")
    @ResponseBody
    public int deleteDict(Dict dict) {
        return super.delete(dict);
    }


    @RequestMapping(value = "updateDict")
    @ResponseBody
    public int updateDict(Dict dict) {
        return super.update(dict);
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
