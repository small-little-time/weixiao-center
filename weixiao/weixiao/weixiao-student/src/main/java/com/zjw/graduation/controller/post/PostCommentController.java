package com.zjw.graduation.controller.post;


import com.zjw.graduation.dto.post.PostCommentAppViewDto;
import com.zjw.graduation.dto.post.PostCommentDto;
import com.zjw.graduation.service.post.PostCommentService;
import com.zjw.graduation.model.post.PostCommantCreateModel;
import com.zjw.graduation.model.post.PostCommantUpdateModel;
import com.zjw.graduation.entity.post.PostComment;
import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.view.post.PostCommentAppView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDateTime;


/**
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@RestController("PostCommentController")
@RequestMapping("/post")
@Api(value = "post.PostCommentController", tags = {"评论表"})
public class PostCommentController {

    @Autowired
    private PostCommentService postCommentService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postComments")
    @ApiOperation("列表")
    public JsonResult<PagingResult<PostCommentDto>> list(@RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                         @RequestParam(value = "pagesize", defaultValue = "10") int pageSize) {

        PagingResult<PostComment> page = postCommentService.page(pageIndex, pageSize);
        PagingResult<PostCommentDto> convert = page.convert(item -> {
            PostCommentDto postCommentDto = new PostCommentDto();
            BeanUtils.copyProperties(item, postCommentDto);
            return postCommentDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/app/postComments")
    @ApiOperation("app列表")
    public JsonResult<PagingResult<PostCommentAppViewDto>> appList(@RequestParam(value = "postid") Long postId,
                                                                   @RequestParam(value = "category") Long category,
                                                                   @RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                                   @RequestParam(value = "pagesize", defaultValue = "10") int pageSize) {

        PagingResult<PostCommentAppView> page = postCommentService.appList(postId, category, pageIndex, pageSize);
        PagingResult<PostCommentAppViewDto> convert = page.convert(item -> {
            PostCommentAppViewDto postCommentAppViewDto = new PostCommentAppViewDto();
            BeanUtils.copyProperties(item, postCommentAppViewDto);
            return postCommentAppViewDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postComment/{id}")
    @ApiOperation("详情")
    public JsonResult<PostCommentDto> detail(@PathVariable("id") Long id) {

        PostComment postComment = postCommentService.get(id);

        PostCommentDto postCommentDto = new PostCommentDto();
        BeanUtils.copyProperties(postComment, postCommentDto);

        return JsonResult.success(postCommentDto);
    }

    /**
     * 新增
     *
     * @param postCommantCreateModel
     * @return
     */
    @PostMapping("/postComment")
    @ApiOperation("新增")
    public JsonResult<PostCommentDto> create(@Validated @RequestBody PostCommantCreateModel postCommantCreateModel) {

        PostComment postComment = new PostComment();
        BeanUtils.copyProperties(postCommantCreateModel, postComment);
        postCommentService.save(postComment);

        PostCommentDto postCommentDto = new PostCommentDto();
        BeanUtils.copyProperties(postComment, postCommentDto);

        return JsonResult.success(postCommentDto);

    }

    /**
     * 修改
     *
     * @param postCommantUpdateModel
     * @return
     */
    @PutMapping("/postComment")
    @ApiOperation("修改")
    public JsonResult<PostComment> update(@Validated @RequestBody PostCommantUpdateModel postCommantUpdateModel) {

        PostComment postComment = postCommentService.get(postCommantUpdateModel.getId());
        if (postComment.getId() == null) {
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(postCommantUpdateModel, postComment, NullPropertyUtils.getNullPropertyNames(postCommantUpdateModel));
        postComment.setUpdated(LocalDateTime.now());
        PostComment entity = postCommentService.update(postComment);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postComment/{id}")
    @ApiOperation("删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postCommentService.delete(id);

        return JsonResult.success("删除成功");
    }

}
