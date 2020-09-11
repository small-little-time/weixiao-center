package com.zjw.graduation.controller.common;


import com.zjw.graduation.data.NullPropertyUtils;
import com.zjw.graduation.data.PagingResult;
import com.zjw.graduation.dto.common.CommonAreaDto;
import com.zjw.graduation.entity.common.CommonArea;
import com.zjw.graduation.model.common.CommonAreaCreateModel;
import com.zjw.graduation.model.common.CommonAreaUpdateModel;
import com.zjw.graduation.mvc.JsonResult;
import com.zjw.graduation.service.common.CommonAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-03-23 10:04:49
 */
@RestController("CommonAreaController")
@RequestMapping("/common")
@Api(value = "common.CommonAreaController", tags = {""})
public class CommonAreaController {

    @Autowired
    private CommonAreaService commonAreaService;

    /**
     * 列表
     *
     * @return
     */
    @GetMapping("/commonAreas")
    @ApiOperation("列表")
    public JsonResult<PagingResult<CommonAreaDto>> list(@RequestParam(value = "pageindex",defaultValue = "0")int pageIndex,
                                                          @RequestParam(value = "pagesize",defaultValue = "10")int pageSize) {

        PagingResult<CommonArea> page = commonAreaService.page(pageIndex, pageSize);
        PagingResult<CommonAreaDto> convert = page.convert(item -> {
            CommonAreaDto commonAreaDto = new CommonAreaDto();
            BeanUtils.copyProperties(item, commonAreaDto);
            return commonAreaDto;
        });
        return JsonResult.success(convert);
    }


    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/commonArea/{id}")
    @ApiOperation("详情")
    public JsonResult<CommonAreaDto> detail(@PathVariable("id") Long id) {

        CommonArea commonArea = commonAreaService.get(id);

        CommonAreaDto commonAreaDto = new CommonAreaDto();
        BeanUtils.copyProperties(commonArea, commonAreaDto);

        return JsonResult.success(commonAreaDto);
    }

    /**
     * 新增
     *
     * @param commonAreaCreateModel
     * @return
     */
    @PostMapping("/commonArea")
    @ApiOperation("新增")
    public JsonResult<CommonAreaDto> create(@Validated @RequestBody CommonAreaCreateModel commonAreaCreateModel) {

        CommonArea commonArea = new CommonArea();
        BeanUtils.copyProperties(commonAreaCreateModel, commonArea);
        commonAreaService.save(commonArea);

        CommonAreaDto commonAreaDto = new CommonAreaDto();
        BeanUtils.copyProperties(commonArea, commonAreaDto);

        return JsonResult.success(commonAreaDto);

    }

    /**
     * 修改
     *
     * @param commonAreaUpdateModel
     * @return
     */
    @PutMapping("/commonArea")
    @ApiOperation("修改")
    public JsonResult<CommonAreaDto> update(@Validated @RequestBody CommonAreaUpdateModel commonAreaUpdateModel) {

        CommonArea commonArea = commonAreaService.get(commonAreaUpdateModel.getId());
        if (commonArea.getId() == null){
            return JsonResult.error("Not find entity");
        }
        BeanUtils.copyProperties(commonAreaUpdateModel, commonArea, NullPropertyUtils.getNullPropertyNames(commonAreaUpdateModel));
        CommonArea entity = commonAreaService.update(commonArea);

        CommonAreaDto commonAreaDto = new CommonAreaDto();
        BeanUtils.copyProperties(entity, commonAreaDto);

        return JsonResult.success(commonAreaDto);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/commonArea/{id}")
    @ApiOperation("删除")
    public JsonResult delete(@PathVariable("id") Long id) {

        commonAreaService.delete(id);

        return JsonResult.success("删除成功");
    }

}
