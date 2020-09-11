package com.zjw.graduation.service.student.impl;

import com.zjw.graduation.enums.EnumHandlerStateType;
import com.zjw.graduation.enums.EnumStateType;
import com.zjw.graduation.enums.EnumStatusType;
import org.springframework.data.domain.Page;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.enums.EnumLogicType;
import com.zjw.graduation.entity.student.StudentReport;
import com.zjw.graduation.repository.student.StudentReportDao;
import com.zjw.graduation.service.student.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service("studentReportService")
public class StudentReportServiceImpl implements StudentReportService  {

    @Autowired
    private StudentReportDao studentReportDao;

    public PagingResult<StudentReport> page(int state, int pageIndex, int pageSize){
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        Page<StudentReport> page = studentReportDao.findAll(state, pageable);

        PagingResult<StudentReport> pagingResult = new PagingResult<>();
        pagingResult.setPageIndex(pageIndex);
        pagingResult.setPageSize(pageSize);
        pagingResult.setEntities(page.getContent());
        pagingResult.setTotalRecords(page.getTotalElements());

        return pagingResult;
    }

    @Override
    public StudentReport get(Long id) {
        return studentReportDao.findById(id).orElse(new StudentReport());
    }

    @Override
    public StudentReport save(StudentReport studentReport) {
        return studentReportDao.save(studentReport);
    }

    @Override
    public StudentReport update(StudentReport studentReport) {
        return studentReportDao.save(studentReport);
    }

    @Override
    public void delete(Long id) {
        StudentReport studentReport = studentReportDao.findById(id).orElse(null);
        if (studentReport != null){
            studentReport.setLogicFlag(EnumLogicType.DELETE.getValue());
            studentReportDao.save(studentReport);
        }
    }

    @Override
    public void reply(Long id, String content) {
        StudentReport studentReport = studentReportDao.findById(id).orElse(null);
        if (studentReport != null){
            studentReport.setState(EnumHandlerStateType.Finish.getValue());
            studentReport.setReply(content);
            studentReport.setUpdated(LocalDateTime.now());
            studentReportDao.save(studentReport);
        }
    }

    @Override
    public void batchReply(String ids, String content) {
        List<Long> collect =
                Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        LocalDateTime now = LocalDateTime.now();
        studentReportDao.batchReply(collect, content, now);
    }

}
