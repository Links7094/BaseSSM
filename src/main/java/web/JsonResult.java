package web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
        this.msg = msg == null ? code.getText() : msg;
        this.data = data;
    }

    public enum ResultCode {

        SUCCESS(0, "成功"),
        SERVICE_ERROR(-1, "系统异常"),
        VALIDATE_ERROR(-2, "校验异常"),;

        private int code;
        private String text;

        ResultCode(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        @JsonValue
        public int getCode() {
            return code;
        }

    }
}
