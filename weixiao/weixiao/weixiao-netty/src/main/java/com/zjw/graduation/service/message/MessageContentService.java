package com.zjw.graduation.service.message;

import com.zjw.graduation.entity.message.MessageContent;
import com.zjw.graduation.pojo.DataContent;

import java.util.List;

/**
 * 聊天消息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-13 15:28:37
 */
public interface MessageContentService {

    MessageContent get(Long id);

    MessageContent save(MessageContent Admin);

    MessageContent update(MessageContent Admin);

    void delete(Long id);

    List<DataContent> list(Long id);

    void batchSign(String ids);
}

