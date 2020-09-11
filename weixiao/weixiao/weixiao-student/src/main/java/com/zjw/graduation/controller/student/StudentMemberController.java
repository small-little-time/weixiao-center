package com.zjw.graduation.controller.student;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.post.PostActivityAppViewDto;
import com.zjw.graduation.dto.post.PostContentAppViewDto;
import com.zjw.graduation.dto.post.PostInfoDto;
import com.zjw.graduation.dto.student.StuInfoDto;
import com.zjw.graduation.dto.student.StudentMemberDto;
import com.zjw.graduation.dto.student.StudentMemberViewDto;
import com.zjw.graduation.entity.common.CommonArea;
import com.zjw.graduation.entity.school.SchoolAcademy;
import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.entity.student.StudentPermission;
import com.zjw.graduation.model.student.StudentMemberCreateModel;
import com.zjw.graduation.model.student.StudentMemberLoginModel;
import com.zjw.graduation.model.student.StudentMemberUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.common.CommonAreaService;
import com.zjw.graduation.service.post.PostActivityService;
import com.zjw.graduation.service.post.PostContentService;
import com.zjw.graduation.service.school.SchoolAcademyService;
import com.zjw.graduation.service.student.StudentMemberService;
import com.zjw.graduation.service.student.StudentSettingService;
import com.zjw.graduation.util.JwtTokenUtil;
import com.zjw.graduation.view.post.PostActivityAppView;
import com.zjw.graduation.view.post.PostContentAppView;
import com.zjw.graduation.view.post.PostInfoView;
import com.zjw.graduation.view.stu.StudentMemberView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 学生表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2019-11-25 10:30:03
 */
