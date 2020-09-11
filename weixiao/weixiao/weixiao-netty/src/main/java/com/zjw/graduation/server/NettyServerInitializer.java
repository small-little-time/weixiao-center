package com.zjw.graduation.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline ch = socketChannel.pipeline();
        ch.addLast(new HttpServerCodec());
        ch.addLast(new ChunkedWriteHandler());
        ch.addLast(new HttpObjectAggregator(1024*64));
        ch.addLast(new IdleStateHandler(30, 0, 50));
        ch.addLast(new HeartBeatHandler());
        ch.addLast(new WebSocketServerProtocolHandler("/ws"));
        ch.addLast(new NettyServerHandler());
    }
}
