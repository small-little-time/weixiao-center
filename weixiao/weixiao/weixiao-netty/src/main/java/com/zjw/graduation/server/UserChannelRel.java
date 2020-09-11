package com.zjw.graduation.server;

import io.netty.channel.Channel;

import java.util.HashMap;

public class UserChannelRel {
    private static HashMap<Long, Channel> manager = new HashMap<>();

    public static void put(Long senderId, Channel channel) {
        manager.put(senderId, channel);
    }

    public static Channel get(Long senderId) {
        return manager.get(senderId);
    }

    public static void remove(Long senderId) {
        manager.remove(senderId);
    }

    public static void output() {
        for (HashMap.Entry<Long, Channel> entry : manager.entrySet()) {
            System.out.println("UserId: " + entry.getKey()
                    + ", ChannelId: " + entry.getValue().id().asLongText());
        }
    }
}
