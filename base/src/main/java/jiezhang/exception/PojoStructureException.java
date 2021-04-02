package jiezhang.exception;

/**
 * Created by ZhangJie on 2016/4/19.
 */
public class PojoStructureException extends RuntimeException {

    public PojoStructureException(String msg) {
        super(msg);
    }

    public PojoStructureException(String msg, Throwable e) {
        super(msg, e);
    }
}
