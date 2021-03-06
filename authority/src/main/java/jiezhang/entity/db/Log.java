package jiezhang.entity.db;


import jiezhang.annotation.Id;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 日志
 *
 * @author jiezhang
 */
@TableName(name = "system_log")
@Data
@Document("system_log")
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
