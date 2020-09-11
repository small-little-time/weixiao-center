package com.zjw.graduation.enums;

public enum EnumStatusType {
    ERROR(-1,"数据异常"),LOSE(-2, "token失效"),NOTALLOW(-3, "没有权限");

    private Integer value;

    private String type;

    EnumStatusType(Integer value, String type) {
        this.value = value;
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
