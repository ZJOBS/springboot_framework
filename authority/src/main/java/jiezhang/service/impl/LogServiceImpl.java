package jiezhang.service.impl;

import jiezhang.entity.db.Log;
import jiezhang.mapper.LogMapper;
import jiezhang.service.LogService;
import jiezhang.base.service.AbstractService;
import org.springframework.stereotype.Service;

/**
 * 日志服务实现
 *
 * @author jiezhang
 */
@Service
public class LogServiceImpl extends AbstractService<Log, LogMapper> implements LogService {
}
