package com.zjw.graduation.controller.post;


import com.zjw.graduation.service.post.PostLikeService;
import com.zjw.graduation.model.post.PostLikeCreateModel;
import com.zjw.graduation.model.post.PostLikeUpdateModel;
import com.zjw.graduation.entity.post.PostLike;
import com.zjw.graduation.dto.post.PostLikeDto;
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
 * 点赞表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-21 20:08:05
 */
@RestController("PostLikeController")
@RequestMapping("/post")
@Api(value = "post.PostLikeController", tags = {"点赞表"})
public class PostLikeController {

    @Autowired
    private PostLikeService postLikeService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postLikes")
    @ApiOperation("点赞表列表")
    public JsonResult<PagingResult<PostLikeDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostLike> page = postLikeService.page(pageIndex, pageSize);
        PagingResult<PostLikeDto> convert = page.convert(item -> {
            PostLikeDto postLikeDto = new PostLikeDto();
            BeanUtils.copyProperties(item, postLikeDto);
            return postLikeDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postLike/{id}")
    @ApiOperation("点赞表详情")
    public JsonResult<PostLikeDto> detail(@PathVariable("id") Long id) {

        PostLike postLike = postLikeService.get(id);

        PostLikeDto postLikeDto = new PostLikeDto();
        BeanUtils.copyProperties(postLike, postLikeDto);

        return JsonResult.success(postLikeDto);
    }

    /**
     * 新增
     *
     * @param postLikeCreateModel
     * @return
     */
    @PostMapping("/postLike")
    @ApiOperation("点赞表新增")
    public JsonResult<PostLikeDto> create(@Validated @RequestBody PostLikeCreateModel postLikeCreateModel) {

        PostLike postLike = new PostLike();
        BeanUtils.copyProperties(postLikeCreateModel, postLike);
        postLikeService.save(postLike);

        PostLikeDto postLikeDto = new PostLikeDto();
        BeanUtils.copyProperties(postLike, postLikeDto);

        return JsonResult.success(postLikeDto);

    }

    /**
     * 修改
     *
     * @param postLikeUpdateModel
     * @return
     */
    @PutMapping("/postLike")
    @ApiOperation("点赞表修改")
    public JsonResult<PostLikeDto> update(@Validated @RequestBody PostLikeUpdateModel postLikeUpdateModel) {

        PostLike entity = postLikeService.modify(postLikeUpdateModel);

        PostLikeDto postLikeDto = new PostLikeDto();
        if (entity != null ) BeanUtils.copyProperties(entity, postLikeDto);
        return JsonResult.success(postLikeDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postLike/{id}")
    @ApiOperation("点赞表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postLikeService.delete(id);

        return JsonResult.success("删除成功");
    }

}
