package com.zjw.graduation.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 内容类别表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@ApiModel(value = "post.PostCategoryDto", description = "内容类别表")
public class PostCategoryDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", name = "id", required = true)
    private Long id;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称", name = "categoryName")
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
