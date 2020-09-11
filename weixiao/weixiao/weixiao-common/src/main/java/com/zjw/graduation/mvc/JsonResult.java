package com.zjw.graduation.mvc;

public class JsonResult<T> {

    private int code; // 参数异常：-1 ~ -10; 业务异常: -11 ~ -20; 操作结果异常: -30+
    private String message; // default is success
    private T data;

    public JsonResult() {
        this.code = 0;
        this.message = "";
        this.data = null;
    }

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public JsonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> JsonResult<T>  success(String message) {
        return new JsonResult<T>(0, message);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(0, "success", data);
    }

    public static <T> JsonResult<T> success(String message, T data) {
        return new JsonResult<T>(0, message, data);
    }

    public static <T> JsonResult<T>  error(String message) {
        return new JsonResult<T>(-1, message);
    }

    public static <T> JsonResult<T> error(String message, T data) {
        return new JsonResult<T>(-1, message, data);
    }

    public static <T> JsonResult<T> error(int code, String message) {
        return new JsonResult<T>(code, message);
    }

    public static <T> JsonResult<T> error(int code, String message, T data) {
        return new JsonResult<T>(code, message, data);
    }
}
