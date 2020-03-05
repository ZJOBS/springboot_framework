package jiezhang.base.constant;

/**
 * @author ZhangJie
 * @description
 * @date 11:11 上午 2020/3/4
 * @return
 */
public enum ResultEnum {
    SUCCESS(000, "成功"), fail500(500, "系统异常");

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 返回值编码
     */
    private Integer code;
    /**
     * 返回值 文本
     */
    private String msg;

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

}
