package com.zjw.graduation.server;

import com.zjw.graduation.handler.ChatHandler;
import com.zjw.graduation.pojo.DataContent;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("handlerManage")
public class HandlerManage {

    private Map<Integer, ChatHandler> handlerMap = new HashMap<>();

    public HandlerManage(List<ChatHandler> chatHandlers){
        for (ChatHandler chatHandler: chatHandlers){
            handlerMap.put(chatHandler.getType(), chatHandler);
        }
    }

    void handler(DataContent dataContent, Channel currentChannel){
        handlerMap.get(dataContent.getAction()).handler(dataContent, currentChannel);
    }
}
