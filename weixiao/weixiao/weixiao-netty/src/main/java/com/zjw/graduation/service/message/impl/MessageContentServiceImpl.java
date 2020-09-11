package com.zjw.graduation.service.message.impl;

import com.zjw.graduation.entity.message.MessageContent;
import com.zjw.graduation.pojo.ChatInfo;
import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.repository.message.MessageContentDao;
import com.zjw.graduation.service.message.MessageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service("MessageContentServiceImpl")
public class MessageContentServiceImpl implements MessageContentService  {

    @Autowired
    private MessageContentDao messageContentDao;

    @Override
    public MessageContent get(Long id) {
        return messageContentDao.findById(id).orElse(new MessageContent());
    }

    @Override
    public MessageContent save(MessageContent messageContent) {
        return messageContentDao.save(messageContent);
    }

    @Override
    public MessageContent update(MessageContent messageContent) {
        return messageContentDao.save(messageContent);
    }

    @Override
    public void delete(Long id) {
        MessageContent messageContent = messageContentDao.findById(id).orElse(null);
        if (messageContent != null){
            messageContent.setLogicFlag(0);
            messageContentDao.save(messageContent);
        }
    }

    @Override
    public List<DataContent> list(Long id) {
        List<MessageContent> list = messageContentDao.findAllByReceiverIdAndIsSignIsAndLogicFlagIs(id,1,1);
        return list.stream().map(item -> {
            DataContent dataContent = new DataContent();
            ChatInfo chatInfo = new ChatInfo();
            dataContent.setAction(item.getType());
            dataContent.setExtend(item.getSendTime().toString());
            chatInfo.setSenderId(item.getSenderId());
            chatInfo.setSenderAvatar(item.getSenderAvatar());
            chatInfo.setSenderNickname(item.getSenderNickname());
            chatInfo.setReceiverId(item.getReceiverId());
            chatInfo.setMessage(item.getContent());
            chatInfo.setMsgId(String.valueOf(item.getId()));
            dataContent.setChatInfo(chatInfo);
            return dataContent;
        }).collect(Collectors.toList());
    }

    @Override
    public void batchSign(String ids) {
        List<Long> collect = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        messageContentDao.batchSign(collect);
    }

}
