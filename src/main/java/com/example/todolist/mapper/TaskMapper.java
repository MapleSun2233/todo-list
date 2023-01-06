package com.example.todolist.mapper;

import com.example.todolist.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.todolist.vo.DefaultGroupTaskCountVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 任务表 Mapper 接口
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
public interface TaskMapper extends BaseMapper<Task> {
    /**
     * 统计任务
     * @return 基本任务统计信息
     */
    DefaultGroupTaskCountVo analysisDefaultGroupTask();

    /**
     * 根据分组id统计任务数量
     * @param groupId 分组id
     * @return 任务数量
     */

    Integer countByGroupId(@Param("groupId") Integer groupId);
}
