package com.zjw.graduation.server;

import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.util.JsonUtils;
import com.zjw.graduation.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

    public static final ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private HandlerManage handlerManage = (HandlerManage) SpringUtil.getBean("handlerManage");

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String text = textWebSocketFrame.text();
        DataContent dataContent = JsonUtils.jsonToPojo(text, DataContent.class);
        System.out.println(dataContent);
        if (dataContent != null) {
            Channel currentChannel = channelHandlerContext.channel();
            handlerManage.handler(dataContent, currentChannel);
//            if (action == MsgActionEnum.CONNECT.type){
//                UserChannelRel.put(chatInfo.getSenderId(),currentChannel);
//                logger.info("连接成功 ... {},clients大小：{}",currentChannel.id(),clients.size());
//            }else if (action == MsgActionEnum.CHAT.type){
//                Long receiverId = chatInfo.getReceiverId();
//                Channel channel = UserChannelRel.get(receiverId);
//                if(channel != null){
//                    Channel receiverChannel = clients.find(channel.id());
//                    if (receiverChannel != null){
//                        receiverChannel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(dataContent)));
//                    }
//                }else{
//                    logger.info("写入离线消息...");
//                    MessageService messageService = (MessageService) SpringUtil.getBean("messageServiceImpl");
//                    Message message = new Message();
//                    message.setSenderId(chatInfo.getSenderId());
//                    message.setReceiverId(chatInfo.getReceiverId());
//                    message.setContent(chatInfo.getMessage());
//                    message.setIsSign(1);
//                    message.setSendTime(LocalDateTime.now());
//                    messageService.create(message);
//                }
//            }
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
        clients.remove(ctx.channel());
        logger.info("客户端被移除，channelId为：{}" + ctx.channel().id().asShortText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        logger.info("客户端被移除，channelId为：{}" + ctx.channel().id().asShortText());
        clients.remove(ctx.channel());
    }
}
