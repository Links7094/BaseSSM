package web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
