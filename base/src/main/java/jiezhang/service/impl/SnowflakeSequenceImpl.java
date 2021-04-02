package jiezhang.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import jiezhang.service.SequenceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * twitter的snowflake算法 -- java实现
 * git 地址https://github.com/beyondfengyu/SnowFlake/blob/master/SnowFlake.java
 *
 * @author beyond
 * @date 2016/11/26
 */
@Service
public class SnowflakeSequenceImpl implements SequenceService {

    @Value("${properties.server_dataCenterId}")
    private String dataCenterId;

    @Value("${properties.server_machineId}")
    private String machineId;


    /**
     * 产生下一个ID
     *
     * @return
     */
    @Override
    public synchronized long getSequence() {
        Snowflake snowflake = IdUtil.getSnowflake(Integer.valueOf(this.machineId), Integer.valueOf(this.dataCenterId));
        return snowflake.nextId();
    }

}
