package jiezhang.base.exception;

/**
 * Created by Administrator on 2015/2/28.
 */
public class DataBaseException extends Exception {
    public DataBaseException() {
        super();
    }

    /**
     * 通过有参构造函数，自定义错误消息。
     *
     * @param msg
     */
    public DataBaseException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param cause
     */
    public DataBaseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }
}
