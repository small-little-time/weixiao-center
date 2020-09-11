package com.zjw.graduation.controller.post;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostContentAppDetailViewDto;
import com.zjw.graduation.dto.post.PostContentAppViewDto;
import com.zjw.graduation.dto.post.PostContentDto;
import com.zjw.graduation.dto.post.PostContentViewDto;
import com.zjw.graduation.entity.post.PostContent;
import com.zjw.graduation.entity.school.SchoolAcademy;
import com.zjw.graduation.model.post.PostContentCreateModel;
import com.zjw.graduation.model.post.PostContentUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.post.PostContentService;
import com.zjw.graduation.service.school.SchoolAcademyService;
import com.zjw.graduation.view.post.PostContentAppDetailView;
import com.zjw.graduation.view.post.PostContentAppView;
import com.zjw.graduation.view.post.PostContentView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 发布内容表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@RestController("PostContentController")
@RequestMapping("/post")
@Api(value = "post.PostContentController", tags = {"发布内容表"})
public class PostContentController {

    @Autowired
    private PostContentService postContentService;

    @Autowired
    private SchoolAcademyService schoolAcademyService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postContents")
    @ApiOperation("发布内容表列表")
    public JsonResult<PagingResult<PostContentViewDto>> list(@RequestParam(value = "truename",defaultValue = "")String truename,
                                                             @RequestParam(value = "academyid",defaultValue = "0")Long academyId,
                                                             @RequestParam(value = "categoryid",defaultValue = "0")Long categoryId,
                                                             @RequestParam(value = "reviewstate",defaultValue = "0")int reviewState,
                                                             @RequestParam(value = "state",defaultValue = "0")int state,
                                                             @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                             @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostContentView> page = postContentService.page(truename, academyId, categoryId, reviewState, state, pageIndex, pageSize);
        PagingResult<PostContentViewDto> convert = page.convert(item -> {
            PostContentViewDto postContentViewDto = new PostContentViewDto();
            BeanUtils.copyProperties(item, postContentViewDto);
            return postContentViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/app/postContents")
    @ApiOperation("app-发布内容列表")
    public JsonResult<PagingResult<PostContentAppViewDto>> appList(@RequestParam(value = "valuecontent", defaultValue = "") String valueContent,
                              @RequestParam(value = "sex", defaultValue = "0") int sex,
                              @RequestParam(value = "category", defaultValue = "") String category,
                              @RequestParam(value = "departmentid", defaultValue = "0") Long departmentId,
                              @RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                              @RequestParam(value = "pagesize", defaultValue = "10") int pageSize){
        PagingResult<PostContentAppView> page = postContentService.appList(valueContent, sex, category, departmentId, pageIndex, pageSize);
        PagingResult<PostContentAppViewDto> convert = page.convert(item -> {
            PostContentAppViewDto postContentAppViewDto = new PostContentAppViewDto();
            BeanUtils.copyProperties(item, postContentAppViewDto);
            if (item.getImages() != null && !item.getImages().equals("")) {
                postContentAppViewDto.setImages(item.getImages().split(";"));
            }
            return postContentAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/app/hot/postContents")
    @ApiOperation("app-发布内容热门")
    public JsonResult<PagingResult<PostContentAppViewDto>> appHotList(@RequestParam(value = "pageindex", defaultValue = "0") int pageIndex,
                                                                      @RequestParam(value = "pagesize", defaultValue = "10") int pageSize){
        PagingResult<PostContentAppView> page = postContentService.appHotList(pageIndex, pageSize);
        PagingResult<PostContentAppViewDto> convert = page.convert(item -> {
            PostContentAppViewDto postContentAppViewDto = new PostContentAppViewDto();
            BeanUtils.copyProperties(item, postContentAppViewDto);
            if (item.getImages() != null && !item.getImages().equals("")) {
                postContentAppViewDto.setImages(item.getImages().split(";"));
            }
            return postContentAppViewDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
//    @GetMapping("/postContent/{id}")
//    @ApiOperation("发布内容表详情")
//    public JsonResult<PostContentDto> detail(@PathVariable("id") Long id) {
//
//        PostContent postContent = postContentService.get(id);
//
//        PostContentDto postContentDto = new PostContentDto();
//        BeanUtils.copyProperties(postContent, postContentDto);
//
//        return JsonResult.success(postContentDto);
//    }

    @GetMapping("/postContent/{id}")
    @ApiOperation("发布内容表详情")
    public JsonResult<PostContentAppDetailViewDto> detail(@PathVariable("id") Long id,
                                                          @RequestParam("studentid") Long studentId) {

        PostContentAppDetailView postContentAppDetailView = postContentService.getDetail(id, studentId);

        PostContentAppDetailViewDto postContentAppDetailViewDto = new PostContentAppDetailViewDto();
        BeanUtils.copyProperties(postContentAppDetailView, postContentAppDetailViewDto);
        if (postContentAppDetailView.getImages() != null && !postContentAppDetailView.getImages().equals("")){
            postContentAppDetailViewDto.setImage(postContentAppDetailViewDto.getImages().split(";"));
        }
        return JsonResult.success(postContentAppDetailViewDto);
    }



    /**
     * 新增
     *
     * @param postContentCreateModel
     * @return
     */
    @PostMapping("/postContent")
    @ApiOperation("发布内容表新增")
    public JsonResult<PostContentDto> create(@Validated @RequestBody PostContentCreateModel postContentCreateModel) {

        PostContent postContent = new PostContent();
        BeanUtils.copyProperties(postContentCreateModel, postContent);
        SchoolAcademy schoolAcademy = schoolAcademyService.findByStudentAcademyId(postContentCreateModel.getStudentId());
        postContent.setAcademyId(schoolAcademy.getId());
        postContentService.save(postContent);

        PostContentDto postContentDto = new PostContentDto();
        BeanUtils.copyProperties(postContent, postContentDto);

        return JsonResult.success(postContentDto);

    }

    /**
     * 修改
     *
     * @param postContentUpdateModel
     * @return
     */
    @PutMapping("/postContent")
    @ApiOperation("发布内容表修改")
    public JsonResult<PostContent> update(@Validated @RequestBody PostContentUpdateModel postContentUpdateModel) {

        PostContent postContent = postContentService.get(postContentUpdateModel.getId());
        if (postContent.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(postContentUpdateModel, postContent, NullPropertyUtils.getNullPropertyNames(postContentUpdateModel));
        postContent.setUpdated(LocalDateTime.now());
        PostContent entity = postContentService.update(postContent);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postContent/{id}")
    @ApiOperation("发布内容表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postContentService.delete(id);

        return JsonResult.success("删除成功");
    }

    @PutMapping("/postContent/enableordisable")
    @ApiOperation("发布内容表禁用启用")
    public JsonResult enableOrDisable(@RequestParam("id") Long id) {

        postContentService.enableOrDisable(id);

        return JsonResult.success("操作成功");
    }

    @PutMapping("/postContent/review")
    @ApiOperation("发布内容表审核")
    public JsonResult review(@RequestParam("id") Long id,
                             @RequestParam("reviewstate") int reviewState) {

        postContentService.review(id, reviewState);

        return JsonResult.success("操作成功");
    }

    @PutMapping("/postContent/batchreview")
    @ApiOperation("发布内容表批量通过")
    public JsonResult batchReview(@RequestParam("ids") String ids,
                                  @RequestParam("reviewstate") int reviewState) {

        postContentService.batchReview(ids, reviewState);

        return JsonResult.success("操作成功");
    }

}
