package com.example.todolist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 分组表
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@Getter
@Setter
@Builder
@TableName("t_group")
@ApiModel(value = "Group对象", description = "分组表")
public class Group {
    @NotNull
    @Min(0)
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull
    @NotEmpty
    @Length(max = 20)
    @ApiModelProperty("分组名")
    private String name;

    @NotNull
    @Min(0)
    @ApiModelProperty("图标id")
    private Integer iconId;


}
