package jiezhang.service;


import jiezhang.entity.db.Dict;

/**
 * 数据字典服务
 *
 * @author jiezhang
 */
public interface DictService extends BaseService<Dict, Exception> {
    /**
     * 重置redis中的数据字典
     */
    public void resetRedisDict() throws Exception;


    /**
     * 更新redis中的数据字典
     */
    public void updateRedisDict() throws Exception;

}
