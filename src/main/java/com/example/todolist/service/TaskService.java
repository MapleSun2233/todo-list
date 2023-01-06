package com.example.todolist.service;

import com.example.todolist.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.todolist.vo.DefaultGroupTaskCountVo;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
public interface TaskService extends IService<Task> {
    /**
     * 统计任务
     * @return 基本任务统计信息
     */
    DefaultGroupTaskCountVo analysisDefaultGroupTask();
}
