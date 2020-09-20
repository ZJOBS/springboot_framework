package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * 日志
 *
 * @author jiezhang
 */
@TableName(name = "system_log")
@Data
public class Log extends BaseEntity {
    /**
     * 日志编号
     */
    @Id
    private String logId;
    /**
     * 管理员编号
     */
    private String adminId;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * 执行方法
     */
    private String method;

    /**
     * 响应时间
     */
    private String responseDate;

    /**
     * IP
     */
    private String ip;

    /**
     * 时间
     */
    private String dateTime;

    /**
     * 结果描述
     */
    private String result;

}
