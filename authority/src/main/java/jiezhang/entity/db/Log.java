package jiezhang.entity.db;


import jiezhang.base.annotation.Id;
import jiezhang.base.entity.BaseEntity;

/**
 * 日志
 *
 * @author jiezhang
 */
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

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", adminId='" + adminId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", method='" + method + '\'' +
                ", responseDate='" + responseDate + '\'' +
                ", ip='" + ip + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
