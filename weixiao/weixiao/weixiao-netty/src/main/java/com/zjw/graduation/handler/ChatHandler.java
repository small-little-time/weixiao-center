package com.zjw.graduation.handler;

import com.zjw.graduation.pojo.DataContent;
import io.netty.channel.Channel;

public interface ChatHandler {

    void handler(DataContent dataContent, Channel currentChannel);

    Integer getType();
}
