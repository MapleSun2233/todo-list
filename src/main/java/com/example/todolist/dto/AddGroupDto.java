package com.example.todolist.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Maple
 * @Date 2023/1/2
 **/
@Data
@ApiModel(value = "添加分组参数")
public class AddGroupDto {
    @NotNull
    @NotEmpty
    @Length(max = 20)
    @ApiModelProperty(value = "分组名", required = true)
    private String name;
    @NotNull
    @Min(0)
    @ApiModelProperty(value = "图标id", required = true)
    private Integer iconId;
}
