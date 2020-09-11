package com.zjw.graduation.pojo;

import java.io.Serializable;

public class DataContent implements Serializable {

    private Integer action;
    private ChatInfo chatInfo;
    private String extend;

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public ChatInfo getChatInfo() {
        return chatInfo;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "DataContent{" +
                "action=" + action +
                ", chatInfo=" + chatInfo +
                ", extend='" + extend + '\'' +
                '}';
    }
}
