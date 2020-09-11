package com.zjw.graduation.controller;


import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.pojo.DataContent;
import com.zjw.graduation.service.message.MessageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 聊天消息表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-13 15:28:37
 */
@RestController("MessageContentController")
@RequestMapping("/message")
public class MessageContentController {

    @Autowired
    private MessageContentService messageContentService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/messageContents")
    public JsonResult<List<DataContent>> list(@RequestParam(value = "id")Long id) {
        List<DataContent> list = messageContentService.list(id);
        return JsonResult.success(list);
    }

    /**
     * 列表
     *
     * @return
     */
    @PutMapping("/batchsign")
    public JsonResult batchSign(@RequestParam(value = "ids")String ids) {
        messageContentService.batchSign(ids);
        return JsonResult.success("");
    }

}
