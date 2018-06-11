package web;

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
}
