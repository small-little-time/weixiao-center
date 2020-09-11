package com.zjw.graduation.enums;

public enum EnumLogicType {
    DELETE(0, "删除"),NORMAL(1, "正常"),ALL(99, "全部" );

    private Integer value;

    private String message;

    EnumLogicType(Integer value, String message) {
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
