package com.example.todolist.vo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author Maple
 * @since 2023/1/3
 **/
@Builder
@Getter
public class DefaultGroupTaskCountVo {
    private Integer all;
    private Integer completed;
    private Integer uncompleted;
    private Integer star;
}
