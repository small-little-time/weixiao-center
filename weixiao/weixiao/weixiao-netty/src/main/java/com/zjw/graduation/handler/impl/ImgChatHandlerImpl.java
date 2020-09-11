package com.zjw.graduation.handler.impl;

import com.zjw.graduation.enums.MsgActionEnum;
import com.zjw.graduation.handler.ChatHandler;
import com.zjw.graduation.pojo.DataContent;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

@Component
public class ImgChatHandlerImpl implements ChatHandler {
    @Override
    public void handler(DataContent dataContent, Channel currentChannel) {

    }

    @Override
    public Integer getType() {
        return MsgActionEnum.IMG.getType();
    }
}
