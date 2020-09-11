package com.zjw.graduation.handler.impl;

import com.zjw.graduation.enums.MsgActionEnum;
import com.zjw.graduation.handler.ChatHandler;
import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.server.NettyServerHandler;
import com.zjw.graduation.server.UserChannelRel;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ConnectChatHandlerImpl implements ChatHandler {

    private final static Logger logger = LoggerFactory.getLogger(ConnectChatHandlerImpl.class);

    @Override
    public void handler(DataContent dataContent, Channel currentChannel) {
        UserChannelRel.put(dataContent.getChatInfo().getSenderId(), currentChannel);
        logger.info("{} 连接成功 ... {},clients大小：{}",dataContent.getChatInfo().getSenderId(), currentChannel.id(), NettyServerHandler.clients.size());
    }

    @Override
    public Integer getType() {
        return MsgActionEnum.CONNECT.getType();
    }
}
