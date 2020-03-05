package jiezhang.base.entity;

/**
 * @author ZhangJie
 * @description 全局返回对象
 * @date 5:34 下午 2020/3/3
 * @return
 */
public class Result {
    Boolean success;
    Integer code;
    String msg;
    Object data;

    /**
     * @return jiezhang.base.entity.Result
     * @author ZhangJie
     * @description 成功返回
     * @date 5:42 下午 2020/3/3
     */
    public static Result ofSuccess() {
        return new Result() {
            {
                setSuccess(Boolean.TRUE);
                setCode(200);
                setMsg("成功！");
            }
        };
    }

    /**
     * @param obj 返回参数
     * @return jiezhang.base.entity.Result
     * @author ZhangJie
     * @description 成功返回
     * @date 5:43 下午 2020/3/3
     */
    public static Result ofSuccess(Object obj) {
        Result result = ofSuccess();
        result.setData(obj);
        return result;
    }

    /**
     * @param code 失败返回code
     * @param msg  失败返回消息
     * @return jiezhang.base.entity.Result
     * @author ZhangJie
     * @description 失败返回
     * @date 5:43 下午 2020/3/3
     */
    public static Result ofFail(Integer code, String msg) {
        return new Result() {
            {
                setSuccess(Boolean.FALSE);
                setCode(code);
                setMsg(msg);
            }
        };
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
