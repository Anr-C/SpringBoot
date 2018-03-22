package com.lckiss.exception;

public class BusinessException extends Exception {
    /**
     * 异常处理编码
     */
    private Integer code;
    /**
     * 异常处理信息
     */
    private String msg;
    /**
     * 具体描述
     */
    private String desc;

    public BusinessException(Integer code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public BusinessException(String msg) {
        this.msg = msg;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
