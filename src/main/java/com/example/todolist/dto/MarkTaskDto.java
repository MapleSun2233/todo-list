package com.example.todolist.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author Maple
 * @since 2023/1/3
 **/
@Data
@ApiModel("标记任务参数")
public class MarkTaskDto {
    @ApiModelProperty(value = "任务id", required = true)
    @NotNull
    @Min(0)
    private Integer id;
    @NotNull
    @ApiModelProperty(value = "是否完成", required = true)
    private Boolean status;
}
