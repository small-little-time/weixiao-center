package com.zjw.graduation;

import com.zjw.graduation.server.NettyServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NettyBoot implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        NettyServer instance = NettyServer.getInstance();
        instance.start();
    }
}
