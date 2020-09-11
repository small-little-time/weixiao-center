package com.zjw.graduation.pojo;

import java.io.Serializable;

public class ChatInfo implements Serializable {

    private Long senderId;
    private String senderAvatar;
    private String senderNickname;
    private Long receiverId;
    private String message;
    private String msgId;

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public String getSenderNickname() {
        return senderNickname;
    }

    public void setSenderNickname(String senderNickname) {
        this.senderNickname = senderNickname;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "ChatInfo{" +
                "senderId=" + senderId +
                ", senderAvatar='" + senderAvatar + '\'' +
                ", senderNickname='" + senderNickname + '\'' +
                ", receiverId=" + receiverId +
                ", message='" + message + '\'' +
                ", msgId='" + msgId + '\'' +
                '}';
    }
}
