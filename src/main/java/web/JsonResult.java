package web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class JsonResult<T> {
    private ResultCode code;
    private String msg;
    private T data;

    public JsonResult(ResultCode code) {
        this(code, null, null);
    }

    public JsonResult(ResultCode code, String msg) {
        this(code, msg, null);
    }

    public JsonResult(ResultCode code, T data) {
        this(code, null, data);
    }

    public JsonResult(ResultCode code, String msg, T data) {
        this.code = code;
        this.msg = msg == null ? code.getDesc() : msg;
        this.data = data;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum ResultCode {

        SUCCESS(0, "成功"),
        SERVICE_ERROR(-1, "系统异常"),
        VALIDATE_ERROR(-2, "校验异常"),;

        private int code;
        private String desc;

        ResultCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        @JsonCreator
        public static ResultCode getItem(int code) {
            for (ResultCode item : values()) {
                if (item.code == code) {
                    return item;
                }
            }
            return null;
        }

        @JsonValue
        public int getCode() {
            return code;
        }
    }
}
