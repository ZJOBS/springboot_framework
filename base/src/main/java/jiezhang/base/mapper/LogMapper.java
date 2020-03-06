package jiezhang.base.mapper;


import jiezhang.base.entity.db.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志数据处理接口
 *
 * @author jiezhang
 * @date 2017/4/13
 */
@Mapper
public interface LogMapper extends BaseMapper<Log, Exception> {
}
