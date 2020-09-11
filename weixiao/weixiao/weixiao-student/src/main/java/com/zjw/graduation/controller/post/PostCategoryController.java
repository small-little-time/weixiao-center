package com.zjw.graduation.controller.post;


import com.zjw.graduation.service.post.PostCategoryService;
import com.zjw.graduation.model.post.PostCategoryCreateModel;
import com.zjw.graduation.model.post.PostCategoryUpdateModel;
import com.zjw.graduation.entity.post.PostCategory;
import com.zjw.graduation.dto.post.PostCategoryDto;
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
 * 内容类别表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@RestController("PostCategoryController")
@RequestMapping("/post")
@Api(value = "post.PostCategoryController", tags = {"内容类别表"})
public class PostCategoryController {

    @Autowired
    private PostCategoryService postCategoryService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postCategories")
    @ApiOperation("内容类别表列表")
    public JsonResult<PagingResult<PostCategoryDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostCategory> page = postCategoryService.page(pageIndex, pageSize);
        PagingResult<PostCategoryDto> convert = page.convert(item -> {
            PostCategoryDto postCategoryDto = new PostCategoryDto();
            BeanUtils.copyProperties(item, postCategoryDto);
            return postCategoryDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postCategory/{id}")
    @ApiOperation("内容类别表详情")
    public JsonResult<PostCategoryDto> detail(@PathVariable("id") Long id) {

        PostCategory postCategory = postCategoryService.get(id);

        PostCategoryDto postCategoryDto = new PostCategoryDto();
        BeanUtils.copyProperties(postCategory, postCategoryDto);

        return JsonResult.success(postCategoryDto);
    }

    /**
     * 新增
     *
     * @param postCategoryCreateModel
     * @return
     */
    @PostMapping("/postCategory")
    @ApiOperation("内容类别表新增")
    public JsonResult<PostCategoryDto> create(@Validated @RequestBody PostCategoryCreateModel postCategoryCreateModel) {

        PostCategory postCategory = new PostCategory();
        BeanUtils.copyProperties(postCategoryCreateModel, postCategory);
        postCategoryService.save(postCategory);

        PostCategoryDto postCategoryDto = new PostCategoryDto();
        BeanUtils.copyProperties(postCategory, postCategoryDto);

        return JsonResult.success(postCategoryDto);

    }

    /**
     * 修改
     *
     * @param postCategoryUpdateModel
     * @return
     */
    @PutMapping("/postCategory")
    @ApiOperation("内容类别表修改")
    public JsonResult<PostCategory> update(@Validated @RequestBody PostCategoryUpdateModel postCategoryUpdateModel) {

        PostCategory postCategory = postCategoryService.get(postCategoryUpdateModel.getId());
        if (postCategory.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(postCategoryUpdateModel, postCategory, NullPropertyUtils.getNullPropertyNames(postCategoryUpdateModel));
        postCategory.setUpdated(LocalDateTime.now());
        PostCategory entity = postCategoryService.update(postCategory);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postCategory/{id}")
    @ApiOperation("内容类别表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postCategoryService.delete(id);

        return JsonResult.success("删除成功");
    }

}