@RestController("StudentMemberController")
@RequestMapping("/student")
@Api(value = "student.StudentMemberController", tags = {"学生表"})
public class StudentMemberController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentMemberController.class);

    @Autowired
    private StudentMemberService studentMemberService;
    @Autowired
    private SchoolAcademyService schoolAcademyService;
    @Autowired
    private CommonAreaService commonAreaService;
    @Autowired
    private StudentSettingService studentSettingService;
    @Autowired
    private PostContentService postContentService;
    @Autowired
    private PostActivityService postActivityService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${face.boy}")
    private String boy;
    @Value("${face.girl}")
    private String girl;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public JsonResult login(@RequestBody StudentMemberLoginModel model, BindingResult result) {
        LOGGER.info("model.getUsername() = {}, " , model.getUsername());
        String token = studentMemberService.login(model.getUsername(), model.getPassword());
        if (token == null) {
            return JsonResult.error("用户名或密码错误");
        }
        if (token.equals("fail")){
            return JsonResult.error("账号被禁用");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return JsonResult.success(tokenMap);
    }

    @ApiModelProperty("退出登录")
    @PostMapping("/logout")
    public JsonResult logout(){
        return JsonResult.success("");
    }

    @ApiOperation("根据token获取学生信息")
    @GetMapping("/info")
    public JsonResult<StuInfoDto> getPermissionList(@RequestParam(value = "token") String token) {
        String username = jwtTokenUtil.getUserNameFromToken(token);
        StuInfoDto stuInfoDto = new StuInfoDto();
        StudentMember studentMember = studentMemberService.getStudentByUsername(username);
        List<StudentPermission> studentPermissions = studentMemberService.getPermissionList(studentMember.getId());
        List<String> roles = studentPermissions.stream().map(StudentPermission::getIcon).collect(Collectors.toList());
        SchoolAcademy schoolAcademy = schoolAcademyService.get(studentMember.getAcademyId());
        BeanUtils.copyProperties(studentMember, stuInfoDto);
        stuInfoDto.setRoles(roles);
        stuInfoDto.setAcademy(schoolAcademy.getAcademyName());
        return JsonResult.success(stuInfoDto);
    }

//    /**
//     * 列表
//     *
//     * @return
//     */
//    @GetMapping("/studentMembers")
//    @ApiOperation("学生表列表")
//    public JsonResult<PagingResult<StudentMemberDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
//                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {
//
//        PagingResult<StudentMember> page = studentMemberService.page(pageIndex, pageSize);
//        PagingResult<StudentMemberDto> convert = page.convert(item -> {
//            StudentMemberDto studentMemberDto = new StudentMemberDto();
//            BeanUtils.copyProperties(item, studentMemberDto);
//            return studentMemberDto;
//        });
//        return JsonResult.success(convert);
//    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/studentMember/{id}")
    @ApiOperation("学生表详情")
    public JsonResult<StudentMemberDto> detail(@PathVariable("id") Long id) {

        StudentMember studentMember = studentMemberService.get(id);

        StudentMemberDto studentMemberDto = new StudentMemberDto();
        BeanUtils.copyProperties(studentMember, studentMemberDto);

        return JsonResult.success(studentMemberDto);
    }

    /**
     * 新增
     *
     * @param
     * @return
     */
    @PostMapping("/register")
    @ApiOperation("学生注册")
    public JsonResult<StudentMemberDto> create(@RequestParam("username")String username,
                                               @RequestParam("password")String password) {

        StudentMember studentMember = new StudentMember();
        studentMember.setUsername(username);
        studentMember.setPassword(password);
        StudentMember save = studentMemberService.save(studentMember);
        if (save == null){
            return JsonResult.error("用户名已存在！！！");
        }
        StudentMemberDto studentMemberDto = new StudentMemberDto();
        BeanUtils.copyProperties(studentMember, studentMemberDto);
        String token = studentMemberService.login(username, password);
        return JsonResult.success(tokenHead + token, studentMemberDto);

    }

    @PostMapping("/adm/register")
    public JsonResult<StudentMemberDto> create(@Validated @RequestBody StudentMemberCreateModel studentMemberCreateModel){
        StudentMember studentMember = new StudentMember();
        BeanUtils.copyProperties(studentMemberCreateModel, studentMember, NullPropertyUtils.getNullPropertyNames(studentMemberCreateModel));
        StudentMember entity = studentMemberService.saveAmd(studentMember);
        StudentMemberDto studentMemberDto = new StudentMemberDto();
        BeanUtils.copyProperties(entity, studentMemberDto);
        return JsonResult.success(studentMemberDto);
    }

    @PostMapping("/canregister")
    @ApiOperation("判断用户名是否存在")
    public JsonResult canregister(@RequestParam("username")String username){
        StudentMember studentByUsername = studentMemberService.getStudentByUsername(username);
        if (studentByUsername == null){
            return JsonResult.success("可以注册！！！");
        }
        return JsonResult.error(0,"用户已存在！！！",1);
    }

    /**
     * 修改
     *
     * @param studentMemberUpdateModel
     * @return
     */
    @PutMapping("/studentMember")
    @ApiOperation("学生表修改")
    public JsonResult<StudentMemberDto> update(@Validated @RequestBody StudentMemberUpdateModel studentMemberUpdateModel) {

        StudentMember studentMember = studentMemberService.get(studentMemberUpdateModel.getId());
        if (studentMember.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentMemberUpdateModel, studentMember, NullPropertyUtils.getNullPropertyNames(studentMemberUpdateModel));
        CommonArea commonArea = commonAreaService.findByNumber(studentMemberUpdateModel.getAreaId().intValue());
        studentMember.setArea(studentMemberUpdateModel.getAreaName());
        studentMember.setAreaId(commonArea.getId());
        studentMember.setUpdated(LocalDateTime.now());
        if (studentMember.getSex() == 2){
            studentMember.setFaceImg(girl);
            studentMember.setFaceImgMin(girl);
        } else {
            studentMember.setFaceImg(boy);
            studentMember.setFaceImgMin(boy);
        }
        StudentMember entity = studentMemberService.update(studentMember);
        studentSettingService.setByStudentId(entity.getId(), studentMemberUpdateModel.getChat(), studentMemberUpdateModel.getSexs(), studentMemberUpdateModel.getAcademy());
        StudentMemberDto studentMemberDto = new StudentMemberDto();
        BeanUtils.copyProperties(entity, studentMemberDto);

        return JsonResult.success(studentMemberDto);
    }

    @PutMapping("/updateinfo")
    @ApiOperation("学生表修改")
    public JsonResult<StudentMemberDto> updateInfo(@RequestBody StudentMemberUpdateModel studentMemberUpdateModel) {
        StudentMember studentMember = studentMemberService.get(studentMemberUpdateModel.getId());
        if (studentMember.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(studentMemberUpdateModel, studentMember, NullPropertyUtils.getNullPropertyNames(studentMemberUpdateModel));
        if (studentMemberUpdateModel.getAreaId() != null){
            CommonArea commonArea = commonAreaService.findByNumber(studentMemberUpdateModel.getAreaId().intValue());
            studentMember.setArea(studentMemberUpdateModel.getAreaName());
            studentMember.setAreaId(commonArea.getId());
            studentMember.setUpdated(LocalDateTime.now());
        }

        StudentMember entity = studentMemberService.update(studentMember);
        StudentMemberDto studentMemberDto = new StudentMemberDto();
        BeanUtils.copyProperties(entity, studentMemberDto);

        return JsonResult.success(studentMemberDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/studentMember/{id}")
    @ApiOperation("学生表删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        studentMemberService.delete(id);

        return JsonResult.success("删除成功");
    }

    @PutMapping("/studentMember/disableorenable/{id}")
    @ApiOperation("学生表禁用/启用")
    public JsonResult disableOrEnable(@PathVariable("id") Long id){
        studentMemberService.disableOrEnable(id);
        return JsonResult.success("操作成功");
    }

    @GetMapping("/studentMember/check")
    @ApiOperation("学生表用户查询")
    public boolean check(@RequestParam("username") String username){
        StudentMember studentMember = studentMemberService.check(username);
        return studentMember == null;
    }

    @GetMapping("/studentMembers")
    @ApiOperation("学生表视图列表")
    public JsonResult<PagingResult<StudentMemberViewDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                               @RequestParam(value = "pagesize",defaultValue = "10")int pageSize,
                                                               @RequestParam(value = "username",defaultValue = "")String username,
                                                               @RequestParam(value = "sex",defaultValue = "0")int sex,
                                                               @RequestParam(value = "academyid",defaultValue = "0") Long academyId,
                                                               @RequestParam(value = "areaid",defaultValue = "0") Long areaId,
                                                               @RequestParam(value = "state",defaultValue = "2") Long state) {
        PagingResult<StudentMemberView> page =
                studentMemberService.getStudentViewList(username, sex, academyId, areaId, state, pageIndex, pageSize);
        PagingResult<StudentMemberViewDto> convert = page.convert(item -> {
            StudentMemberViewDto studentMemberViewDto = new StudentMemberViewDto();
            BeanUtils.copyProperties(item, studentMemberViewDto);
            return studentMemberViewDto;
        });
        return JsonResult.success(convert);
    }

    @PutMapping("/studentMember/batchdelete")
    @ApiOperation("学生表批量删除")
    public JsonResult batchDelete(@RequestParam("ids") String ids){
        List<Long> collect =
                Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        studentMemberService.batchDelete(collect);
        return JsonResult.success("批量禁用成功");
    }

    @PutMapping("/studentMember/updateface")
    @ApiOperation("修改头像")
    public JsonResult<StudentMember> updateFace(@RequestBody StudentMemberUpdateModel model){
        StudentMember studentMember = studentMemberService.updateFace(model.getId(), model.getFaceImg());
        if (studentMember == null){
            return JsonResult.error("出现错误！");
        }
        return JsonResult.success(studentMember);
    }

    @GetMapping("/studentMember/postinfo")
    @ApiOperation("获取我的发布数量")
    public JsonResult<PostInfoDto> getPostInfo(@RequestParam("id") Long id){
        PostInfoView postInfoView = studentMemberService.getPostInfo(id);
        PostInfoDto postInfoDto = new PostInfoDto();
        BeanUtils.copyProperties(postInfoView, postInfoDto);
        return JsonResult.success(postInfoDto);
    }

    @GetMapping("/studentMember/collect")
    @ApiOperation("获取我的收藏")
    public JsonResult<PagingResult<PostContentAppViewDto>> getMyCollect(@RequestParam("id") Long id,
                                                                       @RequestParam(value = "pageindex", defaultValue = "0")int pageIndex,
                                                                       @RequestParam(value = "pagesize", defaultValue = "5") int pageSize){
        PagingResult<PostContentAppView> postContentAppView = postContentService.getMyCollect(id, pageIndex, pageSize);
        PagingResult<PostContentAppViewDto> convert = postContentAppView.convert(item -> {
            PostContentAppViewDto postContentAppViewDto = new PostContentAppViewDto();
            BeanUtils.copyProperties(item, postContentAppViewDto);
            if (item.getImages() != null && !item.getImages().equals("")) {
                postContentAppViewDto.setImages(item.getImages().split(";"));
            }
            return postContentAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/studentMember/content")
    @ApiOperation("获取我的发布")
    public JsonResult<PagingResult<PostContentAppViewDto>> getMyContent(@RequestParam("id") Long id,
                                                                       @RequestParam(value = "pageindex", defaultValue = "0")int pageIndex,
                                                                       @RequestParam(value = "pagesize", defaultValue = "5") int pageSize){
        PagingResult<PostContentAppView> postContentAppView = postContentService.getMyContent(id, pageIndex, pageSize);
        PagingResult<PostContentAppViewDto> convert = postContentAppView.convert(item -> {
            PostContentAppViewDto postContentAppViewDto = new PostContentAppViewDto();
            BeanUtils.copyProperties(item, postContentAppViewDto);
            if (item.getImages() != null && !item.getImages().equals("")) {
                postContentAppViewDto.setImages(item.getImages().split(";"));
            }
            return postContentAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/studentMember/activity")
    @ApiOperation("获取我的活动发布")
    public JsonResult<PagingResult<PostActivityAppViewDto>> getMyPublish(@RequestParam("id") Long id,
                                                                         @RequestParam(value = "pageindex", defaultValue = "0")int pageIndex,
                                                                         @RequestParam(value = "pagesize", defaultValue = "5") int pageSize){
        PagingResult<PostActivityAppView> postContentAppView = postActivityService.getMyPublish(id, pageIndex, pageSize);
        PagingResult<PostActivityAppViewDto> convert = postContentAppView.convert(item -> {
            PostActivityAppViewDto postActivityAppViewDto = new PostActivityAppViewDto();
            BeanUtils.copyProperties(item, postActivityAppViewDto);
            if (item.getImage() != null && !item.getImage().equals("")) {
                postActivityAppViewDto.setImages(item.getImage().split(";"));
            }
            return postActivityAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/studentMember/participation")
    @ApiOperation("获取我的活动参与")
    public JsonResult<PagingResult<PostActivityAppViewDto>> getMyParticipation(@RequestParam("id") Long id,
                                                                         @RequestParam(value = "pageindex", defaultValue = "0")int pageIndex,
                                                                         @RequestParam(value = "pagesize", defaultValue = "5") int pageSize){
        PagingResult<PostActivityAppView> postContentAppView = postActivityService.getMyParticipation(id, pageIndex, pageSize);
        PagingResult<PostActivityAppViewDto> convert = postContentAppView.convert(item -> {
            PostActivityAppViewDto postActivityAppViewDto = new PostActivityAppViewDto();
            BeanUtils.copyProperties(item, postActivityAppViewDto);
            if (item.getImage() != null && !item.getImage().equals("")) {
                postActivityAppViewDto.setImages(item.getImage().split(";"));
            }
            return postActivityAppViewDto;
        });
        return JsonResult.success(convert);
    }

    @GetMapping("/studentMember/myfollow")
    @ApiOperation("获取我的关注")
    public JsonResult<PagingResult<StudentMemberViewDto>> getMyFollow(@RequestParam("id") Long id,
                                                                      @RequestParam(value = "pageindex", defaultValue = "0")int pageIndex,
                                                                      @RequestParam(value = "pagesize", defaultValue = "5") int pageSize){
        PagingResult<StudentMemberView> pagingResult = studentMemberService.getMyFollow(id, pageIndex, pageSize);
        PagingResult<StudentMemberViewDto> convert = pagingResult.convert(item -> {
            StudentMemberViewDto studentMemberViewDto = new StudentMemberViewDto();
            BeanUtils.copyProperties(item, studentMemberViewDto);
            return studentMemberViewDto;
        });
        return JsonResult.success(convert);
    }
}
