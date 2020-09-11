package com.zjw.graduation.enums;

public enum MsgActionEnum {

    CONNECT(1, "第一次(或重连)初始化连接"),
    WORD(2, "文字消息"),
    EMOJI(3, "表情消息"),
    IMG(4, "图片消息"),
    VIDEO(5, "视频消息"),
    SIGNED(6, "消息签收"),
    KEEPALIVE(7, "客户端保持心跳"),
    DISCONNECT(8, "断开连接");

    public final Integer type;
    public final String content;

    MsgActionEnum(Integer type, String content) {
        this.type = type;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }
}
