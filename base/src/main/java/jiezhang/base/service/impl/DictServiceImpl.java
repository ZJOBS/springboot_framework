package jiezhang.base.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jiezhang.base.constant.RedisConstants;
import jiezhang.base.entity.db.Dict;
import jiezhang.base.mapper.DictMapper;
import jiezhang.base.service.AbstractService;
import jiezhang.base.service.DictService;
import jiezhang.base.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * 数据字段服务实现
 *
 * @author jiezhang
 */
@Service
public class DictServiceImpl extends AbstractService<Dict, DictMapper> implements DictService {

    @Autowired
    private RedisService redisService;

    @Override
    public void resetRedisDict() throws Exception {
        //插叙出所有的字典
        //{dictId:[{"name":"","value":""},{"name":"","value":""}]}
        Map<String, JSONArray> dictMaps = new HashMap<String, JSONArray>();
        List<Dict> rootDict = new LinkedList<Dict>();

        //统计dict按Code ：value放入dictMaps中
        List<Dict> dictList = mapper.selectAll();
        //把parentId作为Key
        for (Dict dict : dictList) {
            if ("0".equals(dict.getParentId())) {
                rootDict.add(dict);
            } else if (dictMaps.containsKey(dict.getParentId())) {
                //包含的时候
                JSONObject dictObj = new JSONObject();
                dictObj.put("name", dict.getName());
                dictObj.put("value", dict.getValue());
                dictMaps.get(dict.getParentId()).add(dictObj);
            } else {
                //不包含的时候
                JSONArray jsonArray = new JSONArray();
                Map<String, String> dictMap = new HashMap<String, String>();
                dictMap.put("name", dict.getName());
                dictMap.put("value", dict.getValue());
                jsonArray.add(dictMap);
                dictMaps.put(dict.getParentId(), jsonArray);
            }
        }
        JSONObject jsonObject;
        for (Dict dict : rootDict) {
            jsonObject = new JSONObject();
            jsonObject.put("name", dict.getName());
            jsonObject.put("value", dictMaps.get(dict.getDictId()));
            redisService.put(RedisConstants.DICT, dict.getCode(), jsonObject.toJSONString());
        }
    }

    @Override
    public void updateRedisDict() throws Exception {

    }


}
