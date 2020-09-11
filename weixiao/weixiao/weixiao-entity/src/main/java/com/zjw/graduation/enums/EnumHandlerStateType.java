package com.zjw.graduation.enums;

public enum EnumHandlerStateType {
    DISABLE(0, "全部"),NO(1, "未处理"),Finish(2, "已处理" );

    private Integer value;

    private String message;

    EnumHandlerStateType(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
