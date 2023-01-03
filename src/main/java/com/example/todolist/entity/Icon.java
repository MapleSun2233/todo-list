package com.example.todolist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 图标表
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@Getter
@Setter
@Builder
@TableName("t_icon")
@ApiModel(value = "Icon对象", description = "图标表")
public class Icon {

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("图标url")
    private String url;


}
