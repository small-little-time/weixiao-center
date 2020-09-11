package com.zjw.graduation.handler.impl;

import com.zjw.graduation.entity.message.MessageContent;
import com.zjw.graduation.enums.MsgActionEnum;
import com.zjw.graduation.handler.ChatHandler;
import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.server.NettyServerHandler;
import com.zjw.graduation.server.UserChannelRel;
import com.zjw.graduation.service.message.MessageContentService;
import com.zjw.graduation.util.JsonUtils;
import com.zjw.graduation.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class WordChatHandlerImpl implements ChatHandler {

    private final static Logger logger = LoggerFactory.getLogger(WordChatHandlerImpl.class);

    @Override
    public void handler(DataContent dataContent, Channel currentChannel) {
        Long receiverId = dataContent.getChatInfo().getReceiverId();
        Channel channel = UserChannelRel.get(receiverId);
        if(channel != null){
            Channel receiverChannel = NettyServerHandler.clients.find(channel.id());
            if (receiverChannel != null){
                receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(dataContent)));
            } else {
                logger.info("写入离线消息....");
                MessageContentService messageContentServiceImpl = (MessageContentService) SpringUtil.getBean("MessageContentServiceImpl");
                MessageContent messageContent = new MessageContent();
                messageContent.setSenderId(dataContent.getChatInfo().getSenderId());
                messageContent.setSenderAvatar(dataContent.getChatInfo().getSenderAvatar());
                messageContent.setSenderNickname(dataContent.getChatInfo().getSenderNickname());
                messageContent.setContent(dataContent.getChatInfo().getMessage());
                messageContent.setReceiverId(dataContent.getChatInfo().getReceiverId());
                messageContent.setType(dataContent.getAction());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime time = LocalDateTime.parse(dataContent.getExtend(), formatter);
                messageContent.setSendTime(time);
                messageContentServiceImpl.save(messageContent);
            }
        } else {
            logger.info("写入离线消息...");
            MessageContentService messageContentServiceImpl = (MessageContentService) SpringUtil.getBean("MessageContentServiceImpl");
            MessageContent messageContent = new MessageContent();
            messageContent.setSenderId(dataContent.getChatInfo().getSenderId());
            messageContent.setSenderAvatar(dataContent.getChatInfo().getSenderAvatar());
            messageContent.setSenderNickname(dataContent.getChatInfo().getSenderNickname());
            messageContent.setContent(dataContent.getChatInfo().getMessage());
            messageContent.setReceiverId(dataContent.getChatInfo().getReceiverId());
            messageContent.setType(dataContent.getAction());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime time = LocalDateTime.parse(dataContent.getExtend(), formatter);
            messageContent.setSendTime(time);
            messageContentServiceImpl.save(messageContent);
        }
    }

    @Override
    public Integer getType() {
        return MsgActionEnum.WORD.getType();
    }
}
