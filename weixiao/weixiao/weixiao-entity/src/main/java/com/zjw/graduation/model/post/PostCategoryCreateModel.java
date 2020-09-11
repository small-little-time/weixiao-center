package com.zjw.graduation.model.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 内容类别表
 *
 * @author zjw
 * @email zhangjw9898@qq.com
 * @date 2020-02-25 17:09:07
 */
@ApiModel(value = "post.PostCategoryCreateModel", description = "内容类别表")
public class PostCategoryCreateModel {

		
		/**
		 * 类别名称
		 */
								@Size(min = 0, max = 65535, message = "类别名称 长度需要在0和65535之间")
					

									@ApiModelProperty(value = "类别名称")
							private String categoryName;

				
			public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
				
}
