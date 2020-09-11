package com.zjw.graduation.service.student.impl;

import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.entity.student.StudentMember;
import com.zjw.graduation.entity.student.StudentMemberPermissionRelation;
import com.zjw.graduation.entity.student.StudentPermission;
import com.zjw.graduation.entity.student.StudentSetting;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.enums.EnumStateType;
import com.zjw.graduation.repository.post.PostInfoViewDao;
import com.zjw.graduation.repository.student.*;
import com.zjw.graduation.service.student.StudentMemberService;
import com.zjw.graduation.util.JwtTokenUtil;
import com.zjw.graduation.view.post.PostInfoView;
import com.zjw.graduation.view.stu.StudentMemberView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service("studentMemberService")
public class StudentMemberServiceImpl implements StudentMemberService  {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentMemberServiceImpl.class);

    @Autowired
    private StudentMemberDao studentMemberDao;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private StudentMemberPermissionRelationDao studentMemberPermissionRelationDao;

    @Autowired
    private StudentPermissionDao studentPermissionDao;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private StudentMemberViewDao studentMemberViewDao;

    @Autowired
    private PostInfoViewDao postInfoViewDao;

    @Autowired
    private StudentSettingDao studentSettingDao;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    public PagingResult<StudentMember> page(int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentMember> page = studentMemberDao.findAll(pageable);

        PagingResult<StudentMember> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentMember get(Long id) {
        return studentMemberDao.findById(id).orElse(new StudentMember());
    }

    @Override
    @Transactional
    public StudentMember save(StudentMember studentMember) {
        studentMember.setPassword(passwordEncoder.encode(studentMember.getPassword()));
        StudentMember byUsername = studentMemberDao.findByUsernameAndLogicFlagIs(studentMember.getUsername(), EnumLogicType.NORMAL.getValue());
        if (byUsername != null){
            return null;
        }
        StudentMember entity = studentMemberDao.save(studentMember);
        entityManager.refresh(entity);
        // 注册之后默认设置
        StudentSetting studentSetting = new StudentSetting();
        studentSetting.setStudentId(entity.getId());
        studentSettingDao.save(studentSetting);
        return entity;
    }

    @Override
    public void delete(Long id) {
        StudentMember studentMember = studentMemberDao.findById(id).orElse(null);
        if (studentMember != null){
            studentMember.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentMemberDao.save(studentMember);
        }
    }

    @Override
    public StudentMember getStudentByUsername(String username) {
        return studentMemberDao.findByUsernameAndLogicFlagIs(username, EnumLogicType.NORMAL.getValue());
    }

    @Override
    public List<StudentPermission> getPermissionList(Long id) {
        List<StudentMemberPermissionRelation> studentMemberPermissionRelations =
                studentMemberPermissionRelationDao.findAllByStudentIdAndLogicFlagIs(id, EnumLogicType.NORMAL.getValue());
        List<Long> permissionIds = studentMemberPermissionRelations.stream().map(StudentMemberPermissionRelation::getPermissionId).collect(Collectors.toList());
        return studentPermissionDao.findAllByIdInAndLogicFlagIs(permissionIds, EnumLogicType.NORMAL.getValue());
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            if (!userDetails.isEnabled()){
                return "fail";
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
//            StudentMember entity = studentMemberDao.findByUsername(username);
//            entity.setLoginTime(LocalDateTime.now());
//            studentMemberDao.save(entity);
            token = jwtTokenUtil.generateToken(userDetails);
//            redisTemplate.opsForValue().set(username, token, redisExpiration, TimeUnit.SECONDS);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public StudentMember update(StudentMember studentMember) {
        return studentMemberDao.save(studentMember);
    }

    @Override
    public void disableOrEnable(Long id) {
        StudentMember studentMember = studentMemberDao.findById(id).orElse(null);
        if (studentMember != null){
            studentMember.setState(studentMember.getState().equals(EnumStateType.DISABLE.getValue()) ? EnumStateType.NORMAL.getValue() : EnumStateType.DISABLE.getValue());
            studentMemberDao.save(studentMember);
        }
    }

    @Override
    public StudentMember check(String username) {
        return studentMemberDao.findByUsernameAndLogicFlagIs(username, EnumLogicType.NORMAL.getValue());
    }

    @Override
    public PagingResult<StudentMemberView> getStudentViewList(String username, int sex, Long academyId, Long areaId, Long state, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentMemberView> page = studentMemberViewDao.getStudentViewList(username, sex, academyId, areaId, state, pageable);

        PagingResult<StudentMemberView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public void batchDelete(List<Long> collect) {
        LocalDateTime now = LocalDateTime.now();
        studentMemberDao.batchDelete(collect, now);
    }

    @Override
    public StudentMember updateFace(Long id, String avatar) {
        StudentMember studentMember = studentMemberDao.findById(id).orElse(null);
        if (studentMember == null){
            return null;
        }else {
            studentMember.setFaceImgMin(avatar);
            studentMember.setFaceImg(avatar);
            studentMemberDao.save(studentMember);
        }
        return studentMember;
    }

    @Override
    public PostInfoView getPostInfo(Long id) {
        PostInfoView postInfoView = postInfoViewDao.getById(id);
        return postInfoView;
    }

    @Override
    public PagingResult<StudentMemberView> getMyFollow(Long id, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentMemberView> page = studentMemberViewDao.getMyFollow(id, pageable);

        PagingResult<StudentMemberView> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentMember saveAmd(StudentMember studentMember) {
        StudentMember entity = studentMemberDao.findByUsernameAndLogicFlagIs(studentMember.getUsername(), EnumLogicType.NORMAL.getValue());
        if (entity != null ){
            return entity;
        }else {
            return studentMemberDao.save(studentMember);
        }
    }

}
