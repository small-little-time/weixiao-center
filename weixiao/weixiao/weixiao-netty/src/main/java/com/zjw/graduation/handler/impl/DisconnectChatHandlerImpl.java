package com.zjw.graduation.handler.impl;

import com.zjw.graduation.enums.MsgActionEnum;
import com.zjw.graduation.handler.ChatHandler;
import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.server.NettyServerHandler;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DisconnectChatHandlerImpl implements ChatHandler {

    private final static Logger logger = LoggerFactory.getLogger(DisconnectChatHandlerImpl.class);

    @Override
    public void handler(DataContent dataContent, Channel currentChannel) {
        currentChannel.close();
        logger.info("客户端主动关闭，channelId为：{}" + currentChannel.id().asShortText());
    }

    @Override
    public Integer getType() {
        return MsgActionEnum.DISCONNECT.getType();
    }
}
