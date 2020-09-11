package com.zjw.graduation.controller.post;


import com.zjw.graduation.dto.post.PostActivityAppDetailViewDto;
import com.zjw.graduation.dto.post.PostActivityAppViewDto;
import com.zjw.graduation.dto.post.PostActivityViewDto;
import com.zjw.graduation.entity.school.SchoolAcademy;
import com.zjw.graduation.service.post.PostActivityService;
import com.zjw.graduation.model.post.PostActivityCreateModel;
import com.zjw.graduation.model.post.PostActivityUpdateModel;
import com.zjw.graduation.entity.post.PostActivity;
import com.zjw.graduation.dto.post.PostActivityDto;
import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.service.school.SchoolAcademyService;
import com.zjw.graduation.view.post.PostActivityAppDetailView;
import com.zjw.graduation.view.post.PostActivityAppView;
import com.zjw.graduation.view.post.PostActivityView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;


/**
 * 活动发布表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-26 16:27:41
 */
@RestController("PostActivityController")
@RequestMapping("/post")
@Api(value = "post.PostActivityController", tags = {"活动发布表"})
public class PostActivityController {

    @Autowired
    private PostActivityService postActivityService;

    @Autowired
    private SchoolAcademyService schoolAcademyService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/postActivities")
    @ApiOperation("活动发布表列表")
    public JsonResult<PagingResult<PostActivityViewDto>> list(@RequestParam(value = "truename",defaultValue = "")String truename,
                                                              @RequestParam(value = "title",defaultValue = "")String title,
                                                              @RequestParam(value = "categoryid",defaultValue = "0")Long categoryId,
                                                              @RequestParam(value = "academyid",defaultValue = "0")Long academyId,
                                                              @RequestParam(value = "type",defaultValue = "0")int type,
                                                              @RequestParam(value = "state",defaultValue = "0")int state,
                                                              @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                              @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<PostActivityView> page =
                postActivityService.page(truename, title, categoryId, academyId, type ,state, pageIndex, pageSize);
        PagingResult<PostActivityViewDto> convert = page.convert(item -> {
            PostActivityViewDto postActivityViewDto = new PostActivityViewDto();
            BeanUtils.copyProperties(item, postActivityViewDto);
            return postActivityViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/app/postActivities")
    @ApiOperation("app-活动发布表列表")
    public JsonResult<PagingResult<PostActivityAppViewDto>> appList(@RequestParam(value = "title", defaultValue = "") String title,
                                                                 @RequestParam(value = "sex", defaultValue = "0") int sex,
                                                                 @RequestParam(value = "activitystate", defaultValue = "0") int activityState,
                                                                 @RequestParam(value = "activitytype", defaultValue = "0") int activityType,
                                                                 @RequestParam(value = "activitytime", defaultValue = "") String activityTime,
                                                                 @RequestParam(value = "category", defaultValue = "") String category,
                                                                 @RequestParam(value = "departmentid", defaultValue = "0") Long departmentId,
                                                                 @RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                                 @RequestParam(value = "pagesize",defaultValue = "10")int pageSize){
        PagingResult<PostActivityAppView> pagingResult =
                postActivityService.appList(title, sex, activityState, activityType, activityTime ,category, departmentId, pageIndex, pageSize);
        PagingResult<PostActivityAppViewDto> convert = pagingResult.convert(item -> {
            PostActivityAppViewDto postActivityAppViewDto = new PostActivityAppViewDto();
            BeanUtils.copyProperties(item, postActivityAppViewDto);
            if (item.getImage() != null && !item.getImage().equals("")) {
                postActivityAppViewDto.setImages(item.getImage().split(";"));
            }
            return postActivityAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/app/hot/postActivities")
    @ApiOperation("app-活动发布表热门")
    public JsonResult<PagingResult<PostActivityAppViewDto>> appHotList(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                                    @RequestParam(value = "pagesize",defaultValue = "10")int pageSize){
        PagingResult<PostActivityAppView> pagingResult =
                postActivityService.appHotList(pageIndex, pageSize);
        PagingResult<PostActivityAppViewDto> convert = pagingResult.convert(item -> {
            PostActivityAppViewDto postActivityAppViewDto = new PostActivityAppViewDto();
            BeanUtils.copyProperties(item, postActivityAppViewDto);
            if (item.getImage() != null && !item.getImage().equals("")) {
                postActivityAppViewDto.setImages(item.getImage().split(";"));
            }
            return postActivityAppViewDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/postActivity/{id}")
    @ApiOperation("活动发布表详情")
    public JsonResult<PostActivityDto> detail(@PathVariable("id") Long id) {

        PostActivity postActivity = postActivityService.get(id);

        PostActivityDto postActivityDto = new PostActivityDto();
        BeanUtils.copyProperties(postActivity, postActivityDto);

        return JsonResult.success(postActivityDto);
    }

//    @GetMapping("/postActivity/{id}")
//    @ApiOperation("活动发布表详情")
//    public JsonResult<PostActivityAppDetailViewDto> getDetail(@PathVariable("id") Long id) {
//
//        PostActivityAppDetailView postActivityAppDetail = postActivityService.getDetail(id);
//
//        PostActivityAppDetailViewDto postActivityAppDetailViewDto = new PostActivityAppDetailViewDto();
//        BeanUtils.copyProperties(postActivityAppDetail, postActivityAppDetailViewDto);
//
//        return JsonResult.success(postActivityAppDetailViewDto);
//    }

    /**
     * 新增
     *
     * @param postActivityCreateModel
     * @return
     */
    @PostMapping("/postActivity")
    @ApiOperation("活动发布表新增")
    public JsonResult<PostActivityDto> create(@Validated @RequestBody PostActivityCreateModel postActivityCreateModel) {

        PostActivity postActivity = new PostActivity();
        BeanUtils.copyProperties(postActivityCreateModel, postActivity);
        SchoolAcademy byStudentAcademyId = schoolAcademyService.findByStudentAcademyId(postActivityCreateModel.getStudentId());
        if (byStudentAcademyId == null){
            return JsonResult.error("发布失败，请设置所在专业再试~");
        }
        postActivity.setAcademyId(byStudentAcademyId.getId());
        postActivityService.save(postActivity);

        PostActivityDto postActivityDto = new PostActivityDto();
        BeanUtils.copyProperties(postActivity, postActivityDto);

        return JsonResult.success(postActivityDto);

    }

    /**
     * 修改
     *
     * @param postActivityUpdateModel
     * @return
     */
    @PutMapping("/postActivity")
    @ApiOperation("活动发布表修改")
    public JsonResult<PostActivity> update(@Validated @RequestBody PostActivityUpdateModel postActivityUpdateModel) {

        PostActivity postActivity = postActivityService.get(postActivityUpdateModel.getId());
        if (postActivity.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(postActivityUpdateModel, postActivity, NullPropertyUtils.getNullPropertyNames(postActivityUpdateModel));
        postActivity.setUpdated(LocalDateTime.now());
        PostActivity entity = postActivityService.update(postActivity);

        return JsonResult.success(entity);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/postActivity/{id}")
    @ApiOperation("活动发布表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        postActivityService.delete(id);

        return JsonResult.success("删除成功");
    }

    @PutMapping("/postActivity/cancel/{id}")
    @ApiOperation("活动发布表删除")
    public JsonResult cancel(@PathVariable("id") Long id) {

        postActivityService.cancel(id);

        return JsonResult.success("取消成功");
    }

    @PutMapping("/postActivity/review")
    @ApiOperation("活动发布表审核")
    public JsonResult review(@RequestParam("id") Long id,
                             @RequestParam("state") int state) {

        postActivityService.review(id, state);

        return JsonResult.success("操作成功");
    }

    @PutMapping("/postActivity/batchpass")
    @ApiOperation("活动发布表批量审核")
    public JsonResult batchPass(@RequestParam("ids") String ids,
                             @RequestParam("state") int state) {

        postActivityService.batchPass(ids, state);

        return JsonResult.success("操作成功");
    }

}
