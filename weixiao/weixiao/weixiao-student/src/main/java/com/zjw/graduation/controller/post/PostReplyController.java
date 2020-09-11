package com.zjw.graduation.controller.post;


import com.zjw.graduation.service.post.PostReplyService;
import com.zjw.graduation.model.post.PostReplyCreateModel;
import com.zjw.graduation.model.post.PostReplyUpdateModel;
import com.zjw.graduation.entity.post.PostReply;
import com.zjw.graduation.dto.post.PostReplyDto;
import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.data.PagingResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;


/**
 * 回复表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@RestController("PostReplyController")
@RequestMapping("/post")
@Api(value = "post.PostReplyController", tags = {"回复表"})
public class PostReplyController {

    @Autowired
    private PostReplyService postReplyService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postReplys")
    @ApiOperation("回复表列表")
    public JsonResult<PagingResult<PostReplyDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostReply> page = postReplyService.page(pageIndex, pageSize);
        PagingResult<PostReplyDto> convert = page.convert(item -> {
            PostReplyDto postReplyDto = new PostReplyDto();
            BeanUtils.copyProperties(item, postReplyDto);
            return postReplyDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postReply/{id}")
    @ApiOperation("回复表详情")
    public JsonResult<PostReplyDto> detail(@PathVariable("id") Long id) {

        PostReply postReply = postReplyService.get(id);

        PostReplyDto postReplyDto = new PostReplyDto();
        BeanUtils.copyProperties(postReply, postReplyDto);

        return JsonResult.success(postReplyDto);
    }

    /**
     * 新增
     *
     * @param postReplyCreateModel
     * @return
     */
    @PostMapping("/postReply")
    @ApiOperation("回复表新增")
    public JsonResult<PostReplyDto> create(@Validated @RequestBody PostReplyCreateModel postReplyCreateModel) {

        PostReply postReply = new PostReply();
        BeanUtils.copyProperties(postReplyCreateModel, postReply);
        postReplyService.save(postReply);

        PostReplyDto postReplyDto = new PostReplyDto();
        BeanUtils.copyProperties(postReply, postReplyDto);

        return JsonResult.success(postReplyDto);

    }

    /**
     * 修改
     *
     * @param postReplyUpdateModel
     * @return
     */
    @PutMapping("/postReply")
    @ApiOperation("回复表修改")
    public JsonResult<PostReply> update(@Validated @RequestBody PostReplyUpdateModel postReplyUpdateModel) {

        PostReply postReply = postReplyService.get(postReplyUpdateModel.getId());
        if (postReply.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(postReplyUpdateModel, postReply, NullPropertyUtils.getNullPropertyNames(postReplyUpdateModel));
        postReply.setUpdated(LocalDateTime.now());
        PostReply entity = postReplyService.update(postReply);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postReply/{id}")
    @ApiOperation("回复表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postReplyService.delete(id);

        return JsonResult.success("删除成功");
    }

}
