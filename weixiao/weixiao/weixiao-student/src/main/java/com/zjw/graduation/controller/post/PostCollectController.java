package com.zjw.graduation.controller.post;


import com.zjw.graduation.service.post.PostCollectService;
import com.zjw.graduation.model.post.PostCollectCreateModel;
import com.zjw.graduation.model.post.PostCollectUpdateModel;
import com.zjw.graduation.entity.post.PostCollect;
import com.zjw.graduation.dto.post.PostCollectDto;
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
 * 收藏表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-04-07 15:00:56
 */
@RestController("PostCollectController")
@RequestMapping("/post")
@Api(value = "post.PostCollectController", tags = {"收藏表"})
public class PostCollectController {

    @Autowired
    private PostCollectService postCollectService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postCollects")
    @ApiOperation("收藏表列表")
    public JsonResult<PagingResult<PostCollectDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostCollect> page = postCollectService.page(pageIndex, pageSize);
        PagingResult<PostCollectDto> convert = page.convert(item -> {
            PostCollectDto postCollectDto = new PostCollectDto();
            BeanUtils.copyProperties(item, postCollectDto);
            return postCollectDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postCollect/{id}")
    @ApiOperation("收藏表详情")
    public JsonResult<PostCollectDto> detail(@PathVariable("id") Long id) {

        PostCollect postCollect = postCollectService.get(id);

        PostCollectDto postCollectDto = new PostCollectDto();
        BeanUtils.copyProperties(postCollect, postCollectDto);

        return JsonResult.success(postCollectDto);
    }

    /**
     * 新增
     *
     * @param postCollectCreateModel
     * @return
     */
    @PostMapping("/postCollect")
    @ApiOperation("收藏表新增")
    public JsonResult<PostCollectDto> create(@Validated @RequestBody PostCollectCreateModel postCollectCreateModel) {

        PostCollect postCollect = new PostCollect();
        BeanUtils.copyProperties(postCollectCreateModel, postCollect);
        postCollectService.save(postCollect);

        PostCollectDto postCollectDto = new PostCollectDto();
        BeanUtils.copyProperties(postCollect, postCollectDto);

        return JsonResult.success(postCollectDto);

    }

    /**
     * 修改
     *
     * @param postCollectUpdateModel
     * @return
     */
    @PutMapping("/postCollect")
    @ApiOperation("收藏表修改")
    public JsonResult<PostCollectDto> update(@Validated @RequestBody PostCollectUpdateModel postCollectUpdateModel) {

        PostCollect postCollect = postCollectService.modify(postCollectUpdateModel);

        PostCollectDto postCollectDto = new PostCollectDto();
        BeanUtils.copyProperties(postCollect, postCollectDto);
        return JsonResult.success(postCollectDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postCollect/{id}")
    @ApiOperation("收藏表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postCollectService.delete(id);

        return JsonResult.success("删除成功");
    }

}
