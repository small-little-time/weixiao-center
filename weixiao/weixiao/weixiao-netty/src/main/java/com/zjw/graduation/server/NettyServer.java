package com.zjw.graduation.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {
    public static class SingletonNettyServer{
        static final NettyServer instance = new NettyServer();
    }
    public static NettyServer getInstance(){
        return SingletonNettyServer.instance;
    }

    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private ServerBootstrap server;
    private ChannelFuture channelFuture;

    public NettyServer(){
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new NettyServerInitializer());
    }

    public void start(){
        this.channelFuture = server.bind(8088);
        System.out.println("netty start ...");
    }
}
