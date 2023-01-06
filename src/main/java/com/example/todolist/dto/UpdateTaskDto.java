package com.example.todolist.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Maple
 * @since 2023/1/3
 **/
@Data
@ApiModel("更新任务参数")
public class UpdateTaskDto {
    @ApiModelProperty(value = "任务id", required = true)
    @NotNull
    @Min(-1)
    private Integer id;
    @ApiModelProperty(value = "分组id", required = true)
    @NotNull
    @Min(0)
    private Integer groupId;
    @ApiModelProperty(value = "任务名", required = true)
    @NotNull
    @NotEmpty
    @Length(max = 20)
    private String name;
    @ApiModelProperty(value = "任务描述", required = true)
    @Length(max = 255)
    private String description;
    @ApiModelProperty(value = "是否完成", required = true)
    @NotNull
    private Boolean completed;
    @ApiModelProperty(value = "是否星标", required = true)
    @NotNull
    private Boolean star;
}
